package com.traffic.transportservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrafficLightInfo {
    @Id
    private int trafficlightid;//红绿灯id

    @Column(nullable = false)
    private int redtime ;//红灯时长

    @Column(nullable = false)
    private int greentime  ;//绿灯时长

    @Column(nullable = false)
    private int yellowtime   ;//黄灯时长

    public TrafficLightInfo() {
    }

    public TrafficLightInfo(int trafficlightid, int redtime, int greentime, int yellowtime) {
        this.trafficlightid = trafficlightid;
        this.redtime = redtime;
        this.greentime = greentime;
        this.yellowtime = yellowtime;
    }

    public int getTrafficlightid() {
        return trafficlightid;
    }

    public void setTrafficlightid(int trafficlightid) {
        this.trafficlightid = trafficlightid;
    }

    public int getRedtime() {
        return redtime;
    }

    public void setRedtime(int redtime) {
        this.redtime = redtime;
    }

    public int getGreentime() {
        return greentime;
    }

    public void setGreentime(int greentime) {
        this.greentime = greentime;
    }

    public int getYellowtime() {
        return yellowtime;
    }

    public void setYellowtime(int yellowtime) {
        this.yellowtime = yellowtime;
    }
}
