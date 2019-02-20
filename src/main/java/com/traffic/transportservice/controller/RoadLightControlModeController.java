package com.traffic.transportservice.controller;

import com.traffic.transportservice.service.RoadLightControlModeInfoService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:    自动/手工控制模式（管理员权限）
 * @Author:         paopao
 * @CreateDate:     2019/2/12 21:36
 */

@RestController
public class RoadLightControlModeController {

    @Resource
    private RoadLightControlModeInfoService roadLightService;
    @Resource
    private UserService userInfoService;

    @RequestMapping(value = "/transportservice/action/GetRoadLightControlMode.do",method = RequestMethod.POST)
    public Map getCarAccountBalance(@RequestBody Map<String,String> map){
        if(!userInfoService.isAdminRole(map.get("UserName"))){
            return ResultUtil.error("权限不足");
        }else {
            return ResultUtil.success("成功","ControlMode",roadLightService.getRoadLightControlMode());
        }
    }

    @RequestMapping(value = "/transportservice/action/SetRoadLightControlMode.do",method = RequestMethod.POST)
    public Map setCarMove(@RequestBody Map<String,String> map) {
        if (!userInfoService.isAdminRole(map.get("UserName"))) {
            return ResultUtil.error("权限不足");
        } else if(!map.get("ControlMode").equals("Auto")&&!map.get("ControlMode").equals("Manual")) {
            return ResultUtil.error("失败");
        }else if (roadLightService.setRoadLightControlMode(map.get("ControlMode")) == 1) {
            return ResultUtil.success("成功");
        } else {
            return ResultUtil.error();
        }
    }

}
