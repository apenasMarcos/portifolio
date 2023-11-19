package br.com.marcos.portifolios.controller;

import br.com.marcos.portifolios.model.form.MensagemForm;
import br.com.marcos.portifolios.service.ComunicacaoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void salvarMensagem(@ModelAttribute MensagemForm form) {
        comunicacaoServiceImpl.salvarMensagemQueue(form);
    }

    @PostMapping
    public ResponseEntity<String> enviarWhatsapp(@ModelAttribute String mensagem) {
        comunicacaoServiceImpl.enviarWhatsapp(mensagem);
        return ResponseEntity.ok("Solicitação de envio realizada com sucesso!");
    }

}
