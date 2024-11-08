package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.PersonalMedico;
import com.sistemagestion.app.service.PersonalMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/personal-medico")
public class PersonalMedicoController {
    @Autowired
    private PersonalMedicoService service;

    @GetMapping
    public Page<PersonalMedico> getAllPersonalMedico(@RequestParam(defaultValue = "0") int pageNo,
                                                     @RequestParam(defaultValue = "10") int pageSize,
                                                     @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public PersonalMedico getPersonalMedicoById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PersonalMedico createPersonalMedico(@RequestBody PersonalMedico personalMedico) {
        return service.save(personalMedico);
    }

    @PutMapping("/{id}")
    public PersonalMedico updatePersonalMedico(@PathVariable Long id, @RequestBody PersonalMedico personalMedicoDetails) {
        personalMedicoDetails.setId(id);
        return service.save(personalMedicoDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePersonalMedico(@PathVariable Long id) {
        service.deleteById(id);
    }
}
