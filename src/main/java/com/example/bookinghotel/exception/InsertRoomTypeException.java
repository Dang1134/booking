package com.example.bookinghotel.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InsertRoomTypeException extends RuntimeException {
    private String massage;
}
