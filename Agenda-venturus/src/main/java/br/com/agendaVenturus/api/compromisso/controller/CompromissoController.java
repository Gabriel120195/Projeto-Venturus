package br.com.agendaVenturus.api.compromisso.controller;

import br.com.agendaVenturus.api.compromisso.entity.Compromisso;
import br.com.agendaVenturus.api.compromisso.service.CompromissoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/compromisso")
public class CompromissoController {

    private final CompromissoService compromissoService;

    @PostMapping
    public ResponseEntity<Compromisso> cadastrar(@RequestBody Compromisso compromisso) {
    Compromisso novoCompromisso = compromissoService.salvarCompromisso(compromisso);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoCompromisso);
}

    @GetMapping
    public List<Compromisso> listar(){
        return compromissoService.listar();
    }

    @GetMapping(value = "/{id}")
    public Compromisso buscaPeloId(@PathVariable Long id){
        Compromisso comp = compromissoService.buscaPeloId(id);
        return comp;
    }
    @DeleteMapping("/{id}")
    public List<Compromisso> deletar(@PathVariable("id") Long id){
        return compromissoService.excluirPeloId(id);
    }

    @PutMapping
    public List<Compromisso> atualizarCompromisso(@RequestBody Compromisso compromisso){
        return compromissoService.editar(compromisso);
    }
}
