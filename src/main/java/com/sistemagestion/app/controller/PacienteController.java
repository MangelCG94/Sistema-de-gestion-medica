package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Paciente;
import com.sistemagestion.app.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService service;

    @GetMapping
    public Page<Paciente> getAllPacientes(@RequestParam(defaultValue = "0") int pageNo,
                                          @RequestParam(defaultValue = "10") int pageSize,
                                          @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);

        System.out.println();

        Page<Paciente> pacientes = service.findAll(pageNo,pageSize,direction);

        System.out.println(pacientes.toString());

        return pacientes;
    }

    @GetMapping("/{id}")
    public Paciente getPacienteById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return service.save(paciente);
    }

    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetails) {
        pacienteDetails.setId(id);
        return service.save(pacienteDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        service.deleteById(id);
    }
}
