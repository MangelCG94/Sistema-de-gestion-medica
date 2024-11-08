package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Evento;
import com.sistemagestion.app.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

    @GetMapping
    public Page<Evento> getAllEventos(@RequestParam(defaultValue = "0") int pageNo,
                                      @RequestParam(defaultValue = "10") int pageSize,
                                      @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public Evento getEventoById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return service.save(evento);
    }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {
        eventoDetails.setId(id);
        return service.save(eventoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id) {
        service.deleteById(id);
    }
}
