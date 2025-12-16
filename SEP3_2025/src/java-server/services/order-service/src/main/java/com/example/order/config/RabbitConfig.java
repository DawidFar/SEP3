package com.example.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean public DirectExchange ordersExchange(){ return new DirectExchange("orders.exchange"); }
    @Bean public Queue ordersQueue(){ return new Queue("orders.created.queue"); }
    @Bean public Binding ordersBinding(){ return BindingBuilder.bind(ordersQueue()).to(ordersExchange()).with("orders.created"); }
}
