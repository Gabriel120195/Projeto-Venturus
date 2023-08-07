package br.com.agendaVenturus.api.bloqueioDeAgenda.service;

import br.com.agendaVenturus.api.bloqueioDeAgenda.entity.BloqueioDeAgenda;
import br.com.agendaVenturus.api.bloqueioDeAgenda.repository.BloqueioDeAgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BloqueioDeAgendaService {

    private final BloqueioDeAgendaRepository bloqueioRepository;

    public BloqueioDeAgenda cadastrar(BloqueioDeAgenda bloqueioDeAgenda){
        return bloqueioRepository.save(bloqueioDeAgenda);
    }

    public List<BloqueioDeAgenda> listar(){
        return bloqueioRepository.findAll();
    }

    public BloqueioDeAgenda buscaPeloId(Long id){
        Optional<BloqueioDeAgenda> obj = bloqueioRepository.findById(id);
        return obj.get();
    }

//    public BloqueioDeAgenda excluirPeloId(){
//
//    }
//
//    public BloqueioDeAgenda atualizarPeloId(){
//
//    }
}
