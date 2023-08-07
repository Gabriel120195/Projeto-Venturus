package br.com.agendaVenturus.api.equipamento.controller;

import br.com.agendaVenturus.api.equipamento.entity.Equipamento;
import br.com.agendaVenturus.api.equipamento.service.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/equipamento")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @PostMapping
    public Equipamento cadastrar(@RequestBody Equipamento equipamento){
        return equipamentoService.cadastrar(equipamento);
    }

    @GetMapping
    public List<Equipamento> listar(){
        return equipamentoService.listarEquipamentos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        equipamentoService.deletar(id);
    }

    @PutMapping
    public Equipamento editar(Equipamento equipamento){
        return equipamentoService.editar(equipamento);
    }
}
