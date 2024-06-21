package com.example.bookinghotel.repository;

import com.example.bookinghotel.enity.AmenitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface AmenitiesRepository extends JpaRepository<AmenitiesEntity , Integer> {
}
