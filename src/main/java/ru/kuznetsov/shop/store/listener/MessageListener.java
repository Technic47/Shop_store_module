package ru.kuznetsov.shop.store.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final ObjectMapper objectMapper;
    public final static String ADD_PRODUCT_TOPIC_NAME = "shop_add_product";

    Logger logger = LoggerFactory.getLogger(MessageListener.class);

//    @KafkaListener(topics = ADD_PRODUCT_TOPIC_NAME, groupId = "${spring.kafka.consumer.group-id}")
//    @SendTo()
//    public Reply listenGroupFoo(String message) {
//
//    }
}
