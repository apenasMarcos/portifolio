package br.com.marcos.portifolios.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailQueueConfiguration {

    public static final String ENVIO_EMAIL_EXCHANGE = "ENVIO_EMAIL_EXCHANGE";
    public static final String ENVIO_EMAIL_QUEUE = "ENVIO_EMAIL_QUEUE";
    public static final String ROUTING_KEY = "envioEmail";


    @Bean
    public DirectExchange processarEnvioEmailExchange() {
        return new DirectExchange(ENVIO_EMAIL_EXCHANGE);
    }

    @Bean
    public Queue processarEnvioEmailQueue() {
        return QueueBuilder.durable(ENVIO_EMAIL_QUEUE).build();
    }

    @Bean
    public Binding binding(Queue processarEnvioEmailQueue, DirectExchange processarEnvioEmailExchange) {
        return BindingBuilder.bind(processarEnvioEmailQueue).to(processarEnvioEmailExchange).with(ROUTING_KEY);
    }
}
