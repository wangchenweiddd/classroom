package com.edu.ahu.classroom.dto;

import lombok.Data;


@Data
public class PduControlInfoLogDTO {

    private Integer id;

    private String name;

    /* 对应pdu的id */
    private Integer equId;

    /* 端口 */
    private Integer port1;

    private Integer port2;

    private Integer port3;

    private Integer port4;

    private Integer port5;

    private Integer port6;

    private Integer port7;

    private Integer port8;

    private Integer userId;

    /* 设置时间 */
    private long settingTimeStamp;

    /* 状态 */
    private Integer status;

    /* 控制时间 */
    private long controlTimeStamp;
}
