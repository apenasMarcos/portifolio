package br.com.marcos.portifolios.config;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import static org.junit.jupiter.api.Assertions.*;

class SaveMessageQueueConfigurationTest {

    // Instância da classe que será testada
    private final SaveMessageQueueConfiguration saveMessageQueueConfiguration = new SaveMessageQueueConfiguration();

    @Test
    void testSaveMessageExchange() {
        // Teste para verificar se o método retorna um objeto DirectExchange não nulo
        DirectExchange exchange = saveMessageQueueConfiguration.saveMessageExchange();
        assertNotNull(exchange);
        // Verifica se o nome do exchange retornado é o esperado
        assertEquals(SaveMessageQueueConfiguration.SAVE_MESSAGE_EXCHANGE, exchange.getName());
    }

    @Test
    void testSaveMessageQueue() {
        // Teste para verificar se o método retorna uma Queue não nula e durável
        Queue queue = saveMessageQueueConfiguration.saveMessageQueue();
        assertNotNull(queue);
        // Verifica se o nome da fila retornada é o esperado
        assertEquals(SaveMessageQueueConfiguration.SAVE_MESSAGE_QUEUE, queue.getName());
        // Verifica se a fila é durável
        assertTrue(queue.isDurable());
    }

    @Test
    void testBinding() {
        // Obtém o exchange e a fila para realizar o teste de binding
        DirectExchange exchange = saveMessageQueueConfiguration.saveMessageExchange();
        Queue queue = saveMessageQueueConfiguration.saveMessageQueue();
        // Obtém o binding entre a fila e o exchange
        Binding binding = saveMessageQueueConfiguration.binding(queue, exchange);
        assertNotNull(binding);
        // Verifica se o destino do binding é o mesmo que o nome da fila
        assertEquals(SaveMessageQueueConfiguration.SAVE_MESSAGE_QUEUE, binding.getDestination());
        // Verifica se o exchange do binding é o mesmo que o nome do exchange
        assertEquals(SaveMessageQueueConfiguration.SAVE_MESSAGE_EXCHANGE, binding.getExchange());
        // Verifica se a chave de roteamento do binding é a esperada
        assertEquals(SaveMessageQueueConfiguration.ROUTING_KEY, binding.getRoutingKey());
    }
}
