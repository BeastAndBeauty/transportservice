package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.ParkingInfo;
import com.traffic.transportservice.repository.ParkingRepository;
import com.traffic.transportservice.service.ParkingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by zoujunhao on 2019/2/17
 */
@Service
public class ParkingImpl implements ParkingService {

    @Resource
    private ParkingRepository parkingRepository;

    @Override
    public List<ParkingInfo> getParkFree(Boolean idleMode) {
        return parkingRepository.findByIdleMode(idleMode);
    }

    @Override
    public void saveAll(List<ParkingInfo> parkingInfos) {
        parkingRepository.saveAll(parkingInfos);
    }

}
