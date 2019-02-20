package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.ParkingFeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Create by zoujunhao on 2019/2/17
 */
public interface ParkingFeeRepository extends JpaRepository<ParkingFeeInfo, Integer> {

    //费率设置
    @Transactional
    @Modifying
    @Query(value = "update parking_fee_info set rate_type=?1,money=?2", nativeQuery = true)
    Integer update(String RateType, double Money);


    @Query(value = "SELECT * FROM parking_fee_info LIMIT 1", nativeQuery = true)
    ParkingFeeInfo findFirst();
}
