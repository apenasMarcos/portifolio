package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.config.SalvarMensagemQueueConfiguration;
import br.com.marcos.portifolios.model.dto.MensagemForm;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@Service
public class ComunicacaoServiceImpl implements ComunicacaoService{

    private static final Logger logger = LoggerFactory.getLogger(ComunicacaoServiceImpl.class);

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange salvarMensagemExchange;
    private final String numeroTelefone;
    private final String urlWhatsapp;

    public ComunicacaoServiceImpl(RabbitTemplate rabbitTemplate, DirectExchange salvarMensagemExchange,
                                  @Value("${whatsapp.numeroTelefone}") String numeroTelefone, @Value("${whatsapp.urlWhatsapp}") String urlWhatsapp) {
        this.rabbitTemplate = rabbitTemplate;
        this.salvarMensagemExchange = salvarMensagemExchange;
        this.numeroTelefone = numeroTelefone;
        this.urlWhatsapp = urlWhatsapp;
    }

    @Override
    public void salvarMensagemQueue(MensagemForm email) {
        rabbitTemplate.convertAndSend(salvarMensagemExchange.getName(), SalvarMensagemQueueConfiguration.ROUTING_KEY, email);
    }

    @Override
    public void enviarWhatsapp(String mensagem) {
        try {
            String url = urlWhatsapp + "/send?phone=" + numeroTelefone + "&text=" + mensagem;
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            logger.error("Erro ao enviar mensagem pelo WhatsApp: {}", e.getMessage(), e);
        }
    }

    @Transactional
    @Override
    public void salvarMensagem(MensagemForm form) {

    }
}

