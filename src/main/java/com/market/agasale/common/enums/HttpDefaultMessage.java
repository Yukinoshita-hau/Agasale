package com.market.agasale.common.enums;

public enum  HttpDefaultMessage {
    HTTP_CONSUMER_NOT_FOUND_MESSAGE("Пользователь не найден"),
    HTTP_SELLER_NOT_FOUND_MESSAGE("Продавец не найден"),
    HTTP_CART_NOT_FOUND_MESSAGE("Корзина не найдена"),
    HTTP_CARTITEM_NOT_FOUND_MESSAGE("Элемент корзины не найден"),
    HTTP_PRODUCT_NOT_FOUND_MESSAGE("Товар не был найден"),
    HTTP_ORDER_NOT_FOUND_MESSAGE("Заказ не был найден"),
    HTTP_ORDERITEM_NOT_FOUND_MESSAGE("Элемент заказа не был найден"),
    HTTP_CATEGORY_NOT_FOUND_MESSAGE("Категория не была найдена");

    HttpDefaultMessage(String message) {
    }

    public String getHttpConsumerNotFoundMessageWithId(long id) {
        return "Пользователь с ID " + id + " не найден";
    }

    public String getHttpSellerNotFoundMessageWithId(long id) {
        return "Продавец с ID " + id + " не найден";
    }

    public String getHttpCartNotFoundMessageWithId(long id) {
        return "Корзина с ID " + id + " не найдена";
    }

    public String getHttpCartItemNotFoundMessageWithId(long id) {
        return "Элемент корзины с ID " + id + " не найден";
    }

    public String getHttpProductNotFoundMessageWithId(long id) {
        return "Товар с ID " + id + " не найден";
    }

    public String getHttpOrderNotFoundMessageWithId(long id) { return "Заказ с ID " + id + " не найден"; }

    public String getHttpOrderItemNotFoundMessageWithId(long id) { return "Элемент заказа с ID " + id + " не найден"; }

    public String getHttpCategoryNotFoundMessageWithId(long id) {
        return "Категория с ID " + id + " не найдена";
    }
}
