package com.market.agasale.model;

import com.market.agasale.common.enums.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Consumer consumer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    private BigDecimal totalAmount;
    private OrderStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
