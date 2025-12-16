package com.example.order.controller;

import com.example.order.entity.OrderEntity;
import com.example.order.repository.OrderRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository repo;
    private final AmqpTemplate amqp;

    public OrderController(OrderRepository repo, AmqpTemplate amqp){ this.repo = repo; this.amqp = amqp; }

    @GetMapping
    public List<OrderEntity> list(){ return repo.findAll(); }

    @PostMapping
    public OrderEntity create(@RequestBody OrderEntity order){
        order.setStatus("PENDING");
        var saved = repo.save(order);
        // publish minimal event
        amqp.convertAndSend("orders.exchange", "orders.created", saved.getId().toString());
        return saved;
    }
}
