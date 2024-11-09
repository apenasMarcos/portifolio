package br.com.marcos.portifolios.service;

import br.com.marcos.portifolios.model.Message;
import br.com.marcos.portifolios.model.dto.MessageForm;
import br.com.marcos.portifolios.repository.MessageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class MessageServiceImplTest {

    @Mock
    private MessageRepository messageRepository;
    @InjectMocks
    private MessageServiceImpl messageService;
    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void testSaveMessage() {
        // Dados de exemplo para o formulário de mensagem
        MessageForm form = new MessageForm("John Doe","johndoe@example.com","123-456-7890","Hello, this is a test message.");

        // Mock do comportamento do messageRepository.save
        Message savedMessage = new Message();
        savedMessage.setId(UUID.randomUUID());
        when(messageRepository.save(any(Message.class))).thenReturn(savedMessage);

        // Chama o método que queremos testar
        messageService.saveMessage(form);

        // Verificações
        verify(messageRepository, times(1)).save(any(Message.class));
    }
}
