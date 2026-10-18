package com.spring_lessons.hotel_services.repository;

import com.spring_lessons.hotel_services.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
