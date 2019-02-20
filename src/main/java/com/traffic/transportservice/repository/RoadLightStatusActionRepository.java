package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.RoadLightStatusActionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RoadLightStatusActionRepository extends JpaRepository<RoadLightStatusActionInfo,Integer> {

    //查询路灯状态（打开/关闭）
    @Query(value = "SELECT action FROM road_light_status_action_info where road_light_id=?1", nativeQuery = true)
    String findAction(String roadLightId);

    //设置路灯状态（打开/关闭）
    @Transactional
    @Modifying
    @Query(value = "update road_light_status_action_info set action=?1 where road_light_id=?2", nativeQuery = true)
    Integer updateAction(String action, String roadLightId);

}
