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

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private USER_SEX sex ;

    @Column(name = "role_id")
    private int idRole;

    @Column(name = "is_deleted",columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "role_id" , insertable=false, updatable=false)
    private RoleEntity role;

    @OneToMany (mappedBy = "user")
    private List<BookingEntity> bookings ;

    @OneToMany(mappedBy = "user")
    private List<HotelReviewEntity> hotelReviews;

    @OneToMany(mappedBy = "user")
    private List<ReviewRepliesEntity> reviewreplies;

    @OneToMany(mappedBy = "user")
    private List<HotelEntity> hotels;
}
