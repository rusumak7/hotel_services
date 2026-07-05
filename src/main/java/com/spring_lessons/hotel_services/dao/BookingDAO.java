package com.spring_lessons.hotel_services.dao;

import com.spring_lessons.hotel_services.controller.BookingController;
import com.spring_lessons.hotel_services.entity.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-имитация DAO и БД. Содержит методы для сохранения, изменения, получения и удаления данных о бронировании в "БД"
 */
public class BookingDAO {
    // Логер БД
    private static final Logger log = LoggerFactory.getLogger(BookingController.class);
    // Счетчик текущего идентификатора в БД
    private static Long currentID = 0L;
    // Список-имитация БД
    private static List<Booking> bookingDB = new ArrayList<>();

    /**
     * Метод сохраняет бронирование в "БД"
     * @param booking - информация о бронировании
     * @return id записи в БД
     */
    public static Long save(Booking booking) {
        booking.setId(currentID++);
        bookingDB.add(booking);
        log.info("Бронирование: {}", booking.toString() + " добавлено в БД");
        return booking.getId();
    }
}
