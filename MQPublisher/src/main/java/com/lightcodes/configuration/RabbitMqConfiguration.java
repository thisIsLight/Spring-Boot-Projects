package com.lightcodes.configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfiguration {
    
    @Value("${rabbitmq.queue.test}")
    private String queue;

    @Value("${rabbitmq.exchange.test}")
    private String exchange;

    
    @Value("${rabbitmq.routingkey.test}")
    private String routingKey;

    //Create Queue
    @Bean
    public Queue GetQueue(){
        return new Queue(queue);
    }

    //Create exchange
    @Bean
    public TopicExchange GetExchange(){
        return new TopicExchange(exchange);
    }

    //Bind exchange to queue using routing key
    @Bean
    public Binding BindQueue(){
        return BindingBuilder.bind(GetQueue())
            .to(GetExchange())
            .with(routingKey);
    }
}
