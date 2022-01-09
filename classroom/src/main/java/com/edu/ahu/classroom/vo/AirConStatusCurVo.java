package com.edu.ahu.classroom.vo;

import lombok.Data;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 16:52 2018/11/8
 */
@Data
public class AirConStatusCurVo {

    private Integer deviceId;       //空调Id

    private Integer temp;           //设置温度

    private String aoc;             //开关设置

    private String wind;            //风速设置

    private String mode;            //模式设置

    private String elec;            //电子锁设置

    private Integer roomId ;        //房间Id

    private String fullName;        //设备全称

    private Integer openSumTime;    //开机统计时间

    private Integer openTime;       //当前开机时间
}
