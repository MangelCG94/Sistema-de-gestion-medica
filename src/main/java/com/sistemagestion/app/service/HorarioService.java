package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Horario;
import com.sistemagestion.app.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository repository;

    public Page<Horario> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public Horario findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El horario (id: " + id + ") no fue encontrado", 5));
    }

    public Horario save(Horario horario) {
        return repository.save(horario);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
