package com.spring_lessons.hotel_services.dto;

import com.spring_lessons.hotel_services.constants.HotelRooms;
import com.spring_lessons.hotel_services.constants.HotelServices;
import com.spring_lessons.hotel_services.entity.Guest;
import jakarta.validation.constraints.*;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO запроса на бронирование от клиента
 * @param hotelName
 * @param roomType
 * @param guestsList
 * @param arrival
 * @param departure
 * @param mealTypes
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record BookingRequestDTO (
    @NotBlank
    @NotEmpty
    @NotNull
    String hotelName,
    @NotNull
    HotelRooms roomType,
    @NotEmpty
    @NotNull
    List<Guest>guestsList,
    @FutureOrPresent
    @NotNull
    LocalDateTime arrival,
    @Future
    @NotNull
    LocalDateTime departure,
    @NotEmpty
    @NotNull
    List<HotelServices> mealTypes
) {}
