package br.com.agendaVenturus.api.bloqueioDeAgenda.controller;

import br.com.agendaVenturus.api.bloqueioDeAgenda.entity.BloqueioDeAgenda;
import br.com.agendaVenturus.api.bloqueioDeAgenda.service.BloqueioDeAgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //injecao
@RestController
@RequestMapping("/api/bloqueio-agenda")
public class BloqueioAgendaController {

    private final BloqueioDeAgendaService bloqueioService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BloqueioDeAgenda cadastrar(@RequestBody BloqueioDeAgenda bloqueioDeAgenda){
        return bloqueioService.cadastrar(bloqueioDeAgenda);
    }

    @GetMapping
    public List<BloqueioDeAgenda> listar(){
        return bloqueioService.listar();
    }

    @GetMapping(value = "/{id}")
    public BloqueioDeAgenda buscaPeloId(@PathVariable Long id){
        BloqueioDeAgenda bloq = bloqueioService.buscaPeloId(id);
        return bloq;
    }

}
