package com.traffic.transportservice.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * @Description:    路灯控制模式（自动/手工）
 * @Author:         paopao
 * @CreateDate:     2019/2/13 19:07
 */

@Entity
public class RoadLightControlModeInfo {

    @Id
    private int Id;
    @Enumerated(EnumType.STRING)
    private ControlModeType ControlMode;//自动/手工控制模式

    public static enum ControlModeType{
        Anto,//自动模式
        Manual//手动模式
    }

    public RoadLightControlModeInfo() {
    }

    public RoadLightControlModeInfo(int id, ControlModeType controlMode) {
        Id = id;
        ControlMode = controlMode;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ControlModeType getControlMode() {
        return ControlMode;
    }

    public void setControlMode(ControlModeType controlMode) {
        ControlMode = controlMode;
    }
}
