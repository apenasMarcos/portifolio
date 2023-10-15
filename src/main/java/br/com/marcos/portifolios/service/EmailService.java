package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.config.EmailQueueConfiguration;
import br.com.marcos.portifolios.model.form.EmailForm;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange envioEmailExchange;

    public EmailService(RabbitTemplate rabbitTemplate, @Qualifier("processarEnvioEmailExchange") DirectExchange envioEmailExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.envioEmailExchange = envioEmailExchange;
    }

    public void enviarEmailQueue(EmailForm email) {
        rabbitTemplate.convertAndSend(envioEmailExchange.getName(), EmailQueueConfiguration.ROUTING_KEY, email);
    }

}

