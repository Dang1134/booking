package com.example.bookinghotel.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "rooms")
@Data
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "roomtype_id")
    private int idRoomtype;

    @Column(name = "price")
    private double price ;

    @Column(name = "hotel_id")
    private int idHotel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status" , columnDefinition = "ENUM('AVAILABLE','BOOKED','OCCUPIED','MAINTENANCE','CLEANING') DEFAULT 'AVAILABLE'")
    private ROOM_STATUS status;

    @OneToMany(mappedBy = "room")
    private List<RoomAmenitiesEntity> roomAmenities;

    @OneToMany(mappedBy = "room")
    private List<RoomImageEntity> roomImages;

    @OneToMany(mappedBy = "room")
    private List<BookingRoomEntity> bookingRooms;

    @ManyToOne
    @JoinColumn(name = "roomtype_id" , insertable=false, updatable=false)
    private RoomTypeEntity roomType ;

    @ManyToOne
    @JoinColumn (name = "hotel_id" , insertable=false, updatable=false)
    private HotelEntity hotel;

}
