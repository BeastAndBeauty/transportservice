package com.traffic.transportservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by zoujunhao on 2019/2/1
 */
@Entity
public class UserInfo {

    @Id
    private long pcardId;//小车车主身份证

    @Column(nullable = false, unique = true)
    private String userName;//小车车主系统登录用户名

    @Column(nullable = false)
    @JsonIgnore
    private String passWord;//小车车主系统登录口令

    @Column(nullable = false)
    private String pname;//小车车主姓名

    @Column(nullable = false, columnDefinition = "enum('男','女')")
    private String psex;//小车车主性别

    @Column(nullable = false, unique = true)
    private long ptel;//小车车主电话

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pregistDate;//系统注册日期

    @Column(nullable = false, columnDefinition = "enum('R00','R01','R02','R03')")
    @JsonIgnore
    private String userRole;//用户角色 R00:无效用户 R01:普通用户 R02：一般管理员 R03：超级管理员

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userInfo")
    private Set<CarInfo> carInfoSet = new HashSet<CarInfo>();

    public UserInfo(long pcardId, String userName, String passWord, String pname, String psex, long ptel) {
        this.pcardId = pcardId;
        this.userName = userName;
        this.passWord = passWord;
        this.pname = pname;
        this.psex = psex;
        this.ptel = ptel;
        this.userRole = "R01";
        this.pregistDate = new Date();
    }

    public UserInfo() {
    }

    public long getPcardId() {
        return pcardId;
    }

    public void setPcardId(long pcardId) {
        this.pcardId = pcardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex;
    }

    public long getPtel() {
        return ptel;
    }

    public void setPtel(long ptel) {
        this.ptel = ptel;
    }

    public Date getPregistDate() {
        return pregistDate;
    }

    public void setPregistDate(Date pregistDate) {
        this.pregistDate = pregistDate;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
