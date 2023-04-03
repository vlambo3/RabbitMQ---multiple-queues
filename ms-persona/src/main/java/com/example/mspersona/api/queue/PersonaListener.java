package com.example.mspersona.api.queue;

import com.example.mspersona.api.services.PersonaService;
import com.example.mspersona.domain.models.Persona;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PersonaListener {

    private final PersonaService service;

    public PersonaListener(PersonaService service) {
        this.service = service;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaListener.class);


    @RabbitListener(queues = {"${queue.persona.name}"})
    public void receive(@Payload Persona person) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(String.format("Received message -> %s", person));
        service.save(person);
    }
}
