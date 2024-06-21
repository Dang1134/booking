package com.example.bookinghotel.service.imp;

import com.example.bookinghotel.payload.request.InsertRoomTypeRequest;

public interface RoomTypeServiceImp {
     void insertRoomType (InsertRoomTypeRequest request);


     void deleteRoomType(int id);

}
