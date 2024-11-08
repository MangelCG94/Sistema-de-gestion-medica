package com.sistemagestion.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private PersonalMedico personalMedico;

    private String tipo;
    private String nombre;
    private String descripcion;
    private Boolean desaconsejado;
    private Boolean peligroso;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedBy
    private Instant lastModifiedBy;
}