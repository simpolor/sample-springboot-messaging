package io.simpolor.activemq.component;

import io.simpolor.activemq.model.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageReceiver {

    @Value("${activemq.queue.name}")
    private String queueName;

    // jmsTemplate 을 통해 메세지 송신 가능
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = "${activemq.queue.name}")
    public void receive(MessageDto messageDto) {
        log.info("Received message : {}",messageDto.toString());
    }
}
