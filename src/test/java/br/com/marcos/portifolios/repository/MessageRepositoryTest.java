package br.com.marcos.portifolios.repository;

import br.com.marcos.portifolios.model.Message;
import br.com.marcos.portifolios.model.dto.MessageForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSaveAndFindById() {
        // Cria um formulário de mensagem
        MessageForm form = new MessageForm(
                "John Doe",
                "johndoe@example.com",
                "123-456-7890",
                "Hello, this is a test message."
        );

        // Constrói a entidade Message
        Message message = new Message(form);

        // Salva a entidade
        Message savedMessage = messageRepository.save(message);

        // Busca a entidade pelo ID
        Optional<Message> retrievedMessage = messageRepository.findById(savedMessage.getId());

        // Verifica se a entidade foi encontrada e os valores estão corretos
        assertThat(retrievedMessage).isPresent();
        assertThat(retrievedMessage.get().getName()).isEqualTo(form.name());
        assertThat(retrievedMessage.get().getSender()).isEqualTo(form.sender());
        assertThat(retrievedMessage.get().getPhone()).isEqualTo(form.phone());
        assertThat(retrievedMessage.get().getMessageContent()).isEqualTo(form.messageContent());
    }

    @Test
    public void testExistsById() {
        // Cria e salva uma mensagem
        MessageForm form = new MessageForm(
                "Jane Doe",
                "janedoe@example.com",
                "098-765-4321",
                "This is another test message."
        );
        Message message = new Message(form);
        messageRepository.save(message);

        // Verifica se a mensagem existe pelo ID
        boolean exists = messageRepository.existsById(message.getId());
        assertThat(exists).isTrue();
    }

    @Test
    public void testDeleteById() {
        // Cria e salva uma mensagem
        MessageForm form = new MessageForm(
                "Jane Doe",
                "janedoe@example.com",
                "098-765-4321",
                "This is another test message."
        );
        Message message = new Message(form);
        messageRepository.save(message);

        // Deleta a mensagem pelo ID
        messageRepository.deleteById(message.getId());

        // Verifica se a mensagem não existe mais
        Optional<Message> retrievedMessage = messageRepository.findById(message.getId());
        assertThat(retrievedMessage).isNotPresent();
    }

    @Test
    public void testCount() {
        // Conta o número inicial de mensagens
        long initialCount = messageRepository.count();

        // Cria e salva uma nova mensagem
        MessageForm form = new MessageForm(
                "John Smith",
                "johnsmith@example.com",
                "555-555-5555",
                "This is a new test message."
        );
        Message message = new Message(form);
        messageRepository.save(message);

        // Conta o número de mensagens novamente
        long finalCount = messageRepository.count();
        assertThat(finalCount).isEqualTo(initialCount + 1);
    }
}
