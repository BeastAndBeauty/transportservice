package com.traffic.transportservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 停车费率
 * Create by zoujunhao on 2019/2/17
 */
@Entity
public class ParkingFeeInfo {
    @Id
    @Column(nullable = false, columnDefinition = "enum('Hour','Count')")//Hour:按小时计费 Count：按次计费
    private String RateType;//费率类型


    @Column(nullable = false)
    private double Money;//金额

    public ParkingFeeInfo() {
    }

    public ParkingFeeInfo(String rateType, double money) {
        RateType = rateType;
        Money = money;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public String getRateType() {
        return RateType;
    }

    public void setRateType(String rateType) {
        RateType = rateType;
    }
}
