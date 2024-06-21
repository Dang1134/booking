package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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

    @Column(name = "booking_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingDate ;

    @Column(name = "total_price")
    private double totalPrice ;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", columnDefinition = "ENUM('TRANSFERRED','NOTTRANSFERRED') DEFAULT 'NOTTRANSFERRED'")
    private PAYMENT_STATUS paymentStatus;

    @Column(name = "payment_date" , columnDefinition = "TIMESTAMP")
    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private UserEntity user ;

    @ManyToOne
    @JoinColumn(name = "hotel_id" , insertable=false, updatable=false)
    private HotelEntity hotel ;

    @OneToMany(mappedBy = "booking")
    private List<BookingRoomEntity> bookingRooms ;


}
