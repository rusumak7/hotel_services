package com.spring_lessons.hotel_services.service;

import com.spring_lessons.hotel_services.constants.HotelServices;
import com.spring_lessons.hotel_services.dto.BookingRequestDTO;
import com.spring_lessons.hotel_services.dto.BookingResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    public Long createBooking(BookingRequestDTO bookingRequest) {
        return 0L;
    }

    public Long editBooking(BookingRequestDTO bookingRequest) {
        return 0L;
    }

    public List<BookingResponseDTO> getAllBookings() {
        return null;
    }

    public List<HotelServices> getAllServices(int id) {
        return null;
    }

    public BookingResponseDTO cancelBooking(int id) {
        return null;
    }

}
