package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Medicamento;
import com.sistemagestion.app.repository.MedicamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
    @Autowired
    private MedicamentoRepository repository;

    public Page<Medicamento> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public Medicamento findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El medicamento (id: " + id + ") no fue encontrado", 5));
    }

    public Medicamento save(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
