package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Paciente;
import com.sistemagestion.app.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public Page<Paciente> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public Paciente findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El paciente (id: " + id + ") no fue encontrado", 2));
    }

    public Paciente save(Paciente paciente) {
        return repository.save(paciente);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
