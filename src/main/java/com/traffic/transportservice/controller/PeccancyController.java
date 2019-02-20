package com.traffic.transportservice.controller;

import com.traffic.transportservice.entity.PeccancyInfo;
import com.traffic.transportservice.service.PeccancyService;
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
public class PeccancyController {

    @Resource
    UserService userService;
    @Resource
    private PeccancyService peccancyService;

    /**
     * 查询车辆违章记录
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetCarPeccancy.do")
    public Map getPeccancyInfo(@RequestBody Map<String, String> map) {
        try {
            if (userService.isNullRole(map.get("UserName")))
                return ResultUtil.error(ResultUtil.INVALID_WARNING);
            List<PeccancyInfo> list = peccancyService.getPeccancyInfo(map.get("carnumber"));
            if (list.size() != 0)
                return ResultUtil.success("成功", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

    /**
     * 查询所有车辆违章记录（管理员权限）
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetAllCarPeccancy.do")
    public Map getAllCarPeccancy(@RequestBody Map<String, String> map) {
        try {
            if (userService.isAdminRole(map.get("UserName"))) {
                List<PeccancyInfo> list = peccancyService.getAllPeccancyInfo();
                return ResultUtil.success("成功", list);
            } else if (userService.isNullRole(map.get("UserName")))
                return ResultUtil.error(ResultUtil.INVALID_WARNING);
            else
                return ResultUtil.error(ResultUtil.PERMISSIONS_WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }
}
