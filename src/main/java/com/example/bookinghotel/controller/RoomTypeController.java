package com.example.bookinghotel.controller;

import com.example.bookinghotel.dto.RoomTypeDTO;
import com.example.bookinghotel.enity.RoomTypeEntity;
import com.example.bookinghotel.payload.request.UpdateRoomTypeRequest;
import com.example.bookinghotel.service.imp.RoomTypeServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bookinghotel.payload.request.InsertRoomTypeRequest;
import com.example.bookinghotel.payload.response.BaseResponse;

import java.util.List;

@RestController
@RequestMapping("/roomtype")

public class RoomTypeController {
    @Autowired
    private RoomTypeServiceImp roomTypeServiceImp ;

    @GetMapping
    public ResponseEntity<?> getAllRoomType(HttpServletRequest request){
        List<RoomTypeDTO> list = roomTypeServiceImp.getAllRoomType(request);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("Thanh cong");
        baseResponse.setData(list);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> insertRoomType (HttpServletRequest request , @RequestBody InsertRoomTypeRequest typeRequest){
        try {
          RoomTypeEntity roomTypeEntity = roomTypeServiceImp.insertRoomType(request , typeRequest);
          BaseResponse baseResponse = BaseResponse.successBaseResponse(roomTypeEntity , "Thêm mới thành công");
          return new ResponseEntity<>(baseResponse,HttpStatus.OK);

        }catch (Exception e){
            BaseResponse baseResponse = BaseResponse.errorBaseResponse("Thêm mới thất bại");
            return new ResponseEntity<>(baseResponse, HttpStatus.OK);
        }




    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoomType(UpdateRoomTypeRequest updateRoomTypeRequest){
        return new ResponseEntity<>("baseResponse", HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomType(HttpServletRequest request ,@PathVariable int id) {
        try {
           roomTypeServiceImp.deleteRoomType(request, id);
            BaseResponse baseResponse = BaseResponse.successBaseResponse(null ," Xóa loại phòng thành công ");
            return new ResponseEntity<>(baseResponse, HttpStatus.OK);
        } catch (Exception e) {
            BaseResponse baseResponse = BaseResponse.errorBaseResponse("Xoá phòng không thành công");
            return new ResponseEntity<>(baseResponse, HttpStatus.OK);
        }
    }
}
