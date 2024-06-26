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


public class HotelAmenitiesID implements Serializable {
    @Column(name = "hotel_id")
    private int hotelId;
    @Column(name = "amenities_id")
    private int amenitiesId;
}
