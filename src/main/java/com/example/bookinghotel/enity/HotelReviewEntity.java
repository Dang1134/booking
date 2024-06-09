package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "hotel_reiviews")
@Data

public class HotelReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "hotel_id")
    private int idHotel ;
    @Column(name = "user_id")
    private int idUser;
    @Column(name = "comment")
    private String comment;
    @Column(name = "review_date")
    private String reviewDate;

    @ManyToOne
    @JoinColumn (name = "hotel_id" ,insertable=false, updatable=false)
    private HotelEntity hotels;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private UserEntity users;

    @OneToMany(mappedBy = "hotelReviews")
    private List<ReviewRepliesEntity> reviewreplies;


}
