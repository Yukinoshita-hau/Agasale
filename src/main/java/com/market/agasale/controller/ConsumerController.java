package com.market.agasale.controller;

import com.market.agasale.common.dto.DeleteConsumerDto;
import com.market.agasale.common.dto.UpdateConsumerDto;
import com.market.agasale.model.Consumer;
import com.market.agasale.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumers")
    public List<Consumer> getAllConsumers() {
        return consumerService.getAllConsumers();
    }

    @GetMapping("/consumer/{id}")
    public Consumer getConsumer(@PathVariable long id) {
        return consumerService.getConsumer(id);
    }

    @PostMapping("/consumer")
    public Consumer createConsumer(@RequestBody Consumer consumer) {
        return consumerService.createConsumer(consumer);
    }

    @PutMapping("/consumer")
    public Consumer updateConsumer(@RequestBody UpdateConsumerDto updateConsumerDto) {
        return consumerService.updateConsumer(updateConsumerDto);
    }

    @DeleteMapping("/consumer/{id}")
    public DeleteConsumerDto deleteConsumer(@PathVariable long id) {
        return consumerService.deleteConsumer(id);
    }
}
