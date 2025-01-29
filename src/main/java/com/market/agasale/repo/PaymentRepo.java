package com.market.agasale.repo;

import com.market.agasale.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
