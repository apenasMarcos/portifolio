package br.com.marcos.portifolios.Consumer;


import br.com.marcos.portifolios.config.SalvarMensagemQueueConfiguration;
import br.com.marcos.portifolios.model.dto.MensagemForm;
import br.com.marcos.portifolios.service.MensagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SalvarMensagemConsumer {

    private final MensagemService mensagemService;

    @RabbitListener(queues = SalvarMensagemQueueConfiguration.SALVAR_MENSAGEM_QUEUE)
    public void salvarMensagemMensagem(MensagemForm form) {
        try {
            log.info("Recebida mensagem da fila: " + form.toString());
            mensagemService.salvarMensagem(form);
        } catch(Exception ex) {
            log.error("Ocorreu um erro ao salvar a mensagem: ", ex);
        }
    }

}
