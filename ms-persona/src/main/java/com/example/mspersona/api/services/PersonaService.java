package com.example.mspersona.api.services;

import com.example.mspersona.domain.models.Persona;
import com.example.mspersona.domain.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonaService {

    private final PersonaRepository repository;

    @Transactional(readOnly = true)
    public List<Persona> findPersonByName(String name) {
        return repository.findPersonasByName(name);
    }

    public Persona save(Persona persona) {
        return repository.save(persona);
    }

}
