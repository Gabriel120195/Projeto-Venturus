package br.com.agendaVenturus.api.salas.repository;

import br.com.agendaVenturus.api.salas.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala,Long> {
}
