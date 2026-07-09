package com.spring_lessons.hotel_services.service;

import com.spring_lessons.hotel_services.constants.HotelServices;
import com.spring_lessons.hotel_services.dao.BookingDAO;
import com.spring_lessons.hotel_services.dto.BookingRequestDTO;
import com.spring_lessons.hotel_services.dto.BookingResponseDTO;
import com.spring_lessons.hotel_services.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис обработки данных бронирования.
 * Реализует методы работы с данными в зависимости от запросов.
 */
@Service
public class BookingService {
    /**
     * Метод создания бронирования из DTO -> в Entity
     */
    public Long createBooking(BookingRequestDTO bookingRequest) {
        Booking booking = new Booking();
        // Заполняем поля сущности
        booking.setHotelName(bookingRequest.hotelName());
        booking.setRoomType(bookingRequest.roomType());
        booking.setGuestsList(bookingRequest.guestsList());
        booking.setArrival(bookingRequest.arrival());
        booking.setDeparture(bookingRequest.departure());
        booking.setMealTypes(bookingRequest.mealTypes());
        // Возвращаем id сущности из БД
        return BookingDAO.save(booking);
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

    /**
     * Метод удаления (отмены) бронирования
     *
     * @param id - идентификатор брони
     * @return результат успешности операции (true or false)
     */
    public Boolean cancelBooking(Long id) {

        return BookingDAO.cancel(id);
    }
}
