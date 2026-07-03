package com.spring_lessons.hotel_services.controller;

import com.spring_lessons.hotel_services.dto.ServiceRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-контроллер обработки запросов со стороны клиента к серверу приложения на создание, редактирование и
 * получение абстрактных услуг.
 */
@Validated
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    // TODO: Заготовка метода обработки POST-запросов на создание или частичное изменение услуги
    @PostMapping
    public Long createService(@Valid @RequestBody ServiceRequestDTO serviceRequest) {
        return null;
    }
    // TODO: Заготовка метода обработки PUT-запросов на полное обновление (перезапись) услуги
    @PutMapping
    public Object updateService(@Valid @RequestParam("service_name") String serviceName) {
        return null;
    }
    // TODO: Заготовка метода обработки GET-запросов на получение списка услуг
    @GetMapping
    public List<Object> getServicesList() {

        return null;
    }
    // TODO: Заготовка метода обработки GET-запросов на получение услуги по id
    @GetMapping("/{id}")
    public Object getServiceById(@Positive @PathVariable Long id) {

        return null;
    }
}
