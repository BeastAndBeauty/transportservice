package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.ParkingFeeInfo;


/**
 * Create by zoujunhao on 2019/2/17
 */
public interface ParkingFeeService {

    int SetParkRate(String RateType, double Money);

    ParkingFeeInfo getParkRate();
    void save(ParkingFeeInfo parkingFeeInfo);
}
