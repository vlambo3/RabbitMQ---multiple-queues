package com.example.msbasededatos.api.queue;

import com.example.msbasededatos.api.services.BaseDeDatosService;
import com.example.msbasededatos.domain.models.BaseDeDatos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class BaseDeDatosListener {

    private final BaseDeDatosService service;

    public BaseDeDatosListener(BaseDeDatosService service) {
        this.service = service;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDeDatosListener.class);

    @RabbitListener(queues = {"${queue.persona.name}"})
    public void receive(@Payload BaseDeDatos datos) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(String.format("Received message -> %s", datos));
        service.save(datos);
    }
}
