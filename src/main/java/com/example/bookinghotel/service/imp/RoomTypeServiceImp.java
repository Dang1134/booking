package com.example.bookinghotel.service.imp;

import com.example.bookinghotel.enity.RoomTypeEntity;
import payload.request.InsertRoomTypeRequest;
import payload.request.UpdateRoomTypeRequest;

public interface RoomTypeServiceImp {
     void insertRoomType (InsertRoomTypeRequest request);


     void deleteRoomType(int id);

}
