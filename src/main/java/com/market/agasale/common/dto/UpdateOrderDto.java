package com.market.agasale.common.dto;

import com.market.agasale.common.enums.OrderStatus;

public class UpdateOrderDto {
    public long id;
    public OrderStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
