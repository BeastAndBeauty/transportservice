package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.PeccancyInfo;
import com.traffic.transportservice.repository.CarInfoRepository;
import com.traffic.transportservice.repository.PeccancyRepository;
import com.traffic.transportservice.service.PeccancyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by zoujunhao on 2019/2/16
 */

@Service
public class PeccancyImpl implements PeccancyService {


    @Resource
    private PeccancyRepository peccancyRepository;

    @Resource
    private CarInfoRepository carInfoRepository;


    @Override
    public List<PeccancyInfo> getPeccancyInfo(String carnumber) {
        if (carInfoRepository.selectcarnumber(carnumber) != 0)
            return peccancyRepository.selectPeccancyInfo(carnumber);
        else
            return new ArrayList<>();
    }

    @Override
    public List<PeccancyInfo> getAllPeccancyInfo() {
        return peccancyRepository.findAll();
    }

    @Override
    public void saveAll(List<PeccancyInfo> peccancyInfos) {
        peccancyRepository.saveAll(peccancyInfos);
    }
}
