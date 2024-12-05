package com.sistemagestion.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String dni;
    private String direccion;
    private String cp;
    private String telefono;
    private String email;
    private Boolean activo;

    @CreatedBy
    private Instant createdBy;

    @LastModifiedBy
    private Instant lastModifiedBy;
}