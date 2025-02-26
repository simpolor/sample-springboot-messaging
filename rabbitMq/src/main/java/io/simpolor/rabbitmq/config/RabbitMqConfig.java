package io.simpolor.rabbitmq.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

    private static final String QUEUE_NAME = "student";
    private static final String EXCHANGE_NAME = "studentExchange";
    private static final String ROUTING_KEY = "studentRoutingKey";

    /**
     * 📌 1. 큐(Queue) 생성
     * durable = true (메시지를 영구 저장)
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    /**
     * 📌 2. 익스체인지(Exchange) 생성
     * DirectExchange → 특정 라우팅 키가 일치하는 메시지만 전달
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    /**
     * 📌 3. 큐와 익스체인지를 바인딩 (라우팅 키 사용)
     */
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
