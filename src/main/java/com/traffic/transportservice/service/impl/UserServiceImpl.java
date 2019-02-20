package com.traffic.transportservice.service.impl;

import com.traffic.transportservice.entity.UserInfo;
import com.traffic.transportservice.repository.UserRepository;
import com.traffic.transportservice.service.UserService;
import com.traffic.transportservice.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Create by zoujunhao on 2019/2/1
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserInfo> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public int updateUserRole(String userRole, String userName) {
        return userRepository.updateUserRole(userRole, userName);
    }

    @Override
    public String selectUserRole(String userName) {
        return userRepository.selectUserRole(userName);
    }

    @Override
    public Boolean isAdminRole(String userName) {
        String userRole = userRepository.selectUserRole(userName);
        if (userRole.equals("R02") || userRole.equals("R03"))
            return true;
        else
            return false;
    }

    @Override
    public Boolean isNullRole(String userName) {
        String userRole = userRepository.selectUserRole(userName);
        if (userRole.equals("R00"))
            return true;
        else
            return false;
    }

    @Override
    public String userLogin(String userName, String passWord) {
        if (userRepository.findByUserName(userName) == null)
            return "用户不存在";
        UserInfo userInfo = userRepository.findByUserNameAndPassWord(userName, passWord);
        if (userInfo != null)
            return userInfo.getUserRole();
        return "密码错误";
    }

    @Override
    public String userRegister(long pcardId, String userName, String passWord, String pname, String psex, long ptel) {
        if (!CheckUtil.isIDCard(pcardId + ""))
            return "身份证格式错误";
        if (!CheckUtil.isMobileNO(ptel + ""))
            return "手机号格式错误";
        switch (psex) {
            case "1":
                psex = "男";
                break;
            case "0":
                psex = "女";
                break;
            default:
                return "性别格式错误";
        }
        if (userRepository.findByPcardId(pcardId) != null)
            return "身份证已被注册";
        if (userRepository.findByUserName(userName) != null)
            return "系统登录用户名重复";
        if (userRepository.findByPtel(ptel) != null)
            return "手机号已被注册";
        if (userRepository.save(new UserInfo(pcardId, userName, passWord, pname, psex, ptel)) != null)
            return "S";
        return "参数无效";
    }

    @Transactional
    @Override
    public void saveAll(List<UserInfo> userInfos) {
        userRepository.saveAll(userInfos);
    }

    @Override
    public Long selectPcardId(String userName) {
        return userRepository.selectPcardId(userName);
    }


}
