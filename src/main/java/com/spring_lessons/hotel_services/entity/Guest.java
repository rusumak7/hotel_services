package com.spring_lessons.hotel_services.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

/**
 * Гость (постоялец) отеля
 */
@Entity
@Table(name = "guests")
public class Guest {
    @Id
    // Стратегия генерации PK:
    // IDENTITY — БД сама назначает id (AUTO_INCREMENT / SERIAL).
    // Альтернативы: AUTO (по умолчанию), SEQUENCE, TABLE, UUID.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private Long guestId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

    // Много Guest → один Booking.
    // LAZY           — Booking подгружается при обращении к guest.getBooking().
    // optional=false — гость обязательно должен быть привязан к бронированию (NOT NULL).
    // @JoinColumn    — колонка booking_id в таблице guests = FK на bookings.booking_id.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false, foreignKey = @ForeignKey(name = "fk_guests_booking"))
    private Booking booking;

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
