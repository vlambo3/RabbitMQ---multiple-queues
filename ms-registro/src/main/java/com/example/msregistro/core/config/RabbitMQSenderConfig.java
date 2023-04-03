package com.example.msregistro.core.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${exchange.persona.name}")
    private String personaExchange;

    @Value("${queue.persona.name}")
    private String personaQueue;

    @Bean
    public Queue personaQueue() {
        return new Queue(personaQueue, true);
    }

    @Bean("baseQueue")
    public Queue queue1() {
        return new Queue("baseQueue", true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(personaExchange);
    }

    @Bean
    public Binding bindingTopic(TopicExchange topic,
                             Queue personaQueue) {
        return BindingBuilder.bind(personaQueue)
                .to(topic)
                .with("*.orange.*");
    }

    @Bean
    public Binding binding1(@Qualifier("baseQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#");
    }


}
