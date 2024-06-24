package com.example.bookinghotel.service.imp;

import com.example.bookinghotel.dto.RoomTypeDTO;
import com.example.bookinghotel.enity.RoomEntity;
import com.example.bookinghotel.enity.RoomTypeEntity;
import com.example.bookinghotel.payload.request.InsertRoomTypeRequest;
import com.example.bookinghotel.payload.request.UpdateRoomTypeRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface RoomTypeServiceImp {
      RoomTypeEntity insertRoomType (HttpServletRequest request, InsertRoomTypeRequest typeRequest);
     List<RoomTypeDTO> getAllRoomType(HttpServletRequest request);
     void deleteRoomType( HttpServletRequest request ,int id);
     RoomTypeEntity updateRoomType (HttpServletRequest request , UpdateRoomTypeRequest updateRoomTypeRequest , int id);


}
