package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.EventoAsistido;
import com.sistemagestion.app.repository.EventoAsistidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EventoAsistidoService {
    @Autowired
    private EventoAsistidoRepository repository;

    public Page<EventoAsistido> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public EventoAsistido findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El evento asistido (id: " + id + ") no fue encontrado", 11));
    }

    public EventoAsistido save(EventoAsistido eventoAsistido) {
        return repository.save(eventoAsistido);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
