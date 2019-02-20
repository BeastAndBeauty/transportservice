package com.traffic.transportservice.controller;

import com.traffic.transportservice.service.SenseInfoService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:    传感器
 * @Author:         paopao
 * @CreateDate:     2019/2/12 21:36
 */
@RestController
public class SenseInfoController {

    @Resource
    private SenseInfoService senseInfoService;
    @Resource
    private UserService userInfoService;

    @RequestMapping(value = "/transportservice/action/GetAllSense.do",method = RequestMethod.POST)
    public Map getAllSense(@RequestBody Map<String,String> map){
        if(userInfoService.isNullRole(map.get("UserName"))){
            return ResultUtil.error("无效用户");
        }else {
            return senseInfoService.getAllSense();
        }
    }

    @RequestMapping(value = "/transportservice/action/GetSenseByName.do",method = RequestMethod.POST)
    public Map getSenseByName(@RequestBody Map<String,String> map){
        if(userInfoService.isNullRole(map.get("UserName"))){
            return ResultUtil.error("无效用户");
        }else if(!map.get("SenseName").equals("pm2.5")&&!map.get("SenseName").equals("co2")&&!map.get("SenseName").equals("lightIntensity")
                &&!map.get("SenseName").equals("humidity")&&!map.get("SenseName").equals("temperature")) {
            return ResultUtil.error("失败");
        }else {
            return senseInfoService.getSenseByName(map.get("SenseName"));
        }
    }

}
