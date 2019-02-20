package com.traffic.transportservice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 小车信息表
 * @Author: paopao
 * @CreateDate: 2019/2/13 19:07
 */
@Entity
public class CarInfo {

    @Id
    private int CarId;//小车编号
    @Column(nullable = false)
    private int Balance;//账户余额
    @Column(nullable = false, columnDefinition = "enum('Start','Stop')")
    private String CarAction;//小车启动（start）、停止（stop）
    @Column(nullable = false)
    private int CarSpeed;//小车速度

    @Column(nullable = false)
    private String carnumber;//小车车牌号
    @ManyToOne
    @JoinColumn//外键
    private UserInfo userInfo;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date buydata;//小车购买日期

    @Column(nullable = false)
    private String carbrand;//小车车牌品牌

    public CarInfo() {
    }

    public CarInfo(int carId, int balance, String carAction, int carSpeed, String carnumber, UserInfo userInfo, Date buydata, String carbrand) {
        CarId = carId;
        Balance = balance;
        CarAction = carAction;
        CarSpeed = carSpeed;
        this.carnumber = carnumber;
        this.userInfo = userInfo;
        this.buydata = buydata;
        this.carbrand = carbrand;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        CarId = carId;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public String getCarAction() {
        return CarAction;
    }

    public void setCarAction(String carAction) {
        CarAction = carAction;
    }

    public int getCarSpeed() {
        return CarSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        CarSpeed = carSpeed;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public Date getBuydata() {
        return buydata;
    }

    public void setBuydata(Date buydata) {
        this.buydata = buydata;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }
}
