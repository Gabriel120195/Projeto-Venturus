package br.com.agendaVenturus.api.salas.controller;

import br.com.agendaVenturus.api.salas.entity.Sala;
import br.com.agendaVenturus.api.salas.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sala")
public class SalaController {

    private final SalaService salaService;

    @PostMapping
    public Sala cadastrar(@RequestBody Sala sala){
        return salaService.cadastrar(sala);
    }

    @GetMapping
    public List<Sala> listar(){
        return salaService.listarSalas();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        salaService.deletar(id);
    }

    @PutMapping
    public Sala editar(Sala sala){
        return salaService.editar(sala);
    }
}
