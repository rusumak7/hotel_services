package com.spring_lessons.hotel_services.service;

import com.spring_lessons.hotel_services.constants.HotelServices;
import com.spring_lessons.hotel_services.dao.BookingDAO;
import com.spring_lessons.hotel_services.dto.BookingRequestDTO;
import com.spring_lessons.hotel_services.dto.BookingResponseDTO;
import com.spring_lessons.hotel_services.entity.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    /**
     * Метод редактирования бронирования по id
     */
    public BookingResponseDTO editBooking(Long bookingId, LocalDateTime arrival, LocalDateTime departure) {
        Booking editBooking = BookingDAO.getById(bookingId);

        if (editBooking == null) {
            return null;
        }
        editBooking.setArrival(arrival);
        editBooking.setDeparture(departure);

        return new BookingResponseDTO(
                editBooking.getId(),
                editBooking.getHotelName(),
                editBooking.getRoomType(),
                editBooking.getGuestsList(),
                editBooking.getArrival(),
                editBooking.getDeparture(),
                editBooking.getMealTypes()
        );
    }

    /**
     * Метод получения всех бронирований
     */
    public List<BookingResponseDTO> getAllBookings() {
        List<Booking> bookings = BookingDAO.getAllBookings();
        List<BookingResponseDTO> bookingsDTO = new ArrayList<>();

        for (Booking booking : bookings) {
            bookingsDTO.add(convertToDTO(booking));
        }

        return bookingsDTO;
    }

    /**
     * Метод получения всех услуг, включенных в бронирование
     *
     * @param id - идентификатор брони
     * @return список услуг
     */
    public List<HotelServices> getAllServicesInBooking(Long id) {
        Booking booking = BookingDAO.getById(id);

        if (booking == null)
            throw new NullPointerException();

        return getServicesFromBooking(booking);
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

    /**
     * Метод конвертации из Entity -> в DTO
     */
    private BookingResponseDTO convertToDTO(Booking booking) {
        return new BookingResponseDTO(
                booking.getId(),
                booking.getHotelName(),
                booking.getRoomType(),
                booking.getGuestsList(),
                booking.getArrival(),
                booking.getDeparture(),
                booking.getMealTypes()
        );
    }

    /**
     * Метод получения услуг бронирования
     */
    private List<HotelServices> getServicesFromBooking(Booking booking) {
        return new ArrayList<>(booking.getMealTypes());
    }
}
