package br.com.agendaVenturus.api.usuario.repository;

import br.com.agendaVenturus.api.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


}
