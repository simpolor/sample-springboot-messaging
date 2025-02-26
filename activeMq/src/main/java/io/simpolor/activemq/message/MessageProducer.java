package io.simpolor.activemq.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageProducer {

    private static final String QUEUE_NAME = "student";

    // jmsTemplate 을 통해 메세지 송신 가능
    private final JmsTemplate jmsTemplate;

    /**
     * Queue 로 메세지를 발행
     */
    public void sendMessage(String message) {
        log.info("MessageProducer.sendMessage : {}", message);

        // queueName(Sample-queue) 에 메세지 전송
        jmsTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
