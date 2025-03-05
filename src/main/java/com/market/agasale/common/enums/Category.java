package com.market.agasale.common.enums;

public enum Category {
    ELECTRONICS,   // Электроника
    FURNITURE,     // Мебель
    CLOTHING,      // Одежда
    TOYS,          // Игрушки
    BOOKS,         // Книги
    FOOD,          // Еда и напитки
    BEAUTY,        // Красота и здоровье
    SPORTS;        // Спорт и отдых

    // Метод для получения отображаемого имени категории
    public String getDisplayName() {
        return switch (this) {
            case ELECTRONICS -> "Электроника";
            case FURNITURE -> "Мебель";
            case CLOTHING -> "Одежда";
            case TOYS -> "Игрушки";
            case BOOKS -> "Книги";
            case FOOD -> "Еда и напитки";
            case BEAUTY -> "Красота и здоровье";
            case SPORTS -> "Спорт и отдых";
            default -> "Неизвестная категория: " + this;
        };
    }
}