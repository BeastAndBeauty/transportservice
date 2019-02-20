package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.RoadLightStatusActionInfo;

import java.util.List;

public interface RoadLightStatusActionService {

    void saveAll(List<RoadLightStatusActionInfo> roadLightStatusActionInfoList);


    String getRoadLightStatusAction(String roadLightId);

    int setRoadLightStatusAction(String action, String roadLightId);
}
