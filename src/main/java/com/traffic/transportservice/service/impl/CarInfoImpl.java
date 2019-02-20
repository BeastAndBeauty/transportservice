package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.CarInfo;
import com.traffic.transportservice.repository.CarInfoRepository;
import com.traffic.transportservice.service.CarInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarInfoImpl implements CarInfoService {

    @Resource
    private CarInfoRepository carInfoRepository;


    @Override
    public void saveAll(List<CarInfo> carInfoList) {
        carInfoRepository.saveAll(carInfoList);
    }

    @Override
    public String getCarBalance(String carId) {
        return carInfoRepository.findCarBalanceByCarId(carId);
    }

    @Override
    public int setCarMoveAndSpeed(String carAction, String carSpeed, String carId) {
        return carInfoRepository.updateCarActionAndSpeed(carAction, carSpeed, carId);
    }

    @Override
    public int setCarAccountRecharge(String balance, String carId) {
        return carInfoRepository.updateCarBalance(balance, carId);
    }

    @Override
    public String getCarSpeed(String carId) {
        return carInfoRepository.getCarSpeed(carId);
    }

    @Override
    public List<CarInfo> getCarInfo(Long pcardId) {
        return carInfoRepository.selectUserInfo(pcardId);
    }

    @Override
    public Boolean GetCarPeccancy(String carnumber) {
        if (carInfoRepository.selectcarnumber(carnumber) == 0)
            return false;
        else
            return true;
    }


}
