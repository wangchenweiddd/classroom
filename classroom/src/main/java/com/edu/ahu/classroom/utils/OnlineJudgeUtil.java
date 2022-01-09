package com.edu.ahu.classroom.utils;

import java.util.Date;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 18:08 2018/6/4
 */
public class OnlineJudgeUtil {

    public static Integer isOnline(Date time){

        Date date = new Date();

        Long minutes=(date.getTime()-time.getTime())/(1000*60);

        if (minutes > Long.parseLong("60"))
            return 0;

            return 1;
    }
}
