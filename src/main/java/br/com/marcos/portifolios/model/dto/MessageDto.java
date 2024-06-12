package br.com.marcos.portifolios.model.dto;

import br.com.marcos.portifolios.model.Message;

public record MessageDto(String name, String message) {
    public MessageDto(Message message) {
        this(message.getName(), message.getMessage());
    }
}
