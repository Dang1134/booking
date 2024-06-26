package com.example.bookinghotel.repository;

import com.example.bookinghotel.enity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RoomRepository extends JpaRepository<RoomEntity , Integer> {
  // List<RoomEntity> findByRoomTypeId(int roomType_id);
   List<RoomEntity> findByRoomTypeId(int roomTypeId);

}
