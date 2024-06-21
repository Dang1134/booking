package com.example.bookinghotel.enity;

import com.example.bookinghotel.enity.key.BookingRoomID;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "booking_room")
@Data

public class BookingRoomEntity {
    @EmbeddedId
    private BookingRoomID id ;

    @Enumerated(EnumType.STRING)
    @Column(name = "status" , columnDefinition = "ENUM('PENDING','CONFIRMED','CHECKIN','CHECKOUT','CANCELLED') DEFAULT 'PENDING'")
    private BOOKING_ROOM_STATUS status ;

    @Column(name = "checkin_date" , columnDefinition = "TIMESTAMP")
    private LocalDateTime checkinDate;

    @Column(name = "checkout_date" , columnDefinition = "TIMESTAMP")
    private LocalDateTime checkoutDate ;

    @ManyToOne
    @JoinColumn(name = "booking_id" , insertable = false , updatable = false)
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "room_id" , insertable = false , updatable = false)
    private RoomEntity room;
}
