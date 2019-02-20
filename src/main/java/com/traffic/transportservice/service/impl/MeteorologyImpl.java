package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.service.MeteorologyService;
import com.traffic.transportservice.util.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create by zoujunhao on 2019/2/16
 */

@Service
public class MeteorologyImpl implements MeteorologyService {
    @Override
    public Map GetWeather() {
        return RandomUtil.randomGetWeather();
    }
}
