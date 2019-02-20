package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.CarInfo;

import java.util.List;

public interface CarInfoService {

    void saveAll(List<CarInfo> carInfoList);

    String getCarBalance(String carId);

    int setCarMoveAndSpeed(String carAction, String carSpeed, String carId);

    int setCarAccountRecharge(String balance, String carId);

    String getCarSpeed(String carId);

    List<CarInfo> getCarInfo(Long pcardId);

    Boolean GetCarPeccancy(String carnumber);
}
