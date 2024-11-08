package com.sistemagestion.app.repository;

import com.sistemagestion.app.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
