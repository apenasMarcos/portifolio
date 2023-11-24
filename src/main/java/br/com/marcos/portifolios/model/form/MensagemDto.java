package br.com.marcos.portifolios.model.form;


import br.com.marcos.portifolios.model.Mensagem;

public record MensagemDto(String nome,  String mensagem) {
    public MensagemDto(Mensagem mensagem) {
        this(mensagem.getNome(), mensagem.getMensagem());
    }
}
