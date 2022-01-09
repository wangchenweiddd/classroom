package com.edu.ahu.classroom.dto;

import lombok.Data;

import java.util.Date;


@Data
public class PduPortCurDTO {

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

    /* 更新时间 */
    private Date updateTime;

    private Integer status;
}
