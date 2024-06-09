package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "users")
@Data

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password ;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "address")
    private String address ;
    @Column(name = "phone")
    private int phone ;
    @Column(name = "sex")
    private String sex ;
    @Column(name = "role_id")
    private int idRole;

    @ManyToOne
    @JoinColumn(name = "role_id" , insertable=false, updatable=false)
    private RoleEntity roles;

    @OneToMany (mappedBy = "users")
    private List<BookingEntity> bookings ;

    @OneToMany(mappedBy = "users")
    private List<HotelReviewEntity> hotelReviews;

    @OneToMany(mappedBy = "users")
    private List<ReviewRepliesEntity> reviewreplies;

    @OneToMany(mappedBy = "users")
    private List<HotelEntity> hotels;
}
