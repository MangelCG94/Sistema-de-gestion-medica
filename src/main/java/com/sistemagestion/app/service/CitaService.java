package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Cita;
import com.sistemagestion.app.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    @Autowired
    private CitaRepository repository;

    public Page<Cita> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public Cita findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("La cita (id: " + id + ") no fue encontrada", 9));
    }

    public Cita save(Cita cita) {
        return repository.save(cita);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
