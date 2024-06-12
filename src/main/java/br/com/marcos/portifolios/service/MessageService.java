package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.model.dto.MessageForm;

public interface MensagemService {
    void salvarMensagemQueue(MessageForm email);
    void salvarMensagem(MessageForm form);
}
