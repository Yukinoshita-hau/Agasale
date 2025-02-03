package com.market.agasale.controller;

import com.market.agasale.common.dto.CreateCartItemDto;
import com.market.agasale.common.dto.DeleteCartItemDto;
import com.market.agasale.common.dto.UpdateCartItemDto;
import com.market.agasale.model.CartItem;
import com.market.agasale.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @GetMapping("/cartItem/{id}")
    public CartItem getCartItem(@PathVariable long id) {
        return cartItemService.getCartItem(id);
    }

    @PostMapping("/cartItem")
    public CartItem createCartItem(@RequestBody CreateCartItemDto cartItemDto) {
        return cartItemService.createCartItem(cartItemDto);
    }

    @PutMapping("/cartItem")
    public CartItem updateCartItem(@RequestBody UpdateCartItemDto cartItemDto) {
        return cartItemService.updateCartItem(cartItemDto);
    }

    @DeleteMapping("/cartItem/{id}")
    public DeleteCartItemDto updateCartItem(@PathVariable long id) {
        return cartItemService.deleteCartItem(id);
    }
}
