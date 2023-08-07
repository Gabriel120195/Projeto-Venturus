package br.com.agendaVenturus.api.usuario.service;

import br.com.agendaVenturus.api.usuario.entity.Usuario;
import br.com.agendaVenturus.api.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}
