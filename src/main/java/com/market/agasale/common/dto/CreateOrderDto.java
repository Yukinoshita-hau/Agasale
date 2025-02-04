package com.market.agasale.common.dto;

import com.market.agasale.common.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateOrderDto {
    public long consumerId;
    public BigDecimal totalAmount;
    public OrderStatus status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(long consumerId) {
        this.consumerId = consumerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
