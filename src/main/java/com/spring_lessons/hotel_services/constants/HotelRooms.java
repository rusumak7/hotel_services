package com.spring_lessons.hotel_services.constants;

/**
 * Класс-перечисление вместимости номеров
 */
public enum HotelRooms {
    SINGLE("Одноместный"),
    DOUBLE("Двухместный");

    private final String roomType;

    HotelRooms(String roomType) {
        this.roomType = roomType;
    }

    public String getTitle() {
        return roomType;
    }

}
