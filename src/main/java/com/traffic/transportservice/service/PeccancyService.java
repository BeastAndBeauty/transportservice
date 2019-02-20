package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.PeccancyInfo;

import java.util.List;

/**
 * Create by zoujunhao on 2019/2/16
 */
public interface PeccancyService {
    List<PeccancyInfo> getPeccancyInfo(String carnumber);
    List<PeccancyInfo> getAllPeccancyInfo();
    void saveAll(List<PeccancyInfo> peccancyInfos);
}
