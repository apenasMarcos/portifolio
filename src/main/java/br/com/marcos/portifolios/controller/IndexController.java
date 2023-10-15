package br.com.marcos.portifolios.controller;

import br.com.marcos.portifolios.model.form.EmailForm;
import br.com.marcos.portifolios.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    private final EmailService emailService;

    public IndexController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/fale-comigo")
    public ResponseEntity<String> falarComigo(@ModelAttribute EmailForm form) {
        emailService.enviarEmailQueue(form);
        return ResponseEntity.ok("Solicitação de envio realizada com sucesso!");
    }
}
