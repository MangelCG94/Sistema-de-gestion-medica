package com.sistemagestion.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventos_asistidos")
public class EventoAsistido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private PersonalMedico encargado;

    @ManyToMany
    private List<PersonalMedico> personalMedico;
}