package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Medicamento;
import com.sistemagestion.app.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/medicamentos")
public class MedicamentoController {
    @Autowired
    private MedicamentoService service;

    @GetMapping
    public Page<Medicamento> getAllMedicamentos(@RequestParam(defaultValue = "0") int pageNo,
                                                @RequestParam(defaultValue = "10") int pageSize,
                                                @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public Medicamento getMedicamentoById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Medicamento createMedicamento(@RequestBody Medicamento medicamento) {
        return service.save(medicamento);
    }

    @PutMapping("/{id}")
    public Medicamento updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamentoDetails) {
        medicamentoDetails.setId(id);
        return service.save(medicamentoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicamento(@PathVariable Long id) {
        service.deleteById(id);
    }
}
