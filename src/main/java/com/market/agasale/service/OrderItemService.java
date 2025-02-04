package com.market.agasale.service;

import com.market.agasale.common.dto.CreateOrderItemDto;
import com.market.agasale.common.dto.DeleteOrderItemDto;
import com.market.agasale.common.dto.UpdateOrderItemDto;
import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.OrderItemNotFoundException;
import com.market.agasale.exception.ProductNotFoundException;
import com.market.agasale.model.Order;
import com.market.agasale.model.OrderItem;
import com.market.agasale.model.Product;
import com.market.agasale.repo.OrderItemRepo;
import com.market.agasale.repo.OrderRepo;
import com.market.agasale.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepo orderItemRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductRepo productRepo;

    public OrderItem getOrderItem(long id) {
        Optional<OrderItem> optionalOrderItem = orderItemRepo.findById(id);

        if (optionalOrderItem.isPresent()) {
            return optionalOrderItem.get();
        } else {
            throw new OrderItemNotFoundException(HttpDefaultMessage.HTTP_ORDERITEM_NOT_FOUND_MESSAGE.getHttpOrderItemNotFoundMessageWithId(id));
        }
    }

    public OrderItem createOrderItem(CreateOrderItemDto orderItemDto) {
        Optional<Order> optionalOrder = orderRepo.findById(orderItemDto.orderId);

        if (optionalOrder.isPresent()) {
            Optional<Product> optionalProduct = productRepo.findById(orderItemDto.productId);

            if (optionalProduct.isPresent()) {
                OrderItem orderItem = new OrderItem();

                orderItem.setOrder(optionalOrder.get());
                orderItem.setProduct(optionalProduct.get());
                orderItem.setQuantity(orderItemDto.getQuantity());
                BigDecimal productPrice = orderItem.getProduct().getPrice();
                int orderItemQuantity = orderItem.getQuantity();
                orderItem.setPrice(productPrice.multiply(BigDecimal.valueOf(orderItemQuantity)));

                return orderItemRepo.save(orderItem);
            } else {
                throw new ProductNotFoundException(HttpDefaultMessage.HTTP_PRODUCT_NOT_FOUND_MESSAGE.getHttpProductNotFoundMessageWithId(orderItemDto.productId));
            }
        } else {
            throw new OrderItemNotFoundException(HttpDefaultMessage.HTTP_ORDER_NOT_FOUND_MESSAGE.getHttpOrderNotFoundMessageWithId(orderItemDto.orderId));
        }
    }

    public OrderItem updateOrderItem(UpdateOrderItemDto orderItemDto) {
        Optional<OrderItem> optionalOrderItem = orderItemRepo.findById(orderItemDto.getId());

        if (optionalOrderItem.isPresent()) {
            OrderItem orderItem = optionalOrderItem.get();
            orderItem.setQuantity(orderItemDto.getQuantity());
            BigDecimal productPrice = orderItem.getProduct().getPrice();
            int orderItemQuantity = orderItem.getQuantity();
            orderItem.setPrice(productPrice.multiply(BigDecimal.valueOf(orderItemQuantity)));

            return orderItemRepo.save(orderItem);
        } else {
            throw new OrderItemNotFoundException(HttpDefaultMessage.HTTP_ORDERITEM_NOT_FOUND_MESSAGE.getHttpOrderItemNotFoundMessageWithId(orderItemDto.getId()));
        }
    }

    public DeleteOrderItemDto deleteOrderItem(long id) {
        Optional<OrderItem> optionalOrderItem = orderItemRepo.findById(id);

        if (optionalOrderItem.isPresent()) {
            orderItemRepo.deleteById(id);

            return new DeleteOrderItemDto(optionalOrderItem.get().getId(),
                                          optionalOrderItem.get().getOrder(),
                                          optionalOrderItem.get().getProduct(),
                                          optionalOrderItem.get().getQuantity(),
                                          optionalOrderItem.get().getPrice());
        } else {
            throw new OrderItemNotFoundException(HttpDefaultMessage.HTTP_ORDERITEM_NOT_FOUND_MESSAGE.getHttpOrderItemNotFoundMessageWithId(id));
        }
    }
}
