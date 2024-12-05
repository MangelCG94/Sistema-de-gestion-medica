package com.sistemagestion.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@Table(name = "informes")
public class Informe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private PersonalMedico personalMedico;

    @ManyToOne
    private Hospital hospital;

    private String tipo;
    private String nombre;
    private String descripcion;
    private String imagen;

    @CreatedBy
    private Instant createdBy;

    @LastModifiedBy
    private Instant lastModifiedBy;
}