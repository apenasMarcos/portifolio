package br.com.marcos.portifolios.consumer;

import br.com.marcos.portifolios.config.EmailQueueConfiguration;
import br.com.marcos.portifolios.service.EmailService;
import br.com.marcos.portifolios.model.form.EmailForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(EmailQueueConfiguration.ENVIO_EMAIL_QUEUE),
            exchange = @Exchange(name = EmailQueueConfiguration.ENVIO_EMAIL_EXCHANGE),
            key = EmailQueueConfiguration.ROUTING_KEY))
    public void processarEnvioCteEmMassa(EmailForm emailForm) {
        try{
            log.info("Recebida mensagem da fila: " + emailForm.toString());
            emailService.enviarEmail(emailForm);
        } catch(Exception ex) {
            log.error("Ocorreu um erro ao realizar o envio de email: ", ex);
        }
    }

}
