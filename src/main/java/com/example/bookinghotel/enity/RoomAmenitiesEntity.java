package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "room_amenities")
@Data
public class RoomAmenitiesEntity {
    @Id
    @Column(name = "room_id")
    private int idRoom ;
    @Id
    @Column(name = "amenities_id")
    private int idAmenities ;

    @ManyToOne
    @JoinColumn(name = "amenities_id")
    private AmenitiesEntity amenities ;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity rooms ;



}
