package com.traffic.transportservice.service;

import java.util.Map;

public interface SenseInfoService {

    Map getAllSense();
    Map getSenseByName(String senseName);
}
