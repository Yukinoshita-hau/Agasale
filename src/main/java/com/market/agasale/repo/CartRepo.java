package com.market.agasale.repo;

import com.market.agasale.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}
