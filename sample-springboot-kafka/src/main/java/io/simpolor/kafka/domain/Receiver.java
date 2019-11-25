package io.simpolor.kafka.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch(){
        return latch;
    }

    @KafkaListener(topics = "helloworld.t")
    public void received(String payload){
        log.info("received payload : {}", payload);
        latch.countDown();
    }

}
