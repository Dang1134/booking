package com.example.bookinghotel.dto;

import lombok.Data;

import java.util.List;

@Data

public class RoomDTO {

    private String nameHotel;
    private int roomNumber ;
    private String roomType;
    private double price ;
    private List<AmenitiesDTO> amenities ;
    private List<String> image ;
    private String status ;






}
