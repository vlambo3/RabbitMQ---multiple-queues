package com.example.msbasededatos.api.services;

import com.example.msbasededatos.domain.models.BaseDeDatos;
import com.example.msbasededatos.domain.repositories.BaseDeDatosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BaseDeDatosService {

    private final BaseDeDatosRepository repository;

    @Transactional(readOnly = true)
    public List<BaseDeDatos> findDatoByName(String name) {
        return repository.findBaseByName(name);
    }

    public BaseDeDatos save(BaseDeDatos persona) {
        return repository.save(persona);
    }

}
