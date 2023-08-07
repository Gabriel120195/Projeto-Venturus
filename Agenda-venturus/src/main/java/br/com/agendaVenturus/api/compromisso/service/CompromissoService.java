package br.com.agendaVenturus.api.compromisso.service;


import br.com.agendaVenturus.api.compromisso.entity.Compromisso;
import br.com.agendaVenturus.api.compromisso.repository.CompromissoRepository;
import br.com.agendaVenturus.api.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CompromissoService {

    private final CompromissoRepository compromissoRepository;

    public Compromisso salvarCompromisso(Compromisso compromisso) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Usuario usuario = compromisso.getUsuario();
        LocalDateTime dataHoraInicio = compromisso.getDataHoraInicio();
        LocalDateTime dataHoraFim = compromisso.getDataHoraFim();

        Duration duracao = Duration.between(dataHoraInicio, dataHoraFim);
        compromisso.setDuracao(duracao);

        if (!verificaCompromisso(compromisso)) {
            List<Compromisso> compromissosTeste = compromissoRepository.teste(usuario,dataHoraFim);
            List<Compromisso> compromissosDoUsuario = compromissoRepository.findByUsuarioAndDataHoraFimGreaterThanEqualOrderByDataHoraInicio(usuario,dataHoraFim);
            //LocalDateTime horario1 = findProximoHorarioDisponivel(usuario, dataHoraInicio,dataHoraFim);
            LocalDateTime horario2 = findProximoHorarioDisponivel(duracao,dataHoraInicio,compromissosDoUsuario);
            LocalDateTime horario3 = findProximoHorarioDisponivel(duracao,dataHoraInicio,compromissosTeste);
            throw new IllegalArgumentException("Horário disponivel = " + horario3.format(formato));

        }else{
            return compromissoRepository.save(compromisso);
        }
    }

    public Boolean verificaCompromisso(Compromisso compromisso){
        Usuario usuario = compromisso.getUsuario();
        LocalDateTime dataHoraInicio = compromisso.getDataHoraInicio();
        LocalDateTime dataHoraFim = compromisso.getDataHoraFim();

        List<Compromisso> compromissosExistentes = compromissoRepository.findByUsuarioAndDataHoraFimAfterAndDataHoraInicioBefore(usuario, dataHoraInicio, dataHoraFim);

        if (!compromissosExistentes.isEmpty() ||compromisso.getDataHoraInicio().isAfter(compromisso.getDataHoraFim()) ||compromisso.getDataHoraInicio().equals(compromisso.getDataHoraFim())) {
            return false;
        }else{
            return true;
        }
    }

    public LocalDateTime findProximoHorarioDisponivel(Duration duracao, LocalDateTime dataHoraDisponivel, List<Compromisso> compromissos){
        if (compromissos.isEmpty()){
            return dataHoraDisponivel;
        }else {
            Compromisso compromisso = compromissos.get(0);
            LocalDateTime horaInicio = compromisso.getDataHoraInicio();
            Duration janela = Duration.between(dataHoraDisponivel,horaInicio);

            if (janela.compareTo(duracao) >= 0){
                return dataHoraDisponivel;
            }

            return findProximoHorarioDisponivel(duracao, compromisso.getDataHoraFim(), compromissos.subList(1,compromissos.size()));
        }

    }

    public LocalDateTime findProximoHorarioDisponivel(Usuario usuario, LocalDateTime horarioInicioDesejado, LocalDateTime horarioFim) {

        List<Compromisso> compromissosDoUsuario = compromissoRepository.findByUsuarioAndDataHoraFimGreaterThanEqualOrderByDataHoraInicio(usuario,horarioFim);
        Duration duracao = Duration.between(horarioInicioDesejado, horarioFim);

        LocalDateTime proximoHorarioDisponivel = null;

        for (Compromisso compromisso: compromissosDoUsuario){
            if (proximoHorarioDisponivel == null){
                proximoHorarioDisponivel = compromisso.getDataHoraFim();
            }else {
                Duration janela = Duration.between(proximoHorarioDisponivel, compromisso.getDataHoraInicio());
                if(janela.compareTo(duracao) < 0){
                    proximoHorarioDisponivel = compromisso.getDataHoraFim();

                }else {
                    break;
                }
            }
        }
        return proximoHorarioDisponivel;
    }

    public List<Compromisso> listar(){
        Sort sort = Sort.by("dataHoraInicio").ascending();
        return compromissoRepository.findAll(sort);

    }

    public  List<Compromisso> listarPorUsuarioId(Long usuarioId){
        return compromissoRepository.findByUsuarioId(usuarioId);
    }


    public Compromisso buscaPeloId(Long id){
        Optional<Compromisso> obj = compromissoRepository.findById(id);
        return obj.get();
    }

    public List<Compromisso> excluirPeloId(Long id){
        Optional<Compromisso> compromisso = compromissoRepository.findById(id);
        Usuario usuario = compromisso.get().getUsuario();
        Long idUsuario = usuario.getId();

        compromissoRepository.deleteById(id);
        return listarPorUsuarioId(idUsuario);
    }

    public List<Compromisso> editar(Compromisso compromisso){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Usuario usuario = compromisso.getUsuario();
        Long idUser = usuario.getId();
        LocalDateTime dataHoraInicio = compromisso.getDataHoraInicio();
        LocalDateTime dataHoraFim = compromisso.getDataHoraFim();

        Duration duracao = Duration.between(dataHoraInicio, dataHoraFim);
        compromisso.setDuracao(duracao);


        if(verificaCompromisso(compromisso)){
            compromissoRepository.save(compromisso);
        }
        else{
            List<Compromisso> compromissosDoUsuario = compromissoRepository.findByUsuarioAndDataHoraFimGreaterThanEqualOrderByDataHoraInicio(usuario,dataHoraFim);
            LocalDateTime horario2 = findProximoHorarioDisponivel(duracao,dataHoraInicio,compromissosDoUsuario);
            LocalDateTime horario = findProximoHorarioDisponivel(usuario, dataHoraInicio,dataHoraFim);
            throw new IllegalArgumentException("Horário Disponivel = " + horario2);
        }

        return listarPorUsuarioId(idUser);
    }
}
