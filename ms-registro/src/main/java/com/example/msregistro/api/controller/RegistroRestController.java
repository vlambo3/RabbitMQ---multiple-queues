package com.example.msregistro.api.controller;

import com.example.msregistro.api.queue.PersonaSender;
import com.example.msregistro.domain.models.BaseDeDatos;
import com.example.msregistro.domain.models.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistroRestController {

    private final PersonaSender sender;

    @PostMapping("/save")
    public ResponseEntity<?> savePersona(@RequestBody Persona persona) {
        sender.sendMsg(persona);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/saveDB")
    public ResponseEntity<?> savePersonaNew(@RequestBody BaseDeDatos datos) {
        sender.sendMsgToOtherConsumer(datos);
        return ResponseEntity.noContent().build();
    }

}
