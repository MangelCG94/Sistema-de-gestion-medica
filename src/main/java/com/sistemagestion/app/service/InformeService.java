package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Informe;
import com.sistemagestion.app.repository.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InformeService {
    @Autowired
    private InformeRepository repository;

    public Page<Informe> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public Informe findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El informe (id: " + id + ") no fue encontrado", 4));
    }

    public Informe save(Informe informe) {
        return repository.save(informe);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
