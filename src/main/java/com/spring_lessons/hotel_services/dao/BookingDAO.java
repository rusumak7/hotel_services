package com.spring_lessons.hotel_services.dao;

import com.spring_lessons.hotel_services.entity.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс-имитация DAO и БД. Содержит методы для сохранения, изменения, получения и удаления данных о бронировании в "БД"
 */
public class BookingDAO {
    // Логер БД
    private static final Logger log = LoggerFactory.getLogger(BookingDAO.class);
    // Счетчик текущего идентификатора в БД
    private static Long currentID = 0L;
    // Список-имитация БД
    private static Map<Long, Booking> bookingDB = new HashMap<>();

    /**
     * Метод сохраняет бронирование в "БД"
     *
     * @param booking - информация о бронировании
     * @return id записи в БД
     */
    public static Long save(Booking booking) {
        booking.setId(currentID);
        bookingDB.put(currentID, booking);
        log.info("Бронирование {}", booking + " добавлено в БД c id " + currentID);
        currentID++;
        return booking.getId();
    }

    /**
     * Метод удаляет (отменяет) бронирование в "БД"
     *
     * @param id - идентификатор брони
     * @return результат успешности операции удаления (true or false)
     */
    public static Boolean cancel(Long id) {
        Booking booking = bookingDB.remove(id);

        if (booking == null) {
            log.warn("Бронирование с id {} не найдено в БД", id);
            return false;
        }

        log.info("Бронирование с id {} отменено", id);
        return true;
    }
}
