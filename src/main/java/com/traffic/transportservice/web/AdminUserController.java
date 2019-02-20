package com.traffic.transportservice.web;

import com.traffic.transportservice.entity.UserInfo;
import com.traffic.transportservice.service.UserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Create by zoujunhao on 2019/2/1
 */
@Controller
public class AdminUserController {

    @Resource
    UserService userService;


    @RequestMapping(value = {"/", "/transportservice", "/favicon.ico"})
    public String index(Model model) {
        List<UserInfo> users = userService.getUserList();
        model.addAttribute("users", users);
        return "userManagement";
    }

    @RequestMapping("/transportservice/userlogin")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        System.out.println("AdminUserController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "密码不正确";
            } else {
                msg = "else >> " + exception;
                System.out.println("" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "adminLogin";
    }

    @RequestMapping("/transportservice/userlogout")
    public String logout() {
        return "adminLogin";
    }


    @RequestMapping("/transportservice/modifyingUserRoles")
    public String modifyingUserRoles0(Model model, String userrole, String userName) {
        System.out.println("更改用户角色为:" + userrole + " 用户名称为:" + userName);
        userService.updateUserRole(userrole, userName);
        List<UserInfo> users = userService.getUserList();
        model.addAttribute("users", users);
        return "userManagement";
    }

}
