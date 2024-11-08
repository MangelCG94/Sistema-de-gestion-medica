package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Hospital;
import com.sistemagestion.app.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hospitales")
public class HospitalController {
    @Autowired
    private HospitalService service;

    @GetMapping
    public Page<Hospital> getAllHospitals(@RequestParam(defaultValue = "0") int pageNo,
                                          @RequestParam(defaultValue = "10") int pageSize,
                                          @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return service.save(hospital);
    }

    @PutMapping("/{id}")
    public Hospital updateHospital(@PathVariable Long id, @RequestBody Hospital hospitalDetails) {
        hospitalDetails.setId(id);
        return service.save(hospitalDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id) {
        service.deleteById(id);
    }
}
