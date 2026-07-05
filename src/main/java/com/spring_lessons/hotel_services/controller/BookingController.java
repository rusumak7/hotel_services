package com.spring_lessons.hotel_services.controller;

import com.spring_lessons.hotel_services.dto.BookingRequestDTO;
import com.spring_lessons.hotel_services.service.BookingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    /* Метод обработки POST-запросов на создание бронирования номеров
     * @param bookingRequestDTO
     * @param servletRequest
     * @return id брони
     */
    @PostMapping
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO,
                                           HttpServletRequest servletRequest) {
        log.info("POST запрос. Бронирование: {}", bookingRequestDTO);
        URI uri = URI.create("/api/v1/animals/" +
                bookingService.createBooking(bookingRequestDTO));
        return ResponseEntity.created(uri).build();
    }

    // TODO: Заготовка метода обработки PUT-запросов на полное обновление (перезапись) услуги
    @PutMapping
    public Object editBooking(@Valid @RequestParam("service_name") String serviceName) {
        return null;
    }

    // TODO: Заготовка метода обработки GET-запросов на получение списка услуг
//    @GetMapping
//    public List<Guest> getServicesList() {
//
//        return null;
//    }

    // TODO: Заготовка метода обработки GET-запросов на получение услуги по id
    @GetMapping("/{id}")
    public Object getServiceById(@Positive @PathVariable Long id) {

        return null;
    }
}
