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
        Message message = new Message(form);

        // Verifica se os valores da entidade Message correspondem aos valores do Form
        assertEquals(form.name(), message.getName());
        assertEquals(form.sender(), message.getSender());
        assertEquals(form.phone(), message.getPhone());
        assertEquals(form.messageContent(), message.getMessageContent());
    }

    @Test
    public void testMessageConstructorWithAllArgs() {
        // Cria uma instância da entidade Message usando todos os argumentos
        UUID id = UUID.randomUUID();
        Message message = new Message(
                id,
                "Jane Doe",
                "janedoe@example.com",
                "098-765-4321",
                "This is another test message."
        );

        // Verifica se os valores estão corretamente atribuídos
        assertEquals(id, message.getId());
        assertEquals("Jane Doe", message.getName());
        assertEquals("janedoe@example.com", message.getSender());
        assertEquals("098-765-4321", message.getPhone());
        assertEquals("This is another test message.", message.getMessageContent());
    }

    @Test
    public void testMessageToString() {
        // Cria uma instância da entidade Message
        UUID id = UUID.randomUUID();
        Message message = new Message(
                id,
                "Jane Doe",
                "janedoe@example.com",
                "098-765-4321",
                "This is another test message."
        );

        // Verifica se o método toString não retorna null
        assertNotNull(message.toString());

        // Verifica se o método toString contém todos os valores esperados
        String expectedString = "Message(id=" + id +
                ", name=Jane Doe, sender=janedoe@example.com, phone=098-765-4321, messageContent=This is another test message.)";
        assertEquals(expectedString, message.toString());
    }
}
