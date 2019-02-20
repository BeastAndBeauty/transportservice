package com.traffic.transportservice.controller;

import com.traffic.transportservice.entity.CarInfo;
import com.traffic.transportservice.service.CarInfoService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.CheckUtil;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description: 小车
 * @Author: paopao
 * @CreateDate: 2019/2/12 21:36
 */

@RestController
public class CarInfoController {

    @Resource
    private CarInfoService carInfoService;
    @Resource
    private UserService userInfoService;


    @RequestMapping(value = "/transportservice/action/GetCarAccountBalance.do", method = RequestMethod.POST)
    public Map getCarAccountBalance(@RequestBody Map<String, String> map) {
        if (userInfoService.isNullRole(map.get("UserName"))) {
            return ResultUtil.error("无效用户");
        } else {
            String balance = carInfoService.getCarBalance(map.get("CarId"));
            return ResultUtil.success("成功", "Balance", Integer.valueOf(balance));
        }
    }

    @RequestMapping(value = "/transportservice/action/SetCarMove.do", method = RequestMethod.POST)
    public Map setCarMove(@RequestBody Map<String, String> map) {
        if (userInfoService.isNullRole(map.get("UserName"))) {
            return ResultUtil.error("无效用户");
        } else if (!map.get("CarAction").equals("Start") && !map.get("CarAction").equals("Stop")) {
            return ResultUtil.error("失败");
        } else if (carInfoService.setCarMoveAndSpeed(map.get("CarAction"), "0", map.get("CarId")) == 1) {
            return ResultUtil.success("成功");
        } else {
            return ResultUtil.error("失败");
        }
    }

    @RequestMapping(value = "/transportservice/action/SetCarAccountRecharge.do", method = RequestMethod.POST)
    public Map setCarAccountRecharge(@RequestBody Map<String, String> map) {
        if (userInfoService.isNullRole(map.get("UserName"))) {
            return ResultUtil.error("无效用户");
        } else if (!CheckUtil.isPositionInteger(String.valueOf(map.get("Money")))) {
            return ResultUtil.error("失败");
        } else {
            String balance = carInfoService.getCarBalance(map.get("CarId"));
            int lastestBalance = Integer.valueOf(balance) + Integer.valueOf(map.get("Money"));
            if (carInfoService.setCarAccountRecharge(String.valueOf(lastestBalance), map.get("CarId")) == 1) {
                return ResultUtil.success("成功");
            } else {
                return ResultUtil.error("失败");
            }
        }
    }

    @RequestMapping(value = "/transportservice/action/GetCarSpeed.do", method = RequestMethod.POST)
    public Map getCarSpeed(@RequestBody Map<String, String> map) {
        if (userInfoService.isNullRole(map.get("UserName"))) {
            return ResultUtil.error("无效用户");
        } else {
            String speed = carInfoService.getCarSpeed(map.get("CarId"));
            return ResultUtil.success("成功", "Speed", Integer.valueOf(speed));
        }
    }

    @RequestMapping(value = "/transportservice/action/SetCarSpeed.do", method = RequestMethod.POST)
    public Map setCarSpeed(@RequestBody Map<String, String> map) {
        if (userInfoService.isNullRole(map.get("UserName"))) {
            return ResultUtil.error("无效用户");
        } else if (!CheckUtil.isPositionInteger(map.get("Speed"))) {
            return ResultUtil.error("失败");
        } else if (map.get("Speed").equals("0")) {
            if (carInfoService.setCarMoveAndSpeed("Stop", "0", map.get("CarId")) == 1) {
                return ResultUtil.success("成功");
            } else {
                return ResultUtil.error("失败");
            }
        } else if (carInfoService.setCarMoveAndSpeed("Start", map.get("Speed"), map.get("CarId")) == 1) {
            return ResultUtil.success("成功");
        } else {
            return ResultUtil.error("失败");
        }
    }

    /**
     * 车辆信息查询
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetCarInfo.do")
    public Map GetCarInfo(@RequestBody Map<String, String> map) {
        if (userInfoService.isNullRole(map.get("UserName")))
            return ResultUtil.error("无效用户");
        else {
            Long pcardId = userInfoService.selectPcardId(map.get("UserName"));
            System.out.println(pcardId);
            List<CarInfo> carInfoList = carInfoService.getCarInfo(pcardId);
            if (carInfoList.size() == 0)
                return ResultUtil.error();
            return ResultUtil.success("成功", carInfoList);
        }
    }
}
