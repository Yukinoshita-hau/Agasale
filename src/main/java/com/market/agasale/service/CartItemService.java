package com.market.agasale.service;

import com.market.agasale.common.dto.CreateCartItemDto;
import com.market.agasale.common.dto.DeleteCartItemDto;
import com.market.agasale.common.dto.UpdateCartItemDto;
import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.CartItemNotFoundException;
import com.market.agasale.exception.CartNotFoundException;
import com.market.agasale.exception.ProductNotFoundException;
import com.market.agasale.model.Cart;
import com.market.agasale.model.CartItem;
import com.market.agasale.model.Product;
import com.market.agasale.repo.CartItemRepo;
import com.market.agasale.repo.CartRepo;
import com.market.agasale.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

    public CartItem getCartItem(long id) {
        Optional<CartItem> optionalCartItem = cartItemRepo.findById(id);

        if (optionalCartItem.isPresent()) {
            return optionalCartItem.get();
        } else {
            throw new CartItemNotFoundException(HttpDefaultMessage.HTTP_CARTITEM_NOT_FOUND_MESSAGE.getHttpCartItemNotFoundMessageWithId(id));
        }
    }

    public CartItem createCartItem(CreateCartItemDto cartItemDto) {
        Optional<Cart> optionalCart = cartRepo.findById(cartItemDto.getCartId());

        if (optionalCart.isPresent()) {
            Optional<Product> optionalProduct = productRepo.findById(cartItemDto.getProductId());

            if (optionalProduct.isPresent()) {
                CartItem cartItem = new CartItem();
                cartItem.setCart(optionalCart.get());
                cartItem.setProduct(optionalProduct.get());
                cartItem.setQuantity(1);

                return cartItemRepo.save(cartItem);
            } else {
                throw new ProductNotFoundException(HttpDefaultMessage.HTTP_PRODUCT_NOT_FOUND_MESSAGE.getHttpProductNotFoundMessageWithId(cartItemDto.getProductId()));
            }
        } else {
            throw new CartNotFoundException(HttpDefaultMessage.HTTP_CART_NOT_FOUND_MESSAGE.getHttpCartNotFoundMessageWithId(cartItemDto.getCartId()));
        }
    }

    public CartItem updateCartItem(UpdateCartItemDto cartItemDto) {
        Optional<CartItem> optionalCartItem = cartItemRepo.findById(cartItemDto.getId());

        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            cartItem.setQuantity(cartItemDto.getQuantity());

            return cartItemRepo.save(cartItem);
        } else {
            throw new CartItemNotFoundException(HttpDefaultMessage.HTTP_CARTITEM_NOT_FOUND_MESSAGE.getHttpCartItemNotFoundMessageWithId(cartItemDto.getId()));
        }
    }

    public DeleteCartItemDto deleteCartItem(long id) {
        Optional<CartItem> optionalCartItem = cartItemRepo.findById(id);

        if (optionalCartItem.isPresent()) {
            cartItemRepo.deleteById(id);

            return new DeleteCartItemDto(optionalCartItem.get().getId(),
                                                               optionalCartItem.get().getQuantity());
        } else {
            throw new CartItemNotFoundException(HttpDefaultMessage.HTTP_CARTITEM_NOT_FOUND_MESSAGE.getHttpCartItemNotFoundMessageWithId(id));
        }
    }
}
