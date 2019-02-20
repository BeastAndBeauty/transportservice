package com.traffic.transportservice.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Create by zoujunhao on 2019/2/3
 */
public class ResultUtil {


    public static final String SUCCESS_RESULT = "S";
    public static final String ERROR_RESULT = "F";

    public static final String INVALID_WARNING = "无效用户";
    public static final String PERMISSIONS_WARNING = "权限不足";


    public static Map<String, Object> success(String ERRMsG) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("RESULT", SUCCESS_RESULT);
        map.put("ERRMSG", ERRMsG);
        return map;
    }

    public static Map<String, Object> success(String error_mes, String key, String value) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("RESULT", SUCCESS_RESULT);
        map.put("ERRMSG", error_mes);
        map.put(key, value);
        return map;
    }

    public static Map<String, Object> success(String error_mes, String key, int value) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("RESULT", SUCCESS_RESULT);
        map.put("ERRMSG", error_mes);
        map.put(key, value);
        return map;
    }

    public static Map<String, Object> success(String ERRMsG, Object data) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("RESULT", SUCCESS_RESULT);
        map.put("ERRMSG", ERRMsG);
        map.put("ROWS_DETAIL", data);
        return map;
    }

    public static Map<String, String> error() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("RESULT", ERROR_RESULT);
        map.put("ERRMSG", "失败");
        return map;
    }

    public static Map<String, String> error(String ERRMsG) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("RESULT", ERROR_RESULT);
        map.put("ERRMSG", ERRMsG);
        return map;
    }
}
