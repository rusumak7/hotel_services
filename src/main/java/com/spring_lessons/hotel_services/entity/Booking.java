package com.spring_lessons.hotel_services.entity;

import com.spring_lessons.hotel_services.constants.HotelRooms;
import com.spring_lessons.hotel_services.constants.HotelServices;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Бронирование
 */
public class Booking {
    private Long id;
    private String hotelName;
    private HotelRooms roomType;
    private List<Guest> guestsList;
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private List<HotelServices> mealTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public HotelRooms getRoomType() {
        return roomType;
    }

    public void setRoomType(HotelRooms roomType) {
        this.roomType = roomType;
    }

    public List<Guest> getGuestsList() {
        return guestsList;
    }

    public void setGuestsList(List<Guest> guestsList) {
        this.guestsList = guestsList;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public List<HotelServices> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(List<HotelServices> mealTypes) {
        this.mealTypes = mealTypes;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", roomType=" + roomType +
                ", guestsList=" + guestsList +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", mealTypes=" + mealTypes +
                '}';
    }
}
