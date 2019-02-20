package com.traffic.transportservice.controller;

import com.traffic.transportservice.entity.ParkingInfo;
import com.traffic.transportservice.service.ParkingService;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create by zoujunhao on 2019/2/17
 */
@RestController
public class ParkingController {

    @Resource
    private ParkingService parkingService;

    @Resource
    private UserService userInfoService;

    /**
     * 查询当前空闲车位
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetParkFree.do")
    public Map GetBusCapacity(@RequestBody Map<String, String> map) {
        try {
                if (userInfoService.isNullRole(map.get("UserName")))
                return ResultUtil.error("无效用户");
            else {
                List<ParkingInfo> list = parkingService.getParkFree(true);
                if (list.size() != 0)
                    return ResultUtil.success("成功", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

}
