package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;


@Entity(name = "hotels")
@Data
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "name")
    private String name;

    @Column(name = "description" , columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Column(name = "user_id")
    private int idUser;

    @Column(name = "phone")
    private int phone ;

    @Column(name = "open_time")
    private LocalTime openTime;

    @Column(name = "close_time")
    private LocalTime closeTime;

    @Column(name = "checkin_time")
    private LocalTime checkinTime;

    @Column(name = "checkout_time")
    private LocalTime checkoutTime;

    @Column(name = "rating" , columnDefinition = "DECIMAL(2,1)" )
    private BigDecimal rating ;

    @OneToMany (mappedBy = "hotel")
    private List<HotelAmenitiesEntity> hotelAmenities ;

    @OneToMany (mappedBy = "hotel")
    private List<BookingEntity> bookings ;

    @OneToMany(mappedBy = "hotel")
    private List<HotelImageEntity> hotelImages;

    @OneToMany(mappedBy = "hotel")
    private List<HotelReviewEntity> hotelReviews;

    @OneToMany(mappedBy = "hotel")
    private List<RoomEntity> rooms;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private UserEntity user;

    @OneToOne(mappedBy = "hotel")
    private HotelAdressEntity hotelAdress ;
}
