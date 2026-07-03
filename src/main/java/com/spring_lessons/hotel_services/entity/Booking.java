package com.spring_lessons.hotel_services.entity;

import com.spring_lessons.hotel_services.constants.HotelRooms;
import com.spring_lessons.hotel_services.constants.HotelServices;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private String hotelName;
    private HotelRooms roomType;
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private List<HotelServices> mealTypes;
}
