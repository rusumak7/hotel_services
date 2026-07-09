package com.spring_lessons.hotel_services.entity;

import jakarta.validation.constraints.NotNull;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

/**
 * Гость (постоялец) отеля
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Guest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Guest{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age='" + age + '\'' + '}';
    }
}
