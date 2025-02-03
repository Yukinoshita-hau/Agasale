package com.market.agasale.controller;

import com.market.agasale.common.dto.CreateCartDto;
import com.market.agasale.common.dto.DeleteCartDto;
import com.market.agasale.model.Cart;
import com.market.agasale.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable long id) {
        return cartService.getCart(id);
    }

    @PostMapping("/cart")
    public Cart createCart(@RequestBody CreateCartDto createCartDto) {
        return cartService.createCart(createCartDto.getConsumerId());
    }

    @DeleteMapping("/cart/{id}")
    public DeleteCartDto deleteCart(@PathVariable long id) {
        return cartService.deleteCart(id);
    }
}
