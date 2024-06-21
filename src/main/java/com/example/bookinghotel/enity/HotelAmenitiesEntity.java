package com.example.bookinghotel.enity;

import com.example.bookinghotel.enity.key.HotelAmenitiesID;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "hotel_amenities")
@Data
public class HotelAmenitiesEntity {
    @EmbeddedId
    private HotelAmenitiesID id ;

    @ManyToOne
    @JoinColumn(name = "hotel_id" , insertable = false , updatable = false)
    private HotelEntity hotel ;

    @ManyToOne
    @JoinColumn(name = "amenities_id" , insertable = false , updatable = false)
    private AmenitiesEntity amenities ;




}
