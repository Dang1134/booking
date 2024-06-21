package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "hotel_image")
@Data
public class HotelImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "hotel_id")
    private int idHotel;

    @Column(name = "image_title")
    private String imageTitle ;

    @Column(name = "image_description")
    private String imageDescription;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "upload_date" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime uploadDate;

    @ManyToOne
    @JoinColumn(name = "hotel_id" , insertable=false, updatable=false)
    private HotelEntity hotel ;

}
