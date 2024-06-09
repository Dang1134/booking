package com.example.bookinghotel.controller;

import com.example.bookinghotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")

public class RoomController {
    @Autowired
    private RoomService roomService ;
    @GetMapping
    public ResponseEntity<?> getAllRoom(){
        return new ResponseEntity<>(roomService.getALlRoom(), HttpStatus.OK);
    }
}
