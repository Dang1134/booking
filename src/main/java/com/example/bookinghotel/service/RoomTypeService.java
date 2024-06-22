package com.example.bookinghotel.service;

import com.example.bookinghotel.dto.RoomTypeDTO;
import com.example.bookinghotel.enity.RoomTypeEntity;
import com.example.bookinghotel.exception.InsertRoomTypeException;
import com.example.bookinghotel.repository.RoomTypeRepository;
import com.example.bookinghotel.service.imp.RoomTypeServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookinghotel.payload.request.InsertRoomTypeRequest;

import java.util.ArrayList;
import java.util.List;

@Service

public class RoomTypeService implements RoomTypeServiceImp {
    @Autowired
    private RoomTypeRepository roomTypeRepository ;

    @Override
    public RoomTypeEntity insertRoomType(HttpServletRequest request, InsertRoomTypeRequest typeRequest) {
        if (typeRequest.getName() == null || typeRequest.getName().isEmpty()){
            throw new InsertRoomTypeException("Tên loại phòng không được để trống");
        }
        RoomTypeEntity roomTypeEntity = new RoomTypeEntity();
        roomTypeEntity.setName(typeRequest.getName());
        return roomTypeRepository.save(roomTypeEntity);

    }

    @Override
    public List<RoomTypeDTO> getAllRoomType(HttpServletRequest request) {
        List<RoomTypeEntity> listRoomTypeEntity = roomTypeRepository.findAll();
        List<RoomTypeDTO> listDTO = new ArrayList<>();
        listRoomTypeEntity.forEach(item ->{
           RoomTypeDTO roomTypeDTO = new RoomTypeDTO();
           roomTypeDTO.setId(item.getId());
           roomTypeDTO.setName(item.getName());

           listDTO.add(roomTypeDTO);
        });
        return listDTO;
    }


    @Override
    public void deleteRoomType(HttpServletRequest request, int id) {

        roomTypeRepository.deleteById(id);
    }
}
