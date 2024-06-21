package com.example.bookinghotel.enity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RoomAmenitiesID  implements Serializable {
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "amenities_id")
    private int amenitiesId;
}
