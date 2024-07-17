package br.com.marcos.portifolios.controller;

import br.com.marcos.portifolios.model.dto.MessageForm;
import br.com.marcos.portifolios.service.MessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(IndexController.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageServiceImpl messageService;

    @BeforeEach
    public void setup() {
        IndexController indexController = new IndexController(messageService);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testSaveMessage_Success() throws Exception {
        MessageForm form = new MessageForm("John Doe", "john.doe@example.com", "1234567890", "Test message");

        mockMvc.perform(post("/save-message")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", form.name())
                        .param("sender", form.sender())
                        .param("phone", form.phone())
                        .param("messageContent", form.messageContent()))
                .andExpect(status().isOk())
                .andExpect(content().string("Messagem encaminhada para salvar."));

        verify(messageService, times(1)).saveMessageQueue(form);
    }

    @Test
    public void testSaveMessage_Error() throws Exception {
        MessageForm form = new MessageForm("John Doe", "john.doe@example.com", "1234567890", "Test message");

        doThrow(new RuntimeException("Erro ao salvar mensagem")).when(messageService).saveMessageQueue(form);

        mockMvc.perform(post("/save-message")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", form.name())
                        .param("sender", form.sender())
                        .param("messageContent", form.messageContent()))
                .andExpect(status().isOk())
                .andExpect(content().string("Messagem encaminhada para salvar."));

        verify(messageService, never()).saveMessageQueue(form);
    }
}
