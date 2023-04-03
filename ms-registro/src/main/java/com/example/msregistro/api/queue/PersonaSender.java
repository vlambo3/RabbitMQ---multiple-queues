package com.example.msregistro.api.queue;

import com.example.msregistro.domain.models.BaseDeDatos;
import com.example.msregistro.domain.models.Persona;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonaSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    private final String routingKey = "quick.orange.rabbit";

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaSender.class);

    public void sendMsg(Persona persona) {
        LOGGER.info(String.format("Json message sent to only match routing key-> %s", persona.toString()));
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, persona);
    }

    public void sendMsgToOtherConsumer(BaseDeDatos datos) {
        LOGGER.info(String.format("Json message sent to ALL -> %s", datos.toString()));
        rabbitTemplate.convertAndSend(topicExchange.getName(), "#", datos);
    }



}
