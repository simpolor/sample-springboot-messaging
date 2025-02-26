package io.simpolor.rabbitmq.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {

    @RabbitListener(queues = "student")
    public void receiveMessage(String message) {
        log.info("MessageConsumer.receiveMessage : {}", message);
    }
}
