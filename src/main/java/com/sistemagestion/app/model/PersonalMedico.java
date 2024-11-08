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
@Table(name = "personal")
public class PersonalMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @ManyToOne
    private Area area;

    @OneToMany(mappedBy = "personalMedico")
    private List<Informe> informes;

    @OneToMany(mappedBy = "personalMedico")
    private List<EventoAsistido> eventosAsistidos;
}