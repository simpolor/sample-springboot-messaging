package io.simpolor.activemq.component;

import io.simpolor.activemq.model.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageSender {

    @Value("${activemq.queue.name}")
    private String queueName;

    // jmsTemplate 을 통해 메세지 송신 가능
    private final JmsTemplate jmsTemplate;

    /**
     * Queue 로 메세지를 발행
     * messageDto -> Producer 가 Queue 발행한 메세지 Class
     */
    public void send(MessageDto messageDto) {
        log.info("message sent : {}", messageDto.toString());
        // queueName(Sample-queue) 에 메세지 전송
        jmsTemplate.convertAndSend(queueName,messageDto);
    }
}
