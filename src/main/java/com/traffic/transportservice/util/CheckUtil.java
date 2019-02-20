package com.traffic.transportservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by zoujunhao on 2019/2/3
 */
public class CheckUtil {

    /**
     * 判断字符串是否为非负整数
     *
     * @param str
     * @return
     */
    public static boolean isPositionInteger(String str) {
        Matcher matcher = Pattern.compile("^[+]?[0-9]+$").matcher(str);
        return matcher.find();
    }

    /**
     * 验证手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");
            Matcher m = regex.matcher(mobiles);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }


}
