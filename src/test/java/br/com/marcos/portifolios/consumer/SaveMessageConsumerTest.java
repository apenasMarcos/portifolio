package br.com.marcos.portifolios.consumer;

import br.com.marcos.portifolios.model.dto.MessageForm;
import br.com.marcos.portifolios.service.MessageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class SaveMessageConsumerTest {
/*
    @Mock
    private MessageService messageService;

    @InjectMocks
    private SaveMessageConsumer saveMessageConsumer;

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
    public void testSaveMessage() {
        MessageForm form = new MessageForm("John Doe", "john.doe@example.com", "1234567890", "Test message");

        saveMessageConsumer.saveMessage(form);

        verify(messageService, times(1)).saveMessage(form);
    }

 */
}
