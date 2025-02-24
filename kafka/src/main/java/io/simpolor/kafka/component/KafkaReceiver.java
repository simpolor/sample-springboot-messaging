package io.simpolor.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class KafkaReceiver {

    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "student")
    public void receive(String payload){

        log.info("KafkaReceiver.receive payload : {}", payload);

        latch.countDown();
    }
}
