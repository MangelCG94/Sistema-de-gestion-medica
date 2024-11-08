package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Cita;
import com.sistemagestion.app.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/citas")
public class CitaController {
    @Autowired
    private CitaService service;

    @GetMapping
    public Page<Cita> getAllCitas(@RequestParam(defaultValue = "0") int pageNo,
                                  @RequestParam(defaultValue = "10") int pageSize,
                                  @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return service.save(cita);
    }

    @PutMapping("/{id}")
    public Cita updateCita(@PathVariable Long id, @RequestBody Cita citaDetails) {
        citaDetails.setId(id);
        return service.save(citaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable Long id) {
        service.deleteById(id);
    }
}
