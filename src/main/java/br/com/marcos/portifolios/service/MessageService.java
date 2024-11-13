package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.model.dto.MessageDto;
import br.com.marcos.portifolios.model.dto.MessageForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {
    void saveMessage(MessageForm form);
    List<MessageDto> getMessages();
}
