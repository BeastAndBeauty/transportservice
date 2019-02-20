package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.RoadLightControlModeInfo;
import com.traffic.transportservice.repository.RoadLightControlModeInfoRepository;
import com.traffic.transportservice.service.RoadLightControlModeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoadLightControlModeImpl implements RoadLightControlModeInfoService {

    @Resource
    private RoadLightControlModeInfoRepository repository;

    @Override
    public void saveAll(List<RoadLightControlModeInfo> roadLightControlModeInfos) {
        repository.saveAll(roadLightControlModeInfos);
    }

    @Override
    public String getRoadLightControlMode() {
        return repository.findControlMode();
    }

    @Override
    public int setRoadLightControlMode(String controlMode) {
        return repository.updateControlMode(controlMode);
    }
}
