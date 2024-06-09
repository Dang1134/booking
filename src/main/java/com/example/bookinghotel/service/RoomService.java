package com.example.bookinghotel.service;

import com.example.bookinghotel.dto.RoomDTO;
import com.example.bookinghotel.enity.RoomEntity;
import com.example.bookinghotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository ;

    public List<RoomDTO> getALlRoom (){
        List<RoomEntity> rooms = roomRepository.findAll();
        List<RoomDTO> roomDTOS = new ArrayList<>();
        rooms.forEach(item ->{
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setNameHotel(String.valueOf(item.getIdHotel()));
            roomDTO.setRoomType(String.valueOf(item.getIdRoomtype()));
            roomDTO.setRoomNumber(item.getRoomNumber());
            roomDTO.setPrice(item.getPrice());
            roomDTOS.add(roomDTO);

        });
        return roomDTOS ;

    }


}
