package com.example.bookinghotel.enity;

import com.example.bookinghotel.enity.key.RoomAmenitiesID;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "room_amenities")
@Data
public class RoomAmenitiesEntity {
    @EmbeddedId
    private RoomAmenitiesID id;

    @ManyToOne
    @JoinColumn(name = "amenities_id" , insertable = false , updatable = false)
    private AmenitiesEntity amenities ;

    @ManyToOne
    @JoinColumn(name = "room_id" , insertable = false , updatable = false)
    private RoomEntity room ;



}
