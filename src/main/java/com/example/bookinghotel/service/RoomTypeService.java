package com.example.bookinghotel.service;

import com.example.bookinghotel.dto.RoomTypeDTO;
import com.example.bookinghotel.enity.RoomEntity;
import com.example.bookinghotel.enity.RoomTypeEntity;
import com.example.bookinghotel.exception.DeleteException;
import com.example.bookinghotel.exception.InsertRoomTypeException;
import com.example.bookinghotel.exception.UpdateRoomTypeException;
import com.example.bookinghotel.payload.request.UpdateRoomTypeRequest;
import com.example.bookinghotel.repository.RoomAmenitiesRepository;
import com.example.bookinghotel.repository.RoomRepository;
import com.example.bookinghotel.repository.RoomTypeRepository;
import com.example.bookinghotel.service.imp.RoomTypeServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookinghotel.payload.request.InsertRoomTypeRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class RoomTypeService implements RoomTypeServiceImp {
    @Autowired
    private RoomTypeRepository roomTypeRepository ;
    @Autowired
    private RoomRepository roomRepository ;

    @Autowired
    private RoomAmenitiesRepository roomAmenitiesRepository ;

    @Transactional
    @Override
    public RoomTypeEntity insertRoomType(HttpServletRequest request, InsertRoomTypeRequest typeRequest) {
        if (typeRequest.getName() == null || typeRequest.getName().isEmpty()){
            throw new InsertRoomTypeException("Tên loại phòng không được để trống");
        }
        RoomTypeEntity roomTypeEntity = new RoomTypeEntity();
        roomTypeEntity.setName(typeRequest.getName());
        return roomTypeRepository.save(roomTypeEntity);

    }
    @Transactional
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
    @Transactional
    @Override
    public void deleteRoomType(HttpServletRequest request, int id) {
        if (!roomTypeRepository.existsById(id)){
            throw new DeleteException("Không tìm thấy loại phòng" +id);
        }
        List<RoomEntity> rooms = roomRepository.findByRoomTypeId(id);
        for (RoomEntity room : rooms){
            roomAmenitiesRepository.deleteByRoomId(room.getId());
            roomRepository.delete(room);
        }
        roomTypeRepository.deleteById(id);
    }

    @Override
    public RoomTypeEntity updateRoomType(HttpServletRequest request, UpdateRoomTypeRequest updateRoomTypeRequest, int id) {
        RoomTypeEntity roomTypeEntity = roomTypeRepository.findById(id).orElseThrow(()-> new UpdateRoomTypeException("Không tìm thấy loại phòng" +id));
        roomTypeEntity.setName(updateRoomTypeRequest.getName());
        return roomTypeRepository.save(roomTypeEntity);
    }
}
