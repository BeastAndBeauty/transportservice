package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.RoadLightControlModeInfo;
import com.traffic.transportservice.entity.TrafficLightInfo;

import java.util.List;

public interface TrafficLightService {
    List<TrafficLightInfo> getTrafficLightList();

    /**
     * 更新红绿灯的配置信息（红灯）
     *
     * @param redtime
     * @param trafficlightid
     * @return
     */
    int updateTrafficLightRedtime(int redtime, int trafficlightid);

    /**
     * 更新红绿灯的配置信息（绿灯）
     *
     * @param greentime
     * @param trafficlightid
     * @return
     */
    int updateTrafficLightGreentime(int greentime, int trafficlightid);

    /**
     * 更新红绿灯的配置信息（黄灯）
     *
     * @param yellowtime
     * @param trafficlightid
     * @return
     */
    int updateTrafficLightYellowtime(int yellowtime, int trafficlightid);

    /**
     * 查询红绿灯的配置信息
     *
     * @param trafficlightid
     * @return
     */
    TrafficLightInfo getTrafficLight(int trafficlightid);

    void saveAll(List<TrafficLightInfo> trafficLightInfos);

}
