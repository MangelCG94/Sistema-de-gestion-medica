package com.sistemagestion.app.controller;

import com.sistemagestion.app.model.Area;
import com.sistemagestion.app.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/areas")
public class AreaController {
    @Autowired
    private AreaService service;

    @GetMapping
    public Page<Area> getAllAreas(@RequestParam(defaultValue = "0") int pageNo,
                                  @RequestParam(defaultValue = "10") int pageSize,
                                  @RequestParam(defaultValue = "ASC") String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        return service.findAll(pageNo,pageSize,direction);
    }

    @GetMapping("/{id}")
    public Area getAreaById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Area createArea(@RequestBody Area area) {
        return service.save(area);
    }

    @PutMapping("/{id}")
    public Area updateArea(@PathVariable Long id, @RequestBody Area areaDetails) {
        areaDetails.setId(id);
        return service.save(areaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable Long id) {
        service.deleteById(id);
    }
}
