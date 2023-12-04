package br.com.marcos.portifolios.controller;

import br.com.marcos.portifolios.model.dto.MensagemForm;
import br.com.marcos.portifolios.service.ComunicacaoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class IndexController {

    private final ComunicacaoServiceImpl comunicacaoServiceImpl;

    public IndexController(ComunicacaoServiceImpl comunicacaoServiceImpl) {
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

    @PostMapping("/enviar-whatsapp")
    public ResponseEntity<String> enviarWhatsapp(@ModelAttribute String mensagem) {
        comunicacaoServiceImpl.enviarWhatsapp(mensagem);
        return ResponseEntity.ok("Solicitação de envio realizada com sucesso!");
    }

}
