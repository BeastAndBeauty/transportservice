package com.traffic.transportservice.controller;

import com.traffic.transportservice.service.MeteorologyService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Create by zoujunhao on 2019/2/16
 */
@RestController
public class MeteorologyController {
    @Resource
    private MeteorologyService meteorologyService;
    @Resource
    private UserService userService;

    /**
     * 气象信息查询
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetWeather.do")
    public Map GetAllUserInfo(@RequestBody Map<String, String> map) {
        try {
            if (userService.isNullRole(map.get("UserName")))
                return ResultUtil.error(ResultUtil.INVALID_WARNING);
            else
                return meteorologyService.GetWeather();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }
}
