package com.traffic.transportservice.controller;

import com.traffic.transportservice.service.ParkingFeeService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Create by zoujunhao on 2019/2/17
 */
@RestController
public class ParkingFeeController {
    @Resource
    private ParkingFeeService parkingFeeService;

    @Resource
    private UserService userInfoService;


    /**
     * 费率设置(管理员)
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/SetParkRate.do")
    public Map SetParkRate(@RequestBody Map<String, String> map) {
        try {
            if (userInfoService.isAdminRole(map.get("UserName"))) {
                if (parkingFeeService.SetParkRate(map.get("RateType"), Double.parseDouble(map.get("Money"))) != 0)
                    return ResultUtil.success("设置成功");
            } else if (userInfoService.isNullRole(map.get("UserName")))
                return ResultUtil.error(ResultUtil.INVALID_WARNING);
            else
                return ResultUtil.error(ResultUtil.PERMISSIONS_WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

    /**
     * 查询当前费率信息
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetParkRate.do")
    public Map GetParkRate(@RequestBody Map<String, String> map) {
        try {
            if (userInfoService.isNullRole(map.get("UserName")))
                return ResultUtil.error("无效用户");
            else {
                return ResultUtil.success("成功", parkingFeeService.getParkRate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }
}
