package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.ParkingFeeInfo;
import com.traffic.transportservice.repository.ParkingFeeRepository;
import com.traffic.transportservice.service.ParkingFeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by zoujunhao on 2019/2/17
 */
@Service
public class ParkingFeeImpl implements ParkingFeeService {
    @Resource
    private ParkingFeeRepository parkingFeeRepository;


    @Override
    public int SetParkRate(String RateType, double Money) {
        return parkingFeeRepository.update(RateType, Money);
    }

    @Override
    public ParkingFeeInfo getParkRate() {
        return parkingFeeRepository.findFirst();
    }

    @Override
    public void save(ParkingFeeInfo parkingFeeInfo) {
        parkingFeeRepository.save(parkingFeeInfo);
    }
}
