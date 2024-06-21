package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity (name = "amenities")
@Data

public class AmenitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "name")
    private String name ;

    @Column(name ="icon" )
    private String icon ;

    @OneToMany(mappedBy = "amenities")
    private List<HotelAmenitiesEntity> hotelAmenities ;

    @OneToMany(mappedBy = "amenities")
    private List<RoomAmenitiesEntity> roomAmenities;


}
