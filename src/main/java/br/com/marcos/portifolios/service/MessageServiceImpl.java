package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.model.Message;
import br.com.marcos.portifolios.model.dto.MessageForm;
import br.com.marcos.portifolios.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    @Override
    public void saveMessage(MessageForm form) {
        Message mensagem = new Message(form);
        Message message = messageRepository.save(mensagem);
        logger.info("mensagem salva com sucesso! id: {} ", message.getId());
    }
}

