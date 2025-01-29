package com.market.agasale.repo;

import com.market.agasale.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepo extends JpaRepository<Consumer, Long> {
}
