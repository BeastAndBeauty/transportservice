package com.traffic.transportservice.controller;

import com.traffic.transportservice.entity.*;
import com.traffic.transportservice.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.traffic.transportservice.entity.RoadLightControlModeInfo.ControlModeType.Anto;
import static com.traffic.transportservice.entity.RoadLightControlModeInfo.ControlModeType.Manual;

/**
 * 初始化数据
 * Create by zoujunhao on 2019/2/17
 */
@RestController
public class InitializedData {


    @Resource
    private UserService userService;
    @Resource
    private CarInfoService carInfoService;
    @Resource
    private ParkingFeeService parkingFeeService;
    @Resource
    private ParkingService parkingService;
    @Resource
    private PeccancyService peccancyService;
    @Resource
    private RoadLightStatusActionService roadLightStatusActionService;
    @Resource
    private RoadLightControlModeInfoService roadLightControlModeInfoService;
    @Resource
    private TrafficLightService trafficLightService;


    @RequestMapping("/transportservice/action/InitializedData")
    public String save() {
        //用户表
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(new UserInfo(445281200010124322l, "user1", "655412", "张三", "男", 13128377095l));
        userInfos.add(new UserInfo(455281199910104327l, "user2", "632054", "李四", "男", 19546252153l));
        userInfos.add(new UserInfo(445281200109124322l, "user3", "95315", "王五", "女", 11254632515l));
        userInfos.add(new UserInfo(445281200110304322l, "user4", "95333", "赵六", "女", 11652632515l));
        userService.saveAll(userInfos);
        //小车表
        List<CarInfo> carInfos = new ArrayList<>();
        carInfos.add(new CarInfo(1, 100, "Start", 60, "鲁A1001", userInfos.get(0), new Date(), "宝马"));
        carInfos.add(new CarInfo(2, 80, "Stop", 50, "鲁A1002", userInfos.get(0), new Date(), "奔驰"));
        carInfos.add(new CarInfo(3, 100, "Start", 60, "辽A1001", userInfos.get(0), new Date(), "宝马"));
        carInfos.add(new CarInfo(4, 80, "Stop", 50, "辽A1002", userInfos.get(0), new Date(), "奔驰"));
        carInfos.add(new CarInfo(5, 120, "Start", 60, "鲁A1003", userInfos.get(1), new Date(), "大众"));
        carInfos.add(new CarInfo(6, 80, "Stop", 50, "鲁A1004", userInfos.get(1), new Date(), "奥迪"));
        carInfos.add(new CarInfo(7, 100, "Start", 60, "辽A1001", userInfos.get(1), new Date(), "宝马"));
        carInfos.add(new CarInfo(8, 80, "Stop", 50, "辽A1002", userInfos.get(1), new Date(), "奔驰"));
        carInfos.add(new CarInfo(9, 100, "Start", 60, "鲁A1005", userInfos.get(2), new Date(), "宝马"));
        carInfos.add(new CarInfo(10, 90, "Stop", 50, "鲁A1006", userInfos.get(2), new Date(), "丰田"));
        carInfos.add(new CarInfo(11, 100, "Start", 60, "辽A1001", userInfos.get(2), new Date(), "宝马"));
        carInfos.add(new CarInfo(12, 80, "Stop", 50, "辽A1002", userInfos.get(2), new Date(), "奔驰"));
        carInfos.add(new CarInfo(13, 110, "Start", 60, "鲁A1007", userInfos.get(3), new Date(), "宝马"));
        carInfos.add(new CarInfo(14, 80, "Stop", 50, "鲁A1008", userInfos.get(3), new Date(), "奔驰"));
        carInfos.add(new CarInfo(15, 100, "Start", 60, "辽A1001", userInfos.get(3), new Date(), "宝马"));
        carInfos.add(new CarInfo(16, 80, "Stop", 50, "辽A1002", userInfos.get(3), new Date(), "奔驰"));
        carInfoService.saveAll(carInfos);
        //费率表
        ParkingFeeInfo parkingFeeInfo = new ParkingFeeInfo("Count", 120);
        parkingFeeService.save(parkingFeeInfo);
        //停车表
        List<ParkingInfo> parkingInfos = new ArrayList<>();
        parkingInfos.add(new ParkingInfo(1, true));
        parkingInfos.add(new ParkingInfo(2, false));
        parkingInfos.add(new ParkingInfo(3, true));
        parkingInfos.add(new ParkingInfo(4, false));
        parkingService.saveAll(parkingInfos);
        //违章表
        List<PeccancyInfo> peccancyInfos = new ArrayList<>();
        peccancyInfos.add(new PeccancyInfo(1001, "学院路", new Date(), "鲁A1001"));
        peccancyInfos.add(new PeccancyInfo(1002, "医院路", new Date(), "鲁A1002"));
        peccancyInfos.add(new PeccancyInfo(1003, "环城快速路", new Date(), "鲁A1003"));
        peccancyInfos.add(new PeccancyInfo(1004, "联想路", new Date(), "鲁A1004"));
        peccancyService.saveAll(peccancyInfos);
        //路灯信息表
        List<RoadLightStatusActionInfo> roadLightStatusActionInfos = new ArrayList<>();
        roadLightStatusActionInfos.add(new RoadLightStatusActionInfo(1, RoadLightStatusActionInfo.ActionType.Open));
        roadLightStatusActionInfos.add(new RoadLightStatusActionInfo(2, RoadLightStatusActionInfo.ActionType.Close));
        roadLightStatusActionInfos.add(new RoadLightStatusActionInfo(3, RoadLightStatusActionInfo.ActionType.Open));
        roadLightStatusActionService.saveAll(roadLightStatusActionInfos);
        //路灯控制模式（自动/手工）
        List<RoadLightControlModeInfo> roadLightControlModeInfos = new ArrayList<>();
        roadLightControlModeInfos.add(new RoadLightControlModeInfo(1, Anto));
        roadLightControlModeInfos.add(new RoadLightControlModeInfo(2, Anto));
        roadLightControlModeInfos.add(new RoadLightControlModeInfo(3, Manual));
        roadLightControlModeInfoService.saveAll(roadLightControlModeInfos);
        //交通灯表
        List<TrafficLightInfo> trafficLightInfos = new ArrayList<>();
        trafficLightInfos.add(new TrafficLightInfo(1, 10, 15, 5));
        trafficLightInfos.add(new TrafficLightInfo(2, 8, 12, 6));
        trafficLightInfos.add(new TrafficLightInfo(3, 6, 11, 7));
        trafficLightInfos.add(new TrafficLightInfo(4, 9, 8, 9));
        trafficLightInfos.add(new TrafficLightInfo(5, 10, 15, 5));
        trafficLightInfos.add(new TrafficLightInfo(6, 8, 12, 6));
        trafficLightInfos.add(new TrafficLightInfo(7, 6, 11, 7));
        trafficLightInfos.add(new TrafficLightInfo(8, 9, 8, 9));
        trafficLightInfos.add(new TrafficLightInfo(9, 10, 15, 5));
        trafficLightInfos.add(new TrafficLightInfo(10, 8, 12, 6));
        trafficLightInfos.add(new TrafficLightInfo(11, 6, 11, 7));
        trafficLightInfos.add(new TrafficLightInfo(12, 9, 8, 9));
        trafficLightInfos.add(new TrafficLightInfo(13, 8, 12, 6));
        trafficLightInfos.add(new TrafficLightInfo(14, 6, 11, 7));
        trafficLightInfos.add(new TrafficLightInfo(15, 9, 8, 9));
        trafficLightService.saveAll(trafficLightInfos);
        return "保存成功";
    }
}
