package br.com.agendaVenturus.api.bloqueioDeAgenda.repository;

import br.com.agendaVenturus.api.bloqueioDeAgenda.entity.BloqueioDeAgenda;
import org.springframework.data.jpa.repository.JpaRepository;




public interface BloqueioDeAgendaRepository extends JpaRepository<BloqueioDeAgenda,Long> {


}
