package com.spring_lessons.hotel_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ServiceRequestDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    private String serviceName;
}
