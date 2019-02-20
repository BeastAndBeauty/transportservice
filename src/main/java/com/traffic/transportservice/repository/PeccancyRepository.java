package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.PeccancyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by zoujunhao on 2019/2/16
 */
public interface PeccancyRepository extends JpaRepository<PeccancyInfo, Integer> {
    //通过小车车牌号获取违章信息
    @Query(value = "select * from peccancy_info where carnumber=?1", nativeQuery = true)
    List<PeccancyInfo> selectPeccancyInfo(String carnumber);
}
