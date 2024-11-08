package com.sistemagestion.app.repository;

import com.sistemagestion.app.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
