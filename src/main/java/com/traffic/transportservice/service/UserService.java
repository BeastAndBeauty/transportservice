package com.traffic.transportservice.service;

import com.traffic.transportservice.entity.UserInfo;

import java.util.Date;
import java.util.List;

/**
 * Create by zoujunhao on 2019/2/1
 */
public interface UserService {
    List<UserInfo> getUserList();

    UserInfo getUser(String userName);

    /**
     * 更新用户角色
     *
     * @param userRole
     * @param userName
     * @return
     */
    int updateUserRole(String userRole, String userName);

    String selectUserRole(String userName);

    /**
     * 判断是否为管理员角色
     *
     * @param userName
     * @return
     */
    Boolean isAdminRole(String userName);

    Boolean isNullRole(String userName);

    String userLogin(String userName, String passWord);

    String userRegister(long pcardId, String userName, String passWord, String pname, String psex, long ptel);
    void saveAll(List<UserInfo> userInfoList);

    Long selectPcardId(String userName);

}
