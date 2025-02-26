package io.simpolor.rabbitmq.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageProducer {

    private static final String QUEUE_NAME = "student";

    // RabbitTemplate 을 통해 메세지 송신 가능
    private final RabbitTemplate rabbitTemplate;

    /**
     * Queue 로 메세지를 발행
     */
    public void sendMessage(String message) {
        log.info("MessageProducer.sendMessage : {}", message);
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
