package com.market.agasale.service;

import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.CartNotFoundException;
import com.market.agasale.model.Cart;
import com.market.agasale.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    /*@Autowired
    CartRepo cartRepo;

    public Cart getCart(long id) {
        Optional<Cart> cartOptional = cartRepo.findById(id);

        if (cartOptional.isPresent()) {
            return cartOptional.get();
        } else {
            throw new CartNotFoundException(HttpDefaultMessage);
        }
    }*/
}
