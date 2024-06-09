package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "hotel_amenities")
@Data
public class HotelAmenitiesEntity {
    @Id
    @Column(name = "hotel_id")
    private int idHotel ;
    @Id
    @Column(name = "amenities_id")
    private int idAmenities;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotels ;

    @ManyToOne
    @JoinColumn(name = "amenities_id")
    private AmenitiesEntity amenities ;




}
