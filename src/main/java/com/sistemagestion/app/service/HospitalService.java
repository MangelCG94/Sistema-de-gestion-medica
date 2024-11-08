package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Hospital;
import com.sistemagestion.app.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository repository;

    public Page<Hospital> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public Hospital findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El hospital (id: " + id + ") no fue encontrado", 5));
    }

    public Hospital save(Hospital hospital) {
        return repository.save(hospital);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
