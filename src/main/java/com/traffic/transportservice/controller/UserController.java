package com.traffic.transportservice.controller;

import com.traffic.transportservice.entity.UserInfo;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create by zoujunhao on 2019/2/1
 */

@RestController
public class UserController {


    @Resource
    UserService userService;


    /**
     * 获取所有用户信息（管理员权限）
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/GetSUserInfo.do")
    public Map GetAllUserInfo(@RequestBody Map<String, String> map) {
        try {
            if (userService.isAdminRole(map.get("UserName"))) {
                List<UserInfo> userInfoList = userService.getUserList();
                return ResultUtil.success("成功", userInfoList);
            } else if (userService.isNullRole(map.get("UserName")))
                return ResultUtil.error(ResultUtil.INVALID_WARNING);
            else
                return ResultUtil.error(ResultUtil.PERMISSIONS_WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

    /**
     * 用户登录(无效用户不可登录)
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/user_login.do")
    public Map UserLogin(@RequestBody Map<String, String> map) {
        try {
            if (userService.isNullRole(map.get("UserName")))
                return ResultUtil.error(ResultUtil.INVALID_WARNING);
            String msg = userService.userLogin(map.get("UserName"), map.get("passWord"));
            if (msg.indexOf("R") == 0)
                return ResultUtil.success("登录成功", "UserRole", msg);
            else
                return ResultUtil.error(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

    /**
     * 用户注册(默认为普通用户)
     *
     * @param map
     * @return
     */
    @PostMapping(value = "/transportservice/action/user_register.do")
    public Map UserRegister(@RequestBody Map<String, String> map) {
        try {
            String msg = userService.userRegister(Long.parseLong(map.get("pcardId")), map.get("UserName"),
                    map.get("passWord"), map.get("pname"), map.get("psex"), Long.parseLong(map.get("ptel")));
            if (msg.equals("S"))
                return ResultUtil.success("注册成功");
            else
                return ResultUtil.error(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

}
