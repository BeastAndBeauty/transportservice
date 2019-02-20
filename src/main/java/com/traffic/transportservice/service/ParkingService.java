package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.ParkingInfo;

import java.util.List;

/**
 * Create by zoujunhao on 2019/2/17
 */
public interface ParkingService {
    List<ParkingInfo> getParkFree(Boolean idleMode);
    void saveAll(List<ParkingInfo> parkingInfos);
}
