package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "hotel_address")
@Data
public class HotelAdressEntity {
    @Id
    @Column(name = "hotel_id")
    private int idHotel;
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
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotels;


}
