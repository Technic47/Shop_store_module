package ru.kuznetsov.shop_store_module.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final ObjectMapper objectMapper = new ObjectMapper();
    public final static String MESSAGE_TOPIC_NAME = "message";

    Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @KafkaListener(topics = MESSAGE_TOPIC_NAME, groupId = "${spring.kafka.consumer.group-id}")
    public void listenGroupFoo(String message) {

    }
}
