package com.lightcodes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MesssagePublisher {

    @Value("${rabbitmq.exchange.test}")
    private String exchange;

    
    @Value("${rabbitmq.routingkey.test}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(MesssagePublisher.class);

    public MesssagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void PublishMessage(String message){
        LOGGER.info(message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
