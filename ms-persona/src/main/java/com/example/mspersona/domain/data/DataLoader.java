package com.example.mspersona.domain.data;

import com.example.mspersona.domain.models.Persona;
import com.example.mspersona.domain.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final PersonaRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Persona(1L, "Federico", "Masculino", "dh"));
        repository.save(new Persona(2L, "Fabio", "Masculino", "dh"));
        repository.save(new Persona(3L, "Fabiana", "Femenino", "dh"));
    }
}
