package com.traffic.transportservice.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Create by zoujunhao on 2019/2/16
 */
public class DateUtil {
    private static Date d = new Date();
    private static GregorianCalendar gc = new GregorianCalendar();
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param day_add_subtract -1为天减1 +1为天加1
     * @return
     */
    public static String getTime(int day_add_subtract) {
        gc.setTime(d);
        gc.add(5, day_add_subtract);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
        return sf.format(gc.getTime());
    }


    public static String getTime() {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }
}
