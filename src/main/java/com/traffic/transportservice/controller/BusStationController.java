package com.traffic.transportservice.controller;

import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BusStationController {

    /**
     * 站台信息查询
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetBusStationInfo.do")
    public Map GetBusStationInfo(@RequestBody Map<String, String> map) {
        try {
            if (Integer.valueOf(map.get("BusStationId")) <= 3 && Integer.valueOf(map.get("BusStationId")) > 0) {
                List BusStationList = new ArrayList<Map>();
                for (int i = 1; i <= 2; i++) {
                    Map map1 = new HashMap();
                    map1.put("Distance", new Random().nextInt(5001));
                    map1.put("BusId", i);
                    BusStationList.add(map1);
                }
                return ResultUtil.success("成功", BusStationList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

}
