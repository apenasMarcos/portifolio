package br.com.marcos.portifolios.controller;

import br.com.marcos.portifolios.model.dto.MensagemForm;
import br.com.marcos.portifolios.service.MensagemServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class IndexController {

    private final MensagemServiceImpl comunicacaoServiceImpl;

    public IndexController(MensagemServiceImpl comunicacaoServiceImpl) {
        this.comunicacaoServiceImpl = comunicacaoServiceImpl;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/salvar-mensagem")
    public ResponseEntity<String> salvarMensagem(@ModelAttribute MensagemForm form) {
        try {
            comunicacaoServiceImpl.salvarMensagemQueue(form);
            return ResponseEntity.ok("Mensagem salva com sucesso.");
        } catch (Exception ignored) {
            return ResponseEntity.internalServerError().body("Erro ao salvar a mensagem.");
        }
    }


}
