package com.traffic.transportservice.controller;

import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
public class BusController {

    /**
     * 车载容量查询
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetBusCapacity.do")
    public Map GetBusCapacity(@RequestBody Map<String, String> map) {
        try {
            if (Integer.valueOf(map.get("BusId")) <= 15 && Integer.valueOf(map.get("BusId")) > 0) {
                Integer BusCapacity = new Random().nextInt(120) + 1;
                return ResultUtil.success("成功", BusCapacity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

}
