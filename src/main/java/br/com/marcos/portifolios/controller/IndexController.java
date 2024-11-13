package br.com.marcos.portifolios.controller;

import br.com.marcos.portifolios.model.dto.MessageDto;
import br.com.marcos.portifolios.model.dto.MessageForm;
import br.com.marcos.portifolios.service.MessageService;
import br.com.marcos.portifolios.service.MessageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final MessageService messageService;

    public IndexController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String index() {
        logger.info("GET request received for /");
        return "index";
    }

    @PostMapping("/save-message")
    public ResponseEntity<String> saveMessage(@ModelAttribute MessageForm form) {
        try {
            logger.info("Received POST request to save message: {}", form.toString());
            messageService.saveMessage(form);
            return ResponseEntity.ok("Messagem encaminhada para salvar.");
        } catch (Exception ex) {
            logger.error("Error saving the message.", ex);
            return ResponseEntity.internalServerError().body("Ocorreu um erro ao salvar sua mensagem.");
        }
    }


    @GetMapping("/get-messages")
    public ResponseEntity<List<MessageDto>> getMessages() {
        try {
            List<MessageDto> messages = messageService.getMessages();

            return ResponseEntity.ok()
                    .header("X-Custom-Header", "value")
                    .body(messages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }
}
