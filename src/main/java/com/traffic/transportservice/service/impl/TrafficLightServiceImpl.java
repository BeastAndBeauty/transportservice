package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.TrafficLightInfo;
import com.traffic.transportservice.repository.TrafficLightRepository;
import com.traffic.transportservice.service.TrafficLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficLightServiceImpl implements TrafficLightService {

    @Autowired
    private TrafficLightRepository trafficLightRepository;

    @Override
    public List<TrafficLightInfo> getTrafficLightList() {
        return trafficLightRepository.findAll();
    }

    @Override
    public int updateTrafficLightRedtime(int redtime, int trafficlightid) {
        return trafficLightRepository.updateTrafficLightRedtime(redtime,trafficlightid);
    }

    @Override
    public int updateTrafficLightGreentime(int greentime, int trafficlightid) {
        return trafficLightRepository.updateTrafficLightGreentime(greentime,trafficlightid);
    }

    @Override
    public int updateTrafficLightYellowtime(int yellowtime, int trafficlightid) {
        return trafficLightRepository.updateTrafficLightYellowtime(yellowtime,trafficlightid);
    }


    @Override
    public TrafficLightInfo getTrafficLight(int trafficlightid) {
        return trafficLightRepository.findByTrafficlightid(trafficlightid);
    }

    @Override
    public void saveAll(List<TrafficLightInfo> trafficLightInfos) {
        trafficLightRepository.saveAll(trafficLightInfos);
    }
}
