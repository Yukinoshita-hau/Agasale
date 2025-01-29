package com.market.agasale.repo;

import com.market.agasale.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
}
