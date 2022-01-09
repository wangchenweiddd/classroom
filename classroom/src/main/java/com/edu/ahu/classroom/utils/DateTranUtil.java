package com.edu.ahu.classroom.utils;

import java.util.Date;

/**
 * @author wcw
 * @data 2020/6/9 21:03
 */
public class DateTranUtil {

    public static long dateToStamp(Date date) {
        long ts = date.getTime();
        return ts;
    }
}
