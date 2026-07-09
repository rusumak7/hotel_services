package com.spring_lessons.hotel_services.constants;

/**
 * Класс-перечисление приемов пищи, предоставляемых отелем за отдельную плату.
 */
public enum HotelServices {
    NO("Нет"),
    BREAKFAST("Завтрак"),
    LUNCH("Обед"),
    DINNER("Ужин");

    private final String mealType;

    HotelServices(String mealType) {
        this.mealType = mealType;
    }

    public String getMealType() {
        return mealType;
    }

}
