package com.sistemagestion.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime horaCita;
    private LocalDateTime diaCita;
    private Boolean anulado;
    private Boolean asistido;
}