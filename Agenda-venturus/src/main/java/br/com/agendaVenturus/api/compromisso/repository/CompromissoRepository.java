package br.com.agendaVenturus.api.compromisso.repository;

import br.com.agendaVenturus.api.compromisso.entity.Compromisso;

import br.com.agendaVenturus.api.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;


public interface CompromissoRepository extends JpaRepository<Compromisso,Long> {


    List<Compromisso> findByUsuarioId(Long usuarioId);

    List<Compromisso> findByUsuarioAndDataHoraFimAfterAndDataHoraInicioBefore(Usuario usuario, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);
    List<Compromisso> findByUsuario(Usuario usuario);

    List<Compromisso> findByUsuarioAndDataHoraFimGreaterThanEqualOrderByDataHoraInicio(Usuario usuario, LocalDateTime dataHoraFim);


    @Query("SELECT c FROM Compromisso c WHERE c.usuario = :usuario AND c.dataHoraFim >= :dataHoraFim ORDER BY c.dataHoraInicio")
    List<Compromisso> teste(@Param("usuario") Usuario usuario, @Param("dataHoraFim") LocalDateTime dataHoraFim);

}
