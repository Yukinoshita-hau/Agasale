package com.market.agasale.repo;

import com.market.agasale.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
