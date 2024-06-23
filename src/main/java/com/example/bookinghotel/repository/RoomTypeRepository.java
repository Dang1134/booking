package com.example.bookinghotel.repository;

import com.example.bookinghotel.enity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity , Integer> {

}
