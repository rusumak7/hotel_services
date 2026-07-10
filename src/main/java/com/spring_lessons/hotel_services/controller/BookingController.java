package com.spring_lessons.hotel_services.controller;

import com.spring_lessons.hotel_services.dto.BookingRequestDTO;
import com.spring_lessons.hotel_services.dto.BookingResponseDTO;
import com.spring_lessons.hotel_services.service.BookingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 * REST-контроллер обработки запросов со стороны клиента к серверу приложения на создание, редактирование и
 * получение абстрактных услуг.
 */
@Validated
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    // Логер контроллера
    private static final Logger log = LoggerFactory.getLogger(BookingController.class);
    // Сервис обработки данных бронирования
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Метод обработки POST-запросов на создание бронирования номеров
     *
     * @param bookingRequestDTO
     * @param servletRequest
     * @return id брони
     */
    @PostMapping
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO, HttpServletRequest servletRequest) {
        log.info("POST запрос. Бронирование: {}", bookingRequestDTO);
        URI uri = URI.create("/api/v1/booking/" + bookingService.createBooking(bookingRequestDTO));
        return ResponseEntity.created(uri).build();
    }

    /**
     * Метод обработки DELETE запросов на отмену бронирования
     *
     * @param id брони
     * @return в теле ответа информацию об успешности операции
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        log.info("DELETE запрос. Удаление бронирования c id {}", id);

        Boolean isCanceled = bookingService.cancelBooking(id);
        if (isCanceled) {
            return ResponseEntity.ok().body(Map.of("success", true,
                    "message", "Бронирование с id " + id + " успешно отменено"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("success", false,
                    "message", "Бронирование с id " + id + " не найдено в системе"));
        }
    }

    /**
     * Метод обработки PUT запросов на изменение бронирования
     *
     * @param id        - идентификатор брони
     * @param arrival   - время заезда
     * @param departure - время выезда
     * @return в теле ответа информацию об успешности операции
     */
    @PutMapping("/edit")
    public ResponseEntity<?> editBooking(@Valid @RequestParam("id") Long id,
                                         @Valid @RequestParam("arrival") LocalDateTime arrival,
                                         @Valid @RequestParam("departure") LocalDateTime departure) {

        log.info("PUT запрос. Редактирование бронирования c id {}", id);
        BookingResponseDTO editResponseDTO = bookingService.editBooking(id, arrival, departure);

        if (editResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("success", false,
                            "message", "Бронирование с id " + id + " не найдено в системе"));
        }

        return ResponseEntity.ok().body(editResponseDTO);
    }

    /**
     * Метод обработки GET запросов на получение всех записей бронирования
     *
     * @return список бронирований
     */
    @GetMapping("/all")
    public ResponseEntity<?> getBookingsList() {
        log.info("GET запрос. Получение всех записей бронирования");

        List<BookingResponseDTO> bookings = bookingService.getAllBookings();

        if (bookings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("success", false,
                            "message", "Бронирования не найдены в системе"));
        }

        return ResponseEntity.ok().body(bookings);
    }

    /**
     * Метод обработки GET запросов на получения списка услуг, включенных в бронирование
     *
     * @param id - идентификатор брони
     * @return список услуг
     */
    @GetMapping("/services/{id}")
    public ResponseEntity<?> getServicesList(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(bookingService.getAllServicesInBooking(id));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("success", false,
                            "message", "Бронирование c id " + id + " не найдено в системе"));
        }
    }
}
