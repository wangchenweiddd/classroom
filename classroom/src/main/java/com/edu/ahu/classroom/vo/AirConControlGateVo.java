package com.edu.ahu.classroom.vo;

import lombok.Data;

/**
 * @Author: HDC
 * @Description:提交给网关的空调控制数据
 * @Date: Created in 11:21 2018/11/14
 */
@Data
public class AirConControlGateVo {

    private String randomId;          //控制唯一标示码

    private Integer deviceId;       //空调id

    private String atemp;          //设置温度

    private String aoc;             //开关设置

    private String dwind;           //风速设置

    private String fmodel;          //模式设置

    private String helec;           //电子锁设置

}
