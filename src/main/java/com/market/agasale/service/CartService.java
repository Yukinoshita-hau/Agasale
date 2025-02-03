package com.market.agasale.service;

import com.market.agasale.common.dto.DeleteCartDto;
import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.CartNotFoundException;
import com.market.agasale.model.Cart;
import com.market.agasale.model.Consumer;
import com.market.agasale.repo.CartRepo;
import com.market.agasale.repo.ConsumerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    ConsumerRepo consumerRepo;

    public Cart getCart(long id) {
        Optional<Cart> cartOptional = cartRepo.findById(id);

        if (cartOptional.isPresent()) {
            return cartOptional.get();
        } else {
            throw new CartNotFoundException(HttpDefaultMessage.HTTP_CART_NOT_FOUND_MESSAGE.getHttpCartNotFoundMessageWithId(id));
        }
    }

    public Cart createCart(long consumerId) {
        Optional<Consumer> optionalConsumer = consumerRepo.findById(consumerId);

        if (optionalConsumer.isPresent()) {
            Consumer consumer = optionalConsumer.get();

            Cart cart = new Cart();
            cart.setConsumer(consumer);

            return cartRepo.save(cart);
        } else {
            throw new CartNotFoundException(HttpDefaultMessage.HTTP_CONSUMER_NOT_FOUND_MESSAGE.getHttpConsumerNotFoundMessageWithId(consumerId));
        }
    }

    public DeleteCartDto deleteCart(long id) {
        Optional<Cart> optionalCart = cartRepo.findById(id);

        if (optionalCart.isPresent()) {
            cartRepo.deleteById(id);
            return new DeleteCartDto(optionalCart.get().getId());
        } else {
            throw new CartNotFoundException(HttpDefaultMessage.HTTP_CART_NOT_FOUND_MESSAGE.getHttpCartNotFoundMessageWithId(id));
        }
    }
}
