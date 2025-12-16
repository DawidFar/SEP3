package com.example.order.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orders_table")
public class OrderEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String userId;
    private double totalAmount;
    private String status; // PENDING, PAID, CANCELLED

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
