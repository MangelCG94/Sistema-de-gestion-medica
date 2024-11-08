package com.sistemagestion.app.repository;

import com.sistemagestion.app.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
