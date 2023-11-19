package br.com.marcos.portifolios.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SalvarMensagemQueueConfiguration {

    public static final String SALVAR_MENSAGEM_EXCHANGE = "SALVAR_MENSAGEM_EXCHANGE";
    public static final String SALVAR_MENSAGEM_QUEUE = "SALVAR_MENSAGEM_QUEUE";
    public static final String ROUTING_KEY = "salvarMensagem";


    @Bean
    public DirectExchange processarSalvarMensagemExchange() {
        return new DirectExchange(SALVAR_MENSAGEM_EXCHANGE);
    }

    @Bean
    public Queue processarSalvarEmailQueue() {
        return QueueBuilder.durable(SALVAR_MENSAGEM_QUEUE).build();
    }

    @Bean
    public Binding binding(Queue processarSalvarMensagemQueue, DirectExchange processarSalvarMensagemExchange) {
        return BindingBuilder.bind(processarSalvarMensagemQueue).to(processarSalvarMensagemExchange).with(ROUTING_KEY);
    }
}
