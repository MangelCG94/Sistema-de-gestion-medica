package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.EventoAsistido;
import com.sistemagestion.app.service.EventoAsistidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/eventos-asistidos")
public class EventoAsistidoController {
    @Autowired
    private EventoAsistidoService service;

    @GetMapping
    public Page<EventoAsistido> getAllEventosAsistidos(@RequestParam(defaultValue = "0") int pageNo,
                                                       @RequestParam(defaultValue = "10") int pageSize,
                                                       @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public EventoAsistido getEventoAsistidoById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public EventoAsistido createEventoAsistido(@RequestBody EventoAsistido eventoAsistido) {
        return service.save(eventoAsistido);
    }

    @PutMapping("/{id}")
    public EventoAsistido updateEventoAsistido(@PathVariable Long id, @RequestBody EventoAsistido eventoAsistidoDetails) {
        eventoAsistidoDetails.setId(id);
        return service.save(eventoAsistidoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEventoAsistido(@PathVariable Long id) {
        service.deleteById(id);
    }
}
