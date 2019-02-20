package com.traffic.transportservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 停车场子系统空闲车位
 * Create by zoujunhao on 2019/2/17
 */
@Entity
public class ParkingInfo {
    @Id
    private int ParkFreeId;//空闲车位编号
    @Column(nullable = false)
    @JsonIgnore
    private Boolean idleMode;//空闲状态(是或否)

    public ParkingInfo() {
    }

    public ParkingInfo(int parkFreeId, Boolean idleMode) {
        ParkFreeId = parkFreeId;
        this.idleMode = idleMode;
    }

    public int getParkFreeId() {
        return ParkFreeId;
    }

    public void setParkFreeId(int parkFreeId) {
        ParkFreeId = parkFreeId;
    }

    public Boolean getIdleMode() {
        return idleMode;
    }

    public void setIdleMode(Boolean idleMode) {
        this.idleMode = idleMode;
    }
}
