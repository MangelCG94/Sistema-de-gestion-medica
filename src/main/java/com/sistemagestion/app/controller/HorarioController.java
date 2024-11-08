package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Horario;
import com.sistemagestion.app.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/horarios")
public class HorarioController {
    @Autowired
    private HorarioService service;

    @GetMapping
    public Page<Horario> getAllHorarios(@RequestParam(defaultValue = "0") int pageNo,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public Horario getHorarioById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return service.save(horario);
    }

    @PutMapping("/{id}")
    public Horario updateHorario(@PathVariable Long id, @RequestBody Horario horarioDetails) {
        horarioDetails.setId(id);
        return service.save(horarioDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteHorario(@PathVariable Long id) {
        service.deleteById(id);
    }
}
