package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Evento;
import com.sistemagestion.app.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository repository;

    public Page<Evento> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public List<Evento> findAll() {
        return repository.findAll();
    }

    public Evento findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El evento (id: " + id + ") no fue encontrado", 5));
    }

    public Evento save(Evento evento) {
        return repository.save(evento);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
