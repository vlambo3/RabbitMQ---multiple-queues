package com.example.mspersona.api.controllers;

import com.example.mspersona.api.queue.PersonaListener;
import com.example.mspersona.api.services.PersonaService;
import com.example.mspersona.domain.models.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService service;

    private final PersonaListener listener;

    @GetMapping("/{name}")
    public ResponseEntity<List<Persona>> getPersonaByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.findPersonByName(name));
    }

    @PostMapping("/salvar")
    public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) {
        listener.receive(persona);
        return ResponseEntity.noContent().build();
    }

}
