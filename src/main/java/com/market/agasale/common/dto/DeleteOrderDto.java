package com.market.agasale.common.dto;

import com.market.agasale.common.enums.OrderStatus;
import com.market.agasale.model.Consumer;
import com.market.agasale.model.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DeleteOrderDto {
    public long id;
    public Consumer consumer;
    public BigDecimal totalAmount;
    public OrderStatus status;
    public LocalDateTime cratedAt;
    public LocalDateTime updatedAt;

    public DeleteOrderDto(long id, Consumer consumer, BigDecimal totalAmount, OrderStatus status, LocalDateTime cratedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.consumer = consumer;
        this.totalAmount = totalAmount;
        this.status = status;
        this.cratedAt = cratedAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        this.cratedAt = cratedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
