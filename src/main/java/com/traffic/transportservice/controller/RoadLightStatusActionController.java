package com.traffic.transportservice.controller;


import com.traffic.transportservice.service.RoadLightStatusActionService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description: 手动打开/关闭定路灯（管理员权限）
 * @Author: paopao
 * @CreateDate: 2019/2/12 21:36
 */

@RestController
public class RoadLightStatusActionController {

    @Resource
    private RoadLightStatusActionService roadLightService;
    @Resource
    private UserService userInfoService;


    @RequestMapping(value = "/transportservice/action/GetRoadLightStatusAction.do", method = RequestMethod.POST)
    public Map getCarAccountBalance(@RequestBody Map<String, String> map) {
        if (!userInfoService.isAdminRole(map.get("UserName"))) {
            return ResultUtil.error("权限不足");
        } else {
            String action = roadLightService.getRoadLightStatusAction(map.get("RoadLightId"));
            return ResultUtil.success("成功", "Action", action);
        }
    }

    @RequestMapping(value = "/transportservice/action/SetRoadLightStatusAction.do", method = RequestMethod.POST)
    public Map setCarMove(@RequestBody Map<String, String> map) {
        if (!userInfoService.isAdminRole(map.get("UserName"))) {
            return ResultUtil.error("权限不足");
        } else if (!map.get("Action").equals("Close") && !map.get("Action").equals("Open")) {
            return ResultUtil.error("失败");
        } else if (roadLightService.setRoadLightStatusAction(map.get("Action"), map.get("RoadLightId")) == 1) {
            return ResultUtil.success("成功");
        } else {
            return ResultUtil.error();
        }
    }

}
