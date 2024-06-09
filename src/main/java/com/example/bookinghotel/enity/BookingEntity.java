package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "booking")
@Data
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "user_id")
    private int idUser;
    @Column(name = "hotel_id")
    private int idHotel ;
    @Column(name = "booking_date")
    private String bookingDate ;
    @Column(name = "total_price")
    private double totalPrice ;
    @Column(name = "payment_amount")
    private String paymentAmount;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "payment_date")
    private String paymentDate;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private UserEntity users ;

    @ManyToOne
    @JoinColumn(name = "hotel_id" , insertable=false, updatable=false)
    private HotelEntity hotels ;

    @OneToMany(mappedBy = "bookings")
    private List<BookingRoomEntity> bookingRooms ;


}
