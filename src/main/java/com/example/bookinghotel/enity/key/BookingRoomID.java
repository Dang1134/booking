package com.example.bookinghotel.enity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class BookingRoomID implements Serializable {

    @Column(name = "booking_id")
    private int idBooking;

    @Column(name = "room_id")
    private int idRoom;
}
