package com.spring_lessons.hotel_services.entity;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

/**
 * Гость (постоялец) отеля
 */
public class Guest {
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
