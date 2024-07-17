package br.com.marcos.portifolios.model.dto;

import br.com.marcos.portifolios.model.Message;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageDtoTest {

    @Test
    public void testMessageDtoConstructorFromMessage() {
        // Cria uma instância da entidade Message
        Message message = new Message(
                UUID.randomUUID(),
                "John Doe",
                "johndoe@example.com",
                "123-456-7890",
                "Hello, this is a test message."
        );

        // Cria uma instância do DTO usando a entidade Message
        MessageDto messageDto = new MessageDto(message);

        // Verifica se os valores do DTO correspondem aos valores da entidade Message
        assertEquals(message.getName(), messageDto.name());
        assertEquals(message.getMessageContent(), messageDto.message());
    }

    @Test
    public void testMessageConstructorFromMessageForm() {
        // Cria uma instância do Form
        MessageForm form = new MessageForm(
                "John Doe",
                "johndoe@example.com",
                "123-456-7890",
                "Hello, this is a test message."
        );

        // Cria uma instância da entidade Message usando o Form
        Message message = new Message(form);

        // Verifica se os valores da entidade Message correspondem aos valores do Form
        assertEquals(form.name(), message.getName());
        assertEquals(form.sender(), message.getSender());
        assertEquals(form.phone(), message.getPhone());
        assertEquals(form.messageContent(), message.getMessageContent());
    }
}
