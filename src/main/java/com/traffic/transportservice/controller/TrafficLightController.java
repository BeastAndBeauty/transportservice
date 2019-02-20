package com.traffic.transportservice.controller;

import com.traffic.transportservice.entity.TrafficLightInfo;
import com.traffic.transportservice.service.TrafficLightService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TrafficLightController {

    @Resource
    TrafficLightService trafficLightService;

    @Resource
    UserService userService;

    /**
     * 查询红绿灯的配置信息（管理员权限）
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetTrafficLightConfigAction.do")
    public Map GetTrafficLightConfigAction(@RequestBody Map<String, String> map) {
        try {
            if (userService.isAdminRole(map.get("UserName"))) {
                TrafficLightInfo trafficLightInfo = trafficLightService.getTrafficLight(Integer.valueOf(map.get("TrafficLightId")));
                return ResultUtil.success("成功", trafficLightInfo);
            } else
                return ResultUtil.error(ResultUtil.PERMISSIONS_WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

    /**
     * 设置红绿灯当前状态（管理员权限）
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/SetTrafficLightNowStatus.do")
    public Map SetTrafficLightNowStatus(@RequestBody Map<String, String> map) {
        try {
            if (userService.isAdminRole(map.get("UserName"))) {
                switch (map.get("Status")) {
                    case "Red":
                        trafficLightService.updateTrafficLightRedtime(Integer.valueOf(map.get("Time")), Integer.valueOf(map.get("TrafficLightId")));
                        break;
                    case "Green":
                        trafficLightService.updateTrafficLightGreentime(Integer.valueOf(map.get("Time")), Integer.valueOf(map.get("TrafficLightId")));
                        break;
                    case "Yellow":
                        trafficLightService.updateTrafficLightYellowtime(Integer.valueOf(map.get("Time")), Integer.valueOf(map.get("TrafficLightId")));
                        break;
                }
                return ResultUtil.success("设置成功");
            } else
                return ResultUtil.error(ResultUtil.PERMISSIONS_WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

    /**
     * 查询红绿灯当前状态（管理员权限）
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetTrafficLightNowStatus.do")
    public Map GetTrafficLightNowStatus(@RequestBody Map<String, String> map) {
        try {
            if (userService.isAdminRole(map.get("UserName"))) {
                TrafficLightInfo trafficLightInfo = trafficLightService.getTrafficLight(Integer.valueOf(map.get("TrafficLightId")));
                List trafficlightList = new ArrayList<Object>();
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("Status", "Red");
                map1.put("Time", trafficLightInfo.getRedtime());
                trafficlightList.add(map1);
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("Status", "Green");
                map2.put("Time", trafficLightInfo.getGreentime());
                trafficlightList.add(map2);
                Map<String, Object> map3 = new HashMap<String, Object>();
                map3.put("Status", "Yellow");
                map3.put("Time", trafficLightInfo.getYellowtime());
                trafficlightList.add(map3);
                return ResultUtil.success("成功", trafficlightList);
            } else
                return ResultUtil.error(ResultUtil.PERMISSIONS_WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }
}
