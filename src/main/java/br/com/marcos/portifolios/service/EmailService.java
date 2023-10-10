package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.config.EmailQueueConfiguration;
import br.com.marcos.portifolios.model.form.EmailForm;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    private final RabbitTemplate rabbitTemplate;

    private final DirectExchange envioEmailExchange;

    public EmailService(RabbitTemplate rabbitTemplate, JavaMailSender emailSender, @Qualifier("processarEnvioEmailExchange") DirectExchange envioEmailExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.javaMailSender = emailSender;
        this.envioEmailExchange = envioEmailExchange;
    }

    public void enviarQueue(EmailForm email) {
        Map<String, String> body = new HashMap<>();
        body.put("nome", email.getNome());
        body.put("remetente", email.getNome());
        body.put("celular", email.getCelular());
        body.put("mensagem", email.getMensagem());


        rabbitTemplate.convertAndSend(EmailQueueConfiguration.ENVIO_EMAIL_EXCHANGE, envioEmailExchange.getName(), body);
    }

    public void enviarEmail(String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("");
        message.setSubject("");
        message.setText("");

        javaMailSender.send(message);
    }

    private Map<String, String> converterStringParaMap(String body) {
        Map<String, String> map = new HashMap<>();


        Pattern pattern = Pattern.compile("\"(.*?)\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(body);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            map.put(key, value);
        }

        return map;
    }

}

