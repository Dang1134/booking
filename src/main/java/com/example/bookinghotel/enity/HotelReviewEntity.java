package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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
    private LocalDateTime reviewDate;

    @ManyToOne
    @JoinColumn (name = "hotel_id" ,insertable=false, updatable=false)
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private UserEntity user;

    @OneToMany(mappedBy = "hotelReview")
    private List<ReviewRepliesEntity> reviewreplies;


}
