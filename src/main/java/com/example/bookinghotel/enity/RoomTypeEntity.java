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

    @OneToMany(mappedBy = "roomType" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<RoomEntity> rooms ;

}
