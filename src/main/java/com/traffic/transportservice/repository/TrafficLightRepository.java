package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.TrafficLightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface TrafficLightRepository extends JpaRepository<TrafficLightInfo, Long> {

    @Transactional
    @Modifying
    @Query(value = "update traffic_light_info set redtime=?1 where trafficlightid=?2", nativeQuery = true)
    Integer updateTrafficLightRedtime(int redtime, int trafficlightid);

    @Transactional
    @Modifying
    @Query(value = "update traffic_light_info set yellowtime=?1 where trafficlightid=?2", nativeQuery = true)
    Integer updateTrafficLightYellowtime(int yellowtime, int trafficlightid);

    @Transactional
    @Modifying
    @Query(value = "update traffic_light_info set greentime=?1 where trafficlightid=?2", nativeQuery = true)
    Integer updateTrafficLightGreentime(int greentime, int trafficlightid);

    TrafficLightInfo findByTrafficlightid(int trafficlightid);
}
