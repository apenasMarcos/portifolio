package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.config.SalvarMensagemQueueConfiguration;
import br.com.marcos.portifolios.model.Mensagem;
import br.com.marcos.portifolios.model.dto.MensagemForm;
import br.com.marcos.portifolios.repository.MensagemRepository;
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
    private final MensagemRepository mensagemRepository;

    public MensagemServiceImpl(RabbitTemplate rabbitTemplate, DirectExchange salvarMensagemExchange, MensagemRepository mensagemRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.salvarMensagemExchange = salvarMensagemExchange;
        this.mensagemRepository = mensagemRepository;
    }

    @Override
    public void salvarMensagemQueue(MensagemForm email) {
        rabbitTemplate.convertAndSend(salvarMensagemExchange.getName(), SalvarMensagemQueueConfiguration.ROUTING_KEY, email);
    }

    @Transactional
    @Override
    public void salvarMensagem(MensagemForm form) {
        Mensagem mensagem = new Mensagem(form);
        mensagemRepository.save(mensagem);
    }
}

