package com.traffic.transportservice.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * @Description:    路灯信息表
 * @Author:         paopao
 * @CreateDate:     2019/2/13 19:07
 */
@Entity
public class RoadLightStatusActionInfo {
    @Id
    private int RoadLightId;//路灯总共 3 路,其值为 1,2,3。1 代表第 1 路，2 代表第
                            //2 路, 3 代表第 3 路

    @Enumerated(EnumType.STRING)
    private ActionType Action;//路灯关闭（Close）、打开（Open）

    public enum ActionType{
        Close,//关闭
        Open//打开
    }

    public RoadLightStatusActionInfo(int roadLightId, ActionType action) {
        RoadLightId = roadLightId;
        Action = action;
    }

    public RoadLightStatusActionInfo() {
    }

    public int getRoadLightId() {
        return RoadLightId;
    }

    public void setRoadLightId(int roadLightId) {
        RoadLightId = roadLightId;
    }

    public ActionType getAction() {
        return Action;
    }

    public void setAction(ActionType action) {
        Action = action;
    }
}
