package com.market.agasale.controller;

import com.market.agasale.common.dto.CreateOrderItemDto;
import com.market.agasale.common.dto.DeleteOrderItemDto;
import com.market.agasale.common.dto.UpdateOrderItemDto;
import com.market.agasale.model.OrderItem;
import com.market.agasale.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/orderItem/{id}")
    public OrderItem getOrderItem(@PathVariable long id) {
        return orderItemService.getOrderItem(id);
    }

    @PostMapping("/orderItem")
    public OrderItem createOrderItem(@RequestBody CreateOrderItemDto orderItemDto) {
        return orderItemService.createOrderItem(orderItemDto);
    }

    @PutMapping("/orderItem")
    public OrderItem updateOrderItem(@RequestBody UpdateOrderItemDto orderItemDto) {
        return orderItemService.updateOrderItem(orderItemDto);
    }

    @DeleteMapping("/orderItem/{id}")
    public DeleteOrderItemDto deleteOrderItem (@PathVariable long id) {
        return orderItemService.deleteOrderItem(id);
    }
}
