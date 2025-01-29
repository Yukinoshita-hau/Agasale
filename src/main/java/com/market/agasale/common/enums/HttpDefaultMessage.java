package com.market.agasale.common.enums;

public enum HttpDefaultMessage {
    HTTP_CONSUMER_NOT_FOUND_MESSAGE("Пользователь не найден"),
    HTTP_SELLER_NOT_FOUND_MESSAGE("Продавец не найден"),
    HTTP_CART_NOT_FOUND_MESSAGE("Корзина не найдена");

    HttpDefaultMessage(String message) {
    }

    public String getHttpConsumerNotFoundMessageWithId(long id) {
        return "Пользователь с ID " + id + " не найден";
    }

    public String getHttpSellerNotFoundMessageWithId(long id) {
        return "Продавец с ID " + id + " не найден";
    }
}
