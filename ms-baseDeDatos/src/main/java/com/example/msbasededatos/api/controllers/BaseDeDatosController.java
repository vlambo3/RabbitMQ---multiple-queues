package com.example.msbasededatos.api.controllers;

import com.example.msbasededatos.api.queue.BaseDeDatosListener;
import com.example.msbasededatos.api.services.BaseDeDatosService;
import com.example.msbasededatos.domain.models.BaseDeDatos;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class BaseDeDatosController {

    private final BaseDeDatosService service;

    private final BaseDeDatosListener listener;

    @GetMapping("/{name}")
    public ResponseEntity<List<BaseDeDatos>> getDatoByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.findDatoByName(name));
    }

    @PostMapping("/salvar")
    public ResponseEntity<BaseDeDatos> guardarDato(@RequestBody BaseDeDatos datos) {
        listener.receive(datos);
        return ResponseEntity.noContent().build();
    }

}
