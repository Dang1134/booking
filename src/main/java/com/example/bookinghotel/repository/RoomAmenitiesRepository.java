package com.example.bookinghotel.repository;

import com.example.bookinghotel.enity.RoomAmenitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoomAmenitiesRepository extends JpaRepository<RoomAmenitiesEntity , Integer> {
    @Transactional
    void deleteByRoomId(int roomId);
}
