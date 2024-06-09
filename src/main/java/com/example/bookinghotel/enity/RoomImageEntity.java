package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "room_image")
@Data

public class RoomImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "room_id")
    private int idRoom ;
    @Column(name = "image_title")
    private String imageTitle ;
    @Column(name = "image_description")
    private String imageDescription;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "upload_date")
    private String uploadDate ;

    @ManyToOne
    @JoinColumn(name = "room_id", insertable=false, updatable=false)
    private RoomEntity rooms ;
}
