package com.market.agasale.service;

import com.market.agasale.common.dto.CreateOrderDto;
import com.market.agasale.common.dto.DeleteOrderDto;
import com.market.agasale.common.dto.UpdateOrderDto;
import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.OrderNotFoundException;
import com.market.agasale.exception.ProductNotFoundException;
import com.market.agasale.model.Consumer;
import com.market.agasale.model.Order;
import com.market.agasale.repo.ConsumerRepo;
import com.market.agasale.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ConsumerRepo consumerRepo;

    public Order getOrder(long id) {
        Optional<Order> optionalOrder = orderRepo.findById(id);

        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            throw new OrderNotFoundException(HttpDefaultMessage.HTTP_ORDER_NOT_FOUND_MESSAGE.getHttpOrderNotFoundMessageWithId(id));
        }
    }

    public Order createOrder(CreateOrderDto createOrderDto) {
        Optional<Consumer> optionalConsumer = consumerRepo.findById(createOrderDto.getConsumerId());

        if (optionalConsumer.isPresent()) {
            Order order = new Order();
            order.setConsumer(optionalConsumer.get());
            order.setStatus(createOrderDto.getStatus());
            BigDecimal totalAmount = BigDecimal.ZERO;
            if (order.getOrderItems() != null) {
                for (int i = 0; i < order.getOrderItems().size(); i++) {
                    totalAmount = totalAmount.add(order.getOrderItems().get(i).getPrice());
                }
                order.setTotalAmount(totalAmount);
            }
            order.setCreatedAt(LocalDateTime.now());
            order.setUpdatedAt(LocalDateTime.now());
            return orderRepo.save(order);
        } else {
            throw new ProductNotFoundException(HttpDefaultMessage.HTTP_CONSUMER_NOT_FOUND_MESSAGE.getHttpProductNotFoundMessageWithId(createOrderDto.getConsumerId()));
        }
    }

    public Order updateOrder(UpdateOrderDto orderDto) {
        Optional<Order> optionalOrder = orderRepo.findById(orderDto.getId());

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(orderDto.getStatus());
            order.setUpdatedAt(LocalDateTime.now());

            return orderRepo.save(order);
        } else {
            throw new OrderNotFoundException(HttpDefaultMessage.HTTP_ORDER_NOT_FOUND_MESSAGE.getHttpOrderNotFoundMessageWithId(orderDto.getId()));
        }
    }

    public DeleteOrderDto deleteOrder(long id) {
        Optional<Order> optionalOrder = orderRepo.findById(id);

        if (optionalOrder.isPresent()) {
            orderRepo.deleteById(id);
            return new DeleteOrderDto(id,
                                      optionalOrder.get().getConsumer(),
                                      optionalOrder.get().getTotalAmount(),
                                      optionalOrder.get().getStatus(),
                                      optionalOrder.get().getCreatedAt(),
                                      optionalOrder.get().getUpdatedAt());
        } else {
            throw new OrderNotFoundException(HttpDefaultMessage.HTTP_ORDER_NOT_FOUND_MESSAGE.getHttpOrderNotFoundMessageWithId(id));
        }
    }
}
