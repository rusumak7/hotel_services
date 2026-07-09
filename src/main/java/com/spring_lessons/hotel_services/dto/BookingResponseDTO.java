package com.spring_lessons.hotel_services.dto;

import com.spring_lessons.hotel_services.constants.HotelRooms;
import com.spring_lessons.hotel_services.constants.HotelServices;
import com.spring_lessons.hotel_services.entity.Guest;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

public record BookingResponseDTO(
        @NotNull
        Long id,
        @NotBlank
        String hotelName,
        @NotNull
        HotelRooms roomType,
        @NotEmpty
        @NotNull
        List<Guest> guestsList,
        @FutureOrPresent
        @NotNull
        LocalDateTime arrival,
        @Future
        @NotNull
        LocalDateTime departure,
        @NotEmpty
        @NotNull
        List<HotelServices> mealTypes
) {
}
