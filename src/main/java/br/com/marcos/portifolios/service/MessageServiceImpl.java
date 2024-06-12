package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.config.SaveMessageQueueConfiguration;
import br.com.marcos.portifolios.model.Message;
import br.com.marcos.portifolios.model.dto.MessageForm;
import br.com.marcos.portifolios.repository.MessageRepository;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MensagemServiceImpl implements MensagemService {

    private static final Logger logger = LoggerFactory.getLogger(MensagemServiceImpl.class);

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange salvarMensagemExchange;
    private final MessageRepository messageRepository;

    public MensagemServiceImpl(RabbitTemplate rabbitTemplate, DirectExchange salvarMensagemExchange, MessageRepository messageRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.salvarMensagemExchange = salvarMensagemExchange;
        this.messageRepository = messageRepository;
    }

    @Override
    public void salvarMensagemQueue(MessageForm email) {
        rabbitTemplate.convertAndSend(salvarMensagemExchange.getName(), SaveMessageQueueConfiguration.ROUTING_KEY, email);
    }

    @Transactional
    @Override
    public void salvarMensagem(MessageForm form) {
        Message mensagem = new Message(form);
        messageRepository.save(mensagem);
    }
}

