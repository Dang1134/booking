package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "hotel_address")
@Data
public class HotelAddressEntity {
//    @EmbeddedId
//    private HotelAddressID id ;

    @Id
    @Column(name = "hotel_id")
    private int hotelID;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province ;

    @Column(name = "country")
    private String country;

    @OneToOne
    @MapsId
    @JoinColumn(name = "hotel_id" , insertable=false, updatable=false)
    private HotelEntity hotel;


}
