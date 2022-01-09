package com.edu.ahu.classroom.dto;

import lombok.Data;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 15:23 2018/6/13
 */
@Data
public class PduWarmInfoDTO {

    private Integer id;

    private String name;

    private Integer equId;

    /* 电压警告信息 */
    private String uWarmLog;

    /* 电流警告信息 */
    private String iWarmLog;

    /* 功率警告信息 */
    private String pWarmLog;

    /* 更新时间 */
    private long updateTimeStamp;
}
