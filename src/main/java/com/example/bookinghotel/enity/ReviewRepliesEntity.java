package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "review_replies")
@Data

public class ReviewRepliesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "review_id")
    private int idReview ;
    @Column(name = "user_id")
    private int idUser;
    @Column(name = "reply_text")
    private String replyText;
    @Column(name = "reply_date")
    private String replyDate;

    @ManyToOne
    @JoinColumn(name = "review_id" , insertable=false, updatable=false)
    private HotelReviewEntity hotelReviews;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private UserEntity users;


}
