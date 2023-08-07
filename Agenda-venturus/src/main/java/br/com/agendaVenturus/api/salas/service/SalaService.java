package br.com.agendaVenturus.api.salas.service;

import br.com.agendaVenturus.api.salas.entity.Sala;
import br.com.agendaVenturus.api.salas.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public Sala cadastrar(Sala sala){
        return salaRepository.save(sala);
    }

    public List<Sala> listarSalas(){
        return salaRepository.findAll();
    }

    public void deletar(Long id){
        salaRepository.deleteById(id);
    }

    public Sala editar(Sala sala){
        return salaRepository.save(sala);
    }
}
