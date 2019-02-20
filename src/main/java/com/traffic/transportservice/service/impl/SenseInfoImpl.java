package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.service.SenseInfoService;
import com.traffic.transportservice.util.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SenseInfoImpl implements SenseInfoService {
    @Override
    public Map getAllSense() {
        return RandomUtil.randomAllSense();
    }

    @Override
    public Map getSenseByName(String senseName) {
        return RandomUtil.randomSenseByName(senseName);
    }
}
