package com.example.bookinghotel.service;

import com.example.bookinghotel.dto.AmenitiesDTO;
import com.example.bookinghotel.dto.RoomDTO;
import com.example.bookinghotel.enity.AmenitiesEntity;
import com.example.bookinghotel.enity.RoomAmenitiesEntity;
import com.example.bookinghotel.enity.RoomEntity;
import com.example.bookinghotel.repository.AmenitiesRepository;
import com.example.bookinghotel.repository.RoomRepository;
import com.example.bookinghotel.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements RoomServiceImp {
    @Autowired
    private RoomRepository roomRepository ;
    @Autowired
    private AmenitiesRepository amenitiesRepository ;

    @Override
    public List<RoomDTO> getAllRoom() {
        List<RoomEntity> rooms = roomRepository.findAll();
        List<RoomDTO> roomDTOS = new ArrayList<>();
        rooms.forEach(item ->{
            RoomDTO roomDTO = new RoomDTO();

            roomDTO.setNameHotel((item.getHotel().getName()));
            roomDTO.setRoomType(item.getRoomType().getName());
            roomDTO.setRoomNumber(item.getRoomNumber());
            roomDTO.setPrice(item.getPrice());

            List<AmenitiesDTO> amenitiesDTOList = new ArrayList<>();
            for (RoomAmenitiesEntity roomAmenity : item.getRoomAmenities()) {
                AmenitiesDTO amenitiesDTO = new AmenitiesDTO();
                amenitiesDTO.setId(roomAmenity.getAmenities().getId());
                amenitiesDTO.setName(roomAmenity.getAmenities().getName());
                amenitiesDTO.setIcon(roomAmenity.getAmenities().getIcon());
                amenitiesDTOList.add(amenitiesDTO);
            }
            roomDTO.setAmenities(amenitiesDTOList);

            List<String> images = new ArrayList<>();
            item.getRoomImages().forEach(itemImage ->{
                images.add(itemImage.getImagePath());
            });
            roomDTO.setImage(images);

            roomDTO.setStatus(String.valueOf(item.getStatus()));

            roomDTOS.add(roomDTO);

        });
        return roomDTOS ;
    }
}
