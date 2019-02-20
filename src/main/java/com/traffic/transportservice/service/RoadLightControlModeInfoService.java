package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.RoadLightControlModeInfo;

import java.util.List;

public interface RoadLightControlModeInfoService {
    void saveAll(List<RoadLightControlModeInfo> roadLightControlModeInfos);
    String getRoadLightControlMode();

    int setRoadLightControlMode(String controlMode);
}
