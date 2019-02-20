package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.RoadLightStatusActionInfo;
import com.traffic.transportservice.repository.RoadLightStatusActionRepository;
import com.traffic.transportservice.service.RoadLightStatusActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoadLightStatusActionImpl implements RoadLightStatusActionService {

    @Resource
    private RoadLightStatusActionRepository repository;


    @Override
    public void saveAll(List<RoadLightStatusActionInfo> roadLightStatusActionInfoList) {
        repository.saveAll(roadLightStatusActionInfoList);
    }

    @Override
    public String getRoadLightStatusAction(String roadLightId) {
        return repository.findAction(roadLightId);
    }

    @Override
    public int setRoadLightStatusAction(String action, String roadLightId) {
        return repository.updateAction(action, roadLightId);
    }
}
