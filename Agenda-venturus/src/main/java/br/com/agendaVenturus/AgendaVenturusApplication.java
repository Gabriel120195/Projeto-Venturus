package br.com.agendaVenturus;

import br.com.agendaVenturus.api.bloqueioDeAgenda.entity.BloqueioDeAgenda;
import br.com.agendaVenturus.api.bloqueioDeAgenda.repository.BloqueioDeAgendaRepository;
import br.com.agendaVenturus.api.compromisso.entity.Compromisso;
import br.com.agendaVenturus.api.compromisso.repository.CompromissoRepository;
import br.com.agendaVenturus.api.equipamento.entity.Equipamento;
import br.com.agendaVenturus.api.equipamento.repository.EquipamentoRepository;
import br.com.agendaVenturus.api.salas.entity.Sala;
import br.com.agendaVenturus.api.salas.repository.SalaRepository;
import br.com.agendaVenturus.api.usuario.entity.Usuario;
import br.com.agendaVenturus.api.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@SpringBootApplication
public class AgendaVenturusApplication implements CommandLineRunner {

	private final UsuarioRepository usuarioRepository;

	private final CompromissoRepository compromissoRepository;

	private final BloqueioDeAgendaRepository bloqueioRepository;

	private final SalaRepository salaRepository;

	private final EquipamentoRepository equipamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgendaVenturusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario user1 = new Usuario(null, "Gabriel", new ArrayList<>());
		Usuario user2 = new Usuario(null, "Luis", new ArrayList<>());
		Usuario user3 = new Usuario(null, "Sandra", new ArrayList<>());

		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3));

		Compromisso comp1 = new Compromisso(null,"Consulta",LocalDateTime.of(2023,05,03,7,00,00),LocalDateTime.of(2023,05,03,8,00,00),Duration.ofHours(1),user1);
		Compromisso comp2 = new Compromisso(null,"Almoco",LocalDateTime.of(2023,05,03,10,00,00),LocalDateTime.of(2023,05,03,12,00,00),Duration.ofHours(2),user1);
		Compromisso comp3 = new Compromisso(null,"Consulta",LocalDateTime.of(2023,05,04,7,00,00),LocalDateTime.of(2023,05,04,8,00,00),Duration.ofHours(1),user1);
		Compromisso comp4 = new Compromisso(null,"Almoco",LocalDateTime.of(2023,05,04,12,00,00),LocalDateTime.of(2023,05,04,13,00,00),Duration.ofHours(1),user1);
		Compromisso comp5 = new Compromisso(null,"Consulta",LocalDateTime.of(2023,05,05,7,00,00),LocalDateTime.of(2023,05,05,8,00,00),Duration.ofHours(1),user1);

		Compromisso comp6 = new Compromisso(null,"Almoco",LocalDateTime.of(2023,05,03,12,00,00),LocalDateTime.of(2023,05,03,13,00,00),Duration.ofHours(1),user2);
		Compromisso comp7 = new Compromisso(null,"Consulta",LocalDateTime.of(2023,05,03,7,00,00),LocalDateTime.of(2023,05,03,8,00,00),Duration.ofHours(1),user2);
		Compromisso comp8 = new Compromisso(null,"Almoco",LocalDateTime.of(2023,05,04,12,00,00),LocalDateTime.of(2023,05,04,13,00,00),Duration.ofHours(1),user2);
		Compromisso comp9 = new Compromisso(null,"Consulta",LocalDateTime.of(2023,05,04,7,00,00),LocalDateTime.of(2023,05,04,8,00,00),Duration.ofHours(1),user2);
		Compromisso comp10 = new Compromisso(null,"Almoco",LocalDateTime.of(2023,05,05,12,00,00),LocalDateTime.of(2023,05,05,13,00,00),Duration.ofHours(1),user2);

		Compromisso comp11 = new Compromisso(null,"Trabalho",LocalDateTime.of(2023,05,04,7,00,00),LocalDateTime.of(2023,05,04,8,00,00),Duration.ofHours(1),user3);
		Compromisso comp12 = new Compromisso(null,"Jantar",LocalDateTime.of(2023,05,04,14,00,00),LocalDateTime.of(2023,05,04,15,00,00),Duration.ofHours(1),user3);
		Compromisso comp13 = new Compromisso(null,"Exame",LocalDateTime.of(2023,05,05,9,00,00),LocalDateTime.of(2023,05,05,11,00,00),Duration.ofHours(2),user3);
		Compromisso comp14 = new Compromisso(null,"Jantar",LocalDateTime.of(2023,05,05,20,00,00),LocalDateTime.of(2023,05,05,21,00,00),Duration.ofHours(1),user3);
		Compromisso comp15 = new Compromisso(null,"Consulta",LocalDateTime.of(2023,05,06,7,00,00),LocalDateTime.of(2023,05,05,8,00,00),Duration.ofHours(1),user3);
		Compromisso comp16 = new Compromisso(null,"Almoco",LocalDateTime.of(2023,05,06,12,00,00),LocalDateTime.of(2023,05,06,13,00,00),Duration.ofHours(1),user3);

		compromissoRepository.saveAll(Arrays.asList(comp1,comp2,comp3,comp4,comp5,comp6,comp7,comp8,comp9,comp10,comp11,comp12,comp13,comp14,comp15,comp16));

		Sala sala1 = new Sala(null,"Sala001");
		Sala sala2 = new Sala(null,"Sala002");
		Sala sala3 = new Sala(null,"Sala003");
		Sala sala4 = new Sala(null,"Sala004");

		salaRepository.saveAll(Arrays.asList(sala1, sala2, sala3, sala4));

		Equipamento equi1 = new Equipamento(null,"NoteBook");
		Equipamento equi2 = new Equipamento(null,"Controle");
		Equipamento equi3 = new Equipamento(null,"Projetor");
		Equipamento equi4 = new Equipamento(null,"Mesa");
		Equipamento equi5 = new Equipamento(null,"Smart Tv");

		equipamentoRepository.saveAll(Arrays.asList(equi1, equi2, equi3, equi4, equi5));
	}
}
