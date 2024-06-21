package com.example.bookinghotel.controller;

import com.example.bookinghotel.enity.RoomTypeEntity;
import com.example.bookinghotel.service.imp.RoomTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payload.request.InsertRoomTypeRequest;
import payload.request.UpdateRoomTypeRequest;
import payload.response.BaseResponse;

import java.util.List;

@RestController
@RequestMapping("/roomtype")

public class RoomTypeController {
    @Autowired
    private RoomTypeServiceImp roomTypeServiceImp ;


    @PostMapping
    public ResponseEntity<?> insertRoomType(InsertRoomTypeRequest request){
        roomTypeServiceImp.insertRoomType(request);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("Thêm mới thành công ");
        baseResponse.setData(request);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomType(@PathVariable int id) {
        try {
            roomTypeServiceImp.deleteRoomType(id);
            return new ResponseEntity<>("Xóa loại phòng thành công", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Không thể xóa loại phòng", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
