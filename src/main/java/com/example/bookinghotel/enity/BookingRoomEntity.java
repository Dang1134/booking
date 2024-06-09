package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "booking_room")
@Data

public class BookingRoomEntity {
    @Id
    @Column(name = "booking_id")
    private int idBooking ;
    @Id
    @Column(name = "room_id")
    private int idRoom ;
    @Column(name = "status")
    private String status ;
    @Column(name = "checkin_date")
    private String checkinDate;
    @Column(name = "checkout_date")
    private String checkoutDate ;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity bookings;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity rooms;
}
