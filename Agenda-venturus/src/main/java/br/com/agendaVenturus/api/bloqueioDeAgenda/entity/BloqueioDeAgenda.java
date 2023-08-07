package br.com.agendaVenturus.api.bloqueioDeAgenda.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;




@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BloqueioDeAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoriaInico;

    private LocalDateTime dataHoraFim;

    private Duration duracao;

//    @OneToOne
//    private Usuario usuario;

}
