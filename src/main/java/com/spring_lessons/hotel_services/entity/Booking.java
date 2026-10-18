package com.spring_lessons.hotel_services.entity;

import com.spring_lessons.hotel_services.constants.HotelRooms;
import com.spring_lessons.hotel_services.constants.HotelServices;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Бронирование
 */
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    // Стратегия генерации PK:
    // IDENTITY — БД сама назначает id (AUTO_INCREMENT / SERIAL).
    // Альтернативы: AUTO (по умолчанию), SEQUENCE, TABLE, UUID.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private HotelRooms roomType;

    // Один Booking → много Guest.
    // mappedBy = "booking"  — владелец связи Guest.booking, там будет FK.
    // cascade = ALL         — save/delete Booking каскадно применяется к Guest.
    // orphanRemoval = true  — убрали гостя из списка → DELETE из БД.
    // LAZY                  — гости подгружаются только при обращении.
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Guest> guestsList = new ArrayList<>();

    @Column(name = "arrival_at")
    private LocalDateTime arrival;

    @Column(name = "departure_at")
    private LocalDateTime departure;

    // Коллекция enum-ов хранится в ОТДЕЛЬНОЙ таблице (booking_meal_types).
    // @CollectionTable задаёт имя этой таблицы и FK-колонку на bookings.
    // @Enumerated(STRING) — значение enum сохраняется строкой.
    // LAZY — услуги подгружаются при обращении.
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "booking_meal_types",
            joinColumns = @JoinColumn(
                    name = "booking_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_meal_types_booking"))
    )
    // Enum в БД как строка ("SINGLE", "DOUBLE"), а не как число (0, 1).
    // STRING безопаснее: добавление нового значения в enum не сломает старые строки.
    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type", nullable = false)
    private Set<HotelServices> mealTypes = new HashSet<>();

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Long getId() {
        return bookingId;
    }

    public void setId(Long id) {
        this.bookingId = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public HotelRooms getRoomType() {
        return roomType;
    }

    public void setRoomType(HotelRooms roomType) {
        this.roomType = roomType;
    }

    public List<Guest> getGuestsList() {
        return guestsList;
    }

    public void setGuestsList(List<Guest> guestsList) {
        this.guestsList = guestsList;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public Set<HotelServices> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(Set<HotelServices> mealTypes) {
        this.mealTypes = mealTypes;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + bookingId + ", hotelName='" + hotelName + '\'' + ", roomType=" + roomType + ", guestsList=" + guestsList + ", arrival=" + arrival + ", departure=" + departure + ", mealTypes=" + mealTypes + '}';
    }
}
