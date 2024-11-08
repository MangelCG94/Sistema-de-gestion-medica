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
@Table(name = "informes")
public class Informe { //todo: clase que guarde todos los cambios
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

    @CreatedDate
    private Instant createdDate;

    @LastModifiedBy
    private Instant lastModifiedBy;
}