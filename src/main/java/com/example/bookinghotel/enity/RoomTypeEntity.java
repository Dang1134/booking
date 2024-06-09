package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "room_type")
@Data

public class RoomTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "roomTypes")
    private List<RoomEntity> rooms ;

}
