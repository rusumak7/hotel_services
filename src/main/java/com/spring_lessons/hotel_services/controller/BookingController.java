package com.spring_lessons.hotel_services.controller;

import com.spring_lessons.hotel_services.dto.BookingRequestDTO;
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

    /* Метод обработки POST-запросов на создание бронирования номеров
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
     * @return в теле информацию об успешности операции
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        log.info("DELETE запрос. Удаление бронирования c id {}", id);

        Boolean isCanceled = bookingService.cancelBooking(id);
        if (isCanceled) {
            return ResponseEntity.ok().body(Map.of("success", true, "message", "Бронирование с id " + id + " успешно отменено"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("success", false, "message", "Бронирование с id " + id + " не найдено в системе"));
        }


//
//    @PutMapping
//    public Object editBooking(@Valid @RequestParam("service_name") String serviceName) {
//        return null;
//    }

        // TODO: Заготовка метода обработки GET-запросов на получение списка услуг
//    @GetMapping
//    public List<Guest> getServicesList() {
//
//        return null;
//    }

//    // TODO: Заготовка метода обработки GET-запросов на получение услуги по id
//    @GetMapping("/{id}")
//    public Object getServiceById(@Positive @PathVariable Long id) {
//
//        return null;
//    }
    }
}
