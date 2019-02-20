package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.ParkingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by zoujunhao on 2019/2/17
 */
public interface ParkingRepository extends JpaRepository<ParkingInfo, Integer> {
    List<ParkingInfo> findByIdleMode(Boolean idleMode);
}
