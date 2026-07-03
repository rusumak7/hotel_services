package com.spring_lessons.hotel_services.constants;

public enum HotelRooms {
    SINGLE("Одноместный"),
    DOUBLE("Двуместный");

    private final String roomType;

    HotelRooms(String roomType) {
        this.roomType = roomType;
    }

    public String getTitle() {
        return roomType;
    }

}
