package br.com.marcos.portifolios.consumer;

import br.com.marcos.portifolios.config.EmailQueueConfiguration;
import br.com.marcos.portifolios.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(EmailQueueConfiguration.ENVIO_EMAIL_QUEUE),
            exchange = @Exchange(name = EmailQueueConfiguration.ENVIO_EMAIL_EXCHANGE),
            key = EmailQueueConfiguration.ROUTING_KEY))
    public void processarEnvioCteEmMassa(final Message message) {
        String body = new String(message.getBody());
        log.info("processarEnvioEmail -> Enviando para a fila ENVIO_EMAIL_QUEUE");
        emailService.enviarEmail(body);
    }

}
