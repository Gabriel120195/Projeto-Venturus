package br.com.agendaVenturus.api.compromisso.entity;



import br.com.agendaVenturus.api.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;




@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Compromisso")
public class Compromisso {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String tipoCompromisso;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;

    private Duration duracao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
