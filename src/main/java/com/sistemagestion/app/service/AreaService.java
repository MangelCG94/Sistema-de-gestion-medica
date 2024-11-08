package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Area;
import com.sistemagestion.app.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
    @Autowired
    private AreaRepository repository;

    public Page<Area> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public List<Area> findAll() {
        return repository.findAll();
    }

    public Area findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El área (id: " + id + ") no fue encontrado", 7));
    }

    public Area save(Area area) {
        return repository.save(area);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
