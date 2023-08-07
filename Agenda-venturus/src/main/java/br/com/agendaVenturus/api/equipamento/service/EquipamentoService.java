package br.com.agendaVenturus.api.equipamento.service;

import br.com.agendaVenturus.api.equipamento.entity.Equipamento;
import br.com.agendaVenturus.api.equipamento.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public Equipamento cadastrar(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listarEquipamentos(){
        return equipamentoRepository.findAll();
    }

    public void deletar(Long id){
        equipamentoRepository.deleteById(id);
    }

    public Equipamento editar(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }
}
