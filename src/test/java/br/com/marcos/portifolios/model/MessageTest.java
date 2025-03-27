package br.com.marcos.portifolios.model;

import br.com.marcos.portifolios.model.dto.MessageForm;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessageTest {

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
        Message message = messageBuilder(form);

        // Verifica se os valores da entidade Message correspondem aos valores do Form
        assertEquals(form.name(), message.getName());
        assertEquals(form.sender(), message.getSender());
        assertEquals(form.phone(), message.getPhone());
        assertEquals(form.messageContent(), message.getMessageContent());
    }

    @Test
    public void testMessageConstructorWithAllArgs() {
        // Cria uma instância da entidade Message usando todos os argumentos
        MessageForm form = new MessageForm(
                "Jane Doe",
                "janedoe@example.com",
                "098-765-4321",
                "This is another test message."
        );

        Message message = messageBuilder(form);

        // Verifica se os valores estão corretamente atribuídos
        assertEquals("Jane Doe", message.getName());
        assertEquals("janedoe@example.com", message.getSender());
        assertEquals("098-765-4321", message.getPhone());
        assertEquals("This is another test message.", message.getMessageContent());
    }

    @Test
    public void testMessageToString() {
        // Cria uma instância da entidade Message
        MessageForm form = new MessageForm(
                "Jane Doe",
                "janedoe@example.com",
                "098-765-4321",
                "This is another test message."
        );

        Message message = messageBuilder(form);
        assertNotNull(message.toString());

        // Verifica se o método toString contém todos os valores esperados
        String expectedString = "Message(id=" + message.getId() +
                ", name=Jane Doe, sender=janedoe@example.com, phone=098-765-4321, messageContent=This is another test message.)";
        assertEquals(expectedString, message.toString());
    }

    private Message messageBuilder(MessageForm form) {
        UUID id = UUID.randomUUID();
        return Message.builder()
                .id(id)
                .name(form.name())
                .sender(form.sender())
                .phone(form.phone())
                .messageContent(form.messageContent())
                .build();
    }
}
