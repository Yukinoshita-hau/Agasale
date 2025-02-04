package com.market.agasale.controller;

import com.market.agasale.common.dto.CreateOrderDto;
import com.market.agasale.common.dto.DeleteOrderDto;
import com.market.agasale.common.dto.UpdateOrderDto;
import com.market.agasale.model.Order;
import com.market.agasale.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable long id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody CreateOrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PutMapping("/order")
    public Order updateOrder(@RequestBody UpdateOrderDto updateOrderDto) {
        return orderService.updateOrder(updateOrderDto);
    }

    @DeleteMapping("/order/{id}")
    public DeleteOrderDto deleteOrderDto(@PathVariable long id) {
        return orderService.deleteOrder(id);
    }
}
