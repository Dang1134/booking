package com.example.bookinghotel.service;

import com.example.bookinghotel.enity.RoomTypeEntity;
import com.example.bookinghotel.repository.RoomTypeRepository;
import com.example.bookinghotel.service.imp.RoomTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payload.request.InsertRoomTypeRequest;
import payload.request.UpdateRoomTypeRequest;

import java.util.List;
import java.util.Optional;

@Service

public class RoomTypeService implements RoomTypeServiceImp {
    @Autowired
    private RoomTypeRepository roomTypeRepository ;

    @Override
    public void insertRoomType(InsertRoomTypeRequest request) {
        RoomTypeEntity roomTypeEntity = new RoomTypeEntity();
        roomTypeEntity.setName(request.getName());
        roomTypeRepository.save(roomTypeEntity);
    }


    @Override
    public void deleteRoomType(int id) {
        roomTypeRepository.deleteById(id);
    }
}
