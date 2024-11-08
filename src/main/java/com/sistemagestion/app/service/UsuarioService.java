package com.sistemagestion.app.service;

import com.sistemagestion.app.exception.ResourceNotFoundException;
import com.sistemagestion.app.model.Usuario;
import com.sistemagestion.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Page<Usuario> findAll(int pageNo, int pageSize, Sort.Direction direction) {
        Sort sortBy = Sort.by(direction, "id");
        return repository.findAll(PageRequest.of(pageNo,pageSize,sortBy));
    }

    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El usuario (id: " + id + ") no fue encontrado", 1));
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
