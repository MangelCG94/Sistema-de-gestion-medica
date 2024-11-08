package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.PersonalMedico;
import com.sistemagestion.app.repository.PersonalMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalMedicoService {
    @Autowired
    private PersonalMedicoRepository repository;

    public Page<PersonalMedico> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public List<PersonalMedico> findAll() {
        return repository.findAll();
    }

    public PersonalMedico findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El personal médico (id: " + id + ") no fue encontrado", 3));
    }

    public PersonalMedico save(PersonalMedico personalMedico) {
        return repository.save(personalMedico);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
