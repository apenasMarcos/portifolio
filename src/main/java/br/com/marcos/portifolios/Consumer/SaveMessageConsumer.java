package br.com.marcos.portifolios.Consumer;

import br.com.marcos.portifolios.config.SaveMessageQueueConfiguration;
import br.com.marcos.portifolios.model.dto.MessageForm;
import br.com.marcos.portifolios.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SaveMessageConsumer {

    private final MessageService messageService;

    @RabbitListener(queues = SaveMessageQueueConfiguration.SAVE_MESSAGE_QUEUE)
    public void saveMessage(MessageForm form) {
        try {
            log.info("Received message from queue: {}", form.toString());
            messageService.saveMessage(form);
        } catch(Exception ex) {
            log.error("An error occurred while saving the message: ", ex);
        }
    }
}
