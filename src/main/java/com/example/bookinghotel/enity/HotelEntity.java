package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity(name = "hotels")
@Data
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "user_id")
    private int idUser;
    @Column(name = "phone")
    private int phone ;
    @Column(name = "open_time")
    private String openTime;
    @Column(name = "close_time")
    private String closeTime;
    @Column(name = "checkin_time")
    private String checkinTime;
    @Column(name = "checkout_time")
    private String checkoutTime;
    @Column(name = "rating")
    private int rating ;

    @OneToMany (mappedBy = "hotels")
    private List<HotelAmenitiesEntity> hotelAmenities ;

    @OneToMany (mappedBy = "hotels")
    private List<BookingEntity> bookings ;

    @OneToMany(mappedBy = "hotels")
    private List<HotelImageEntity> hotelImages;

    @OneToMany(mappedBy = "hotels")
    private List<HotelReviewEntity> hotelReviews;

    @OneToMany(mappedBy = "hotels")
    private List<RoomEntity> rooms;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private UserEntity users;

    @OneToOne(mappedBy = "hotels")
    private HotelAdressEntity hotelAdresss ;
}
