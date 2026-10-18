package com.spring_lessons.hotel_services.repository;

import com.spring_lessons.hotel_services.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
