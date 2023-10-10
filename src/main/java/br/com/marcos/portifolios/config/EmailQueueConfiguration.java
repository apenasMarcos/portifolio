package br.com.marcos.portifolios.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailQueueConfiguration {

    public static final String ENVIO_EMAIL_EXCHANGE = "envioEmail.exchange";
    public static final String ENVIO_EMAIL_QUEUE = "envioEmail.queue";
    public static final String ROUTING_KEY = "envioEmail";

    @Bean
    DirectExchange processarEnvioEmailExchange() {
        return new DirectExchange(ENVIO_EMAIL_EXCHANGE);
    }

    @Bean(name = ENVIO_EMAIL_QUEUE)
    Queue processarEnvioEmailQueue() {
        return QueueBuilder.durable(ENVIO_EMAIL_QUEUE).build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(processarEnvioEmailQueue()).to(processarEnvioEmailExchange()).with(ROUTING_KEY);
    }

}
