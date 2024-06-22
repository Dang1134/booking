package com.example.bookinghotel.controller;

import com.example.bookinghotel.dto.RoomDTO;
import com.example.bookinghotel.payload.response.BaseResponse;
import com.example.bookinghotel.service.RoomService;
import com.example.bookinghotel.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")

public class RoomController {
    @Autowired
    private RoomServiceImp roomServiceImp;
    @GetMapping
    public ResponseEntity<?> getAllRoom(){
        List<RoomDTO> listRoomDTO = roomServiceImp.getAllRoom();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("Thanh cong");
        baseResponse.setData(listRoomDTO);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
