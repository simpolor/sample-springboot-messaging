package io.simpolor.activemq.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {

    @JmsListener(destination = "student")
    public void receiveMessage(String message) {
        log.info("MessageConsumer.receiveMessage : {}", message);
    }
}
