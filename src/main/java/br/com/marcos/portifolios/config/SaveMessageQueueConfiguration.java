package br.com.marcos.portifolios.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class SaveMessageQueueConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(SaveMessageQueueConfiguration.class);

    public static final String SAVE_MESSAGE_EXCHANGE = "SAVE_MESSAGE_EXCHANGE";
    public static final String SAVE_MESSAGE_QUEUE = "SAVE_MESSAGE_QUEUE";
    public static final String ROUTING_KEY = "saveMessage";

    @Bean
    public DirectExchange saveMessageExchange() {
        logger.info("Creating DirectExchange: {}", SAVE_MESSAGE_EXCHANGE);
        return new DirectExchange(SAVE_MESSAGE_EXCHANGE);
    }

    @Bean
    public Queue saveMessageQueue() {
        logger.info("Creating Queue: {}", SAVE_MESSAGE_QUEUE);
        return QueueBuilder.durable(SAVE_MESSAGE_QUEUE).build();
    }

    @Bean
    public Binding binding(@Qualifier("saveMessageQueue") Queue saveMessageQueue, DirectExchange saveMessageExchange) {
        logger.info("Binding Queue: {} to Exchange: {} with Routing Key: {}", SAVE_MESSAGE_QUEUE, SAVE_MESSAGE_EXCHANGE, ROUTING_KEY);
        return BindingBuilder.bind(saveMessageQueue).to(saveMessageExchange).with(ROUTING_KEY);
    }
}
