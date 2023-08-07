package br.com.agendaVenturus.api.usuario.controller;


import br.com.agendaVenturus.api.usuario.entity.Usuario;
import br.com.agendaVenturus.api.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //injecao
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.cadastrar(usuario);
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

//    @GetMapping(value = "/{id}")
//    public Usuario buscaPeloId(@PathVariable Long id){
//        Usuario user = usuarioService.buscaPeloId(id);
//        return user;
//    }

//    @DeleteMapping("/{id}")
//    public Usuario excluirPeloId(@PathVariable Long id){
//        return usuarioService.excluirPeloId(id);
//    }

}
