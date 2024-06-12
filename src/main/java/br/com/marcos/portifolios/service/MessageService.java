package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.model.dto.MessageForm;

public interface MessageService {
    void saveMessageQueue(MessageForm email);
    void saveMessage(MessageForm form);
}
