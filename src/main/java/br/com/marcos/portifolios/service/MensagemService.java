package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.model.dto.MensagemForm;

public interface MensagemService {
    void salvarMensagemQueue(MensagemForm email);
    void salvarMensagem(MensagemForm form);
}
