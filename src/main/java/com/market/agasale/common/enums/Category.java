package com.market.agasale.common.enums;

public enum Category {
    ELECTRONICS,       // Электроника
    FURNITURE,         // Мебель
    CLOTHING,          // Одежда
    TOYS,              // Игрушки
    BOOKS,             // Книги
    FOOD,              // Еда и напитки
    BEAUTY,            // Красота и здоровье
    SPORTS,            // Спорт и отдых
    AUTOMOTIVE,        // Автомобили и мотоциклы
    HOME_APPLIANCES,   // Бытовая техника
    GARDEN,            // Сад и огород
    HEALTH,            // Здоровье
    ART,               // Искусство
    MUSIC,             // Музыка и музыкальные инструменты
    PETS,              // Животные и товары для животных
    STATIONERY,        // Канцелярия
    JEWELRY,           // Ювелирные изделия
    GAMES,             // Видеоигры
    SOFTWARE,          // Программное обеспечение
    GIFTS,             // Подарки
    BABY_PRODUCTS,     // Товары для детей
    TRAVEL,            // Путешествия и туризм
    OFFICE_SUPPLIES,   // Офисные принадлежности
    WATCHES,           // Часы
    SHOES,             // Обувь
    BAGS,              // Сумки и рюкзаки
    PHOTOGRAPHY,       // Фототехника
    HANDMADE,          // Ручная работа
    GOURMET,           // Гурман
    FITNESS,           // Фитнес
    OUTDOOR,           // Туризм и активный отдых
    SMART_HOME,        // Умный дом
    HOBBY,             // Хобби и творчество
    ANTIQUES,          // Антиквариат
    LUXURY_GOODS,      // Люксовые товары
    DECOR,             // Декор и интерьер
    KITCHENWARE,       // Кухонные принадлежности
    LIGHTING,          // Освещение
    SECURITY,          // Безопасность и видеонаблюдение
    MOBILE_ACCESSORIES,// Аксессуары для мобильных устройств
    DIY,               // Сделай сам
    BOOKS_AND_MAGAZINES, // Книги и журналы
    EDUCATION,         // Образование
    ART_SUPPLIES,      // Товары для художников
    VINTAGE,           // Винтаж
    ECO_PRODUCTS,      // Эко-продукты

    // Псевдонимы категорий для поиска
    ACCESSORIES,       // Аксессуары
    TECHNOLOGY,        // Технологии
    HOME_AND_LIVING,   // Дом и жизнь
    FASHION,           // Мода
    LIFESTYLE;         // Стиль жизни

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
            case AUTOMOTIVE -> "Автомобили и мотоциклы";
            case HOME_APPLIANCES -> "Бытовая техника";
            case GARDEN -> "Сад и огород";
            case HEALTH -> "Здоровье";
            case ART -> "Искусство";
            case MUSIC -> "Музыка и музыкальные инструменты";
            case PETS -> "Животные и товары для животных";
            case STATIONERY -> "Канцелярия";
            case JEWELRY -> "Ювелирные изделия";
            case GAMES -> "Видеоигры";
            case SOFTWARE -> "Программное обеспечение";
            case GIFTS -> "Подарки";
            case BABY_PRODUCTS -> "Товары для детей";
            case TRAVEL -> "Путешествия и туризм";
            case OFFICE_SUPPLIES -> "Офисные принадлежности";
            case WATCHES -> "Часы";
            case SHOES -> "Обувь";
            case BAGS -> "Сумки и рюкзаки";
            case PHOTOGRAPHY -> "Фототехника";
            case HANDMADE -> "Ручная работа";
            case GOURMET -> "Гурман";
            case FITNESS -> "Фитнес";
            case OUTDOOR -> "Туризм и активный отдых";
            case SMART_HOME -> "Умный дом";
            case HOBBY -> "Хобби и творчество";
            case ANTIQUES -> "Антиквариат";
            case LUXURY_GOODS -> "Люксовые товары";
            case DECOR -> "Декор и интерьер";
            case KITCHENWARE -> "Кухонные принадлежности";
            case LIGHTING -> "Освещение";
            case SECURITY -> "Безопасность и видеонаблюдение";
            case MOBILE_ACCESSORIES -> "Аксессуары для мобильных устройств";
            case DIY -> "Сделай сам";
            case BOOKS_AND_MAGAZINES -> "Книги и журналы";
            case EDUCATION -> "Образование";
            case ART_SUPPLIES -> "Товары для художников";
            case VINTAGE -> "Винтаж";
            case ECO_PRODUCTS -> "Эко-продукты";
            case ACCESSORIES -> "Аксессуары";
            case TECHNOLOGY -> "Технологии";
            case HOME_AND_LIVING -> "Дом и жизнь";
            case FASHION -> "Мода";
            case LIFESTYLE -> "Стиль жизни";
            default -> "Неизвестная категория: " + this;
        };
    }
}