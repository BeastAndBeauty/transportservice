package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.RoadLightControlModeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RoadLightControlModeInfoRepository extends JpaRepository<RoadLightControlModeInfo,Integer> {

    //查询路灯控制模式（自动/手工）
    @Query(value = "SELECT control_mode FROM road_light_control_mode_info", nativeQuery = true)
    String findControlMode();

    //设置路灯控制模式（自动/手工）
    @Transactional
    @Modifying
    @Query(value = "update road_light_control_mode_info set control_mode=?1", nativeQuery = true)
    Integer updateControlMode(String controlMode);
}
