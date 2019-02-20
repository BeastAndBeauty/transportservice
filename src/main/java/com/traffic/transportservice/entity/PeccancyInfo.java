package com.traffic.transportservice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 违章表
 * Create by zoujunhao on 2019/2/16
 */

@Entity
public class PeccancyInfo {

    @Id
    private int pcode;//违章代码


    @Column(nullable = false)
    private String paddr;//地址

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datetime;//违章日期

    @Column(nullable = false)
    private String carnumber;

    public PeccancyInfo() {
    }

    public PeccancyInfo(int pcode, String paddr, Date datetime, String carnumber) {
        this.pcode = pcode;
        this.paddr = paddr;
        this.datetime = datetime;
        this.carnumber = carnumber;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPaddr() {
        return paddr;
    }

    public void setPaddr(String paddr) {
        this.paddr = paddr;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }
}
