package com.market.agasale.repo;

import com.market.agasale.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Long> {
}
