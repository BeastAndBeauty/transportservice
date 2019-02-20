package com.traffic.transportservice.util;

import java.util.*;

/**
 * @Description: 获取随机值
 * @Author: paopao
 * @CreateDate: 2019/2/13 19:07
 */
public class RandomUtil {

    public static Map<String, Object> randomGetWeather() {
        int WCurrent = randomNumber(8, 25);//当前温度
        Map<String, Object> map = new LinkedHashMap<>();
        map.putAll(ResultUtil.success("成功"));
        map.put("WCurrent", WCurrent);
        List<Map<String, String>> list = new ArrayList();
        for (int i = -1; i < 5; i++) {
            Map<String, String> ROWS_DETAIL = new LinkedHashMap<>();
            ROWS_DETAIL.put("WData", DateUtil.getTime(i));
            ROWS_DETAIL.put("temperature", randomNumber(WCurrent - 10, WCurrent) + "~" + randomNumber(WCurrent + 5, WCurrent + 10));
            list.add(ROWS_DETAIL);
        }
        map.put("ROWS_DETAIL", list);
        return map;
    }

    public static Map<String, Object> randomAllSense() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.putAll(ResultUtil.success("成功"));
        map.put("pm2.5", randomNumber(0, 400));
        map.put("co2", randomNumber(350, 5000));
        map.put("lightIntensity", randomNumber(0, 5000));
        map.put("humidity", randomNumber(10, 50));
        map.put("temperature", randomNumber(8, 40));
        return map;
    }

    /**
     * 指定传感器的值
     *
     * @param SenseName 传感器名
     * @return
     */
    public static Map<String, Object> randomSenseByName(String SenseName) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.putAll(ResultUtil.success("成功"));
        switch (SenseName) {
            case "pm2.5":
                map.put("pm2.5", randomNumber(0, 400));
                break;
            case "co2":
                map.put("co2", randomNumber(350, 5000));
                break;
            case "lightIntensity":
                map.put("lightIntensity", randomNumber(0, 5000));
                break;
            case "humidity":
                map.put("humidity", randomNumber(10, 50));
                break;
            case "temperature":
                map.put("temperature", randomNumber(8, 40));
                break;
        }
        return map;
    }

    private static int randomNumber(int MIN, int MAX) {
        Random rand = new Random();
        return rand.nextInt(MAX - MIN + 1) + MIN;
    }

    private static String randomString(String[] strs) {
        Random rand = new Random();
        return strs[rand.nextInt(strs.length)];
    }
}
