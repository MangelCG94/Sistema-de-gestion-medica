package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Informe;
import com.sistemagestion.app.service.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/informes")
public class InformeController {
    @Autowired
    private InformeService service;

    @GetMapping
    public Page<Informe> getAllInformes(@RequestParam(defaultValue = "0") int pageNo,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public Informe getInformeById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Informe createInforme(@RequestBody Informe informe) {
        return service.save(informe);
    }

    @PutMapping("/{id}")
    public Informe updateInforme(@PathVariable Long id, @RequestBody Informe informeDetails) {
        informeDetails.setId(id);
        return service.save(informeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInforme(@PathVariable Long id) {
        service.deleteById(id);
    }
}
