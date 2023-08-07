package br.com.agendaVenturus.api.equipamento.repository;

import br.com.agendaVenturus.api.equipamento.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento,Long> {
}
