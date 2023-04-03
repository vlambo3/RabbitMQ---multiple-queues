package com.example.msbasededatos.domain.data;

import com.example.msbasededatos.domain.models.BaseDeDatos;
import com.example.msbasededatos.domain.repositories.BaseDeDatosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final BaseDeDatosRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new BaseDeDatos(1L, "Federico", "Masculino", "dh"));
        repository.save(new BaseDeDatos(2L, "Fabio", "Masculino", "dh"));
        repository.save(new BaseDeDatos(3L, "Fabiana", "Femenino", "dh"));
    }
}
