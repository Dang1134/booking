package com.example.bookinghotel.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateRoomTypeException extends RuntimeException{
    private String massage;
}
