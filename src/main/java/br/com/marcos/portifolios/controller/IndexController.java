package br.com.marcos.portifolios.controller;

import br.com.marcos.portifolios.model.form.EmailForm;
import br.com.marcos.portifolios.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class IndexController {

    private final EmailService emailService;

    public IndexController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/fale-comigo")
    public void falarComigo(@RequestBody EmailForm form) {
        emailService.enviarQueue(form);
    }
}

