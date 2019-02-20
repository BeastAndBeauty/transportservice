package com.traffic.transportservice.controller;

import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
public class RoadController {

    /**
     * 查询道路状态
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetRoadStatus.do")
    public Map GetRoadStatus(@RequestBody Map<String, String> map) {
        try {
            if (Integer.valueOf(map.get("RoadId")) <= 12 && Integer.valueOf(map.get("RoadId")) > 0) {
                Integer Status = new Random().nextInt(5);
                return ResultUtil.success("成功", Status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }
}
