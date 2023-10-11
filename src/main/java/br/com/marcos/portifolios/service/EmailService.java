package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.config.EmailQueueConfiguration;
import br.com.marcos.portifolios.model.form.EmailForm;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange envioEmailExchange;

    public EmailService(RabbitTemplate rabbitTemplate, JavaMailSender javaMailSender, @Qualifier("processarEnvioEmailExchange") DirectExchange envioEmailExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.javaMailSender = javaMailSender;
        this.envioEmailExchange = envioEmailExchange;
    }

    public void enviarEmailQueue(EmailForm email) {
        rabbitTemplate.convertAndSend(envioEmailExchange.getName(), EmailQueueConfiguration.ROUTING_KEY, email);
    }

    public void enviarEmail(EmailForm email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getRemetente());
        message.setSubject("Assunto do E-mail");
        message.setText("Conteúdo do E-mail");
        javaMailSender.send(message);
    }


}

