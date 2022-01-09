package com.edu.ahu.classroom.dto;

import lombok.Data;


@Data
public class PduSettingInfoLogDTO {

    private Integer id;

    private String name;

    /* 设备id(对应base_info表id) */
    private Integer equId;

    /* 各端口开机延时 */
    private Integer ch1OnDelay;

    private Integer ch2OnDelay;

    private Integer ch3OnDelay;

    private Integer ch4OnDelay;

    private Integer ch5OnDelay;

    private Integer ch6OnDelay;

    private Integer ch7OnDelay;

    private Integer ch8OnDelay;

    /* 各个端口关机延时 */
    private Integer ch1OffDelay;

    private Integer ch2OffDelay;

    private Integer ch3OffDelay;

    private Integer ch4OffDelay;

    private Integer ch5OffDelay;

    private Integer ch6OffDelay;

    private Integer ch7OffDelay;

    private Integer ch8OffDelay;

    /* 各个端口重启延时 */
    private Integer ch1RebootDelay;

    private Integer ch2RebootDelay;

    private Integer ch3RebootDelay;

    private Integer ch4RebootDelay;

    private Integer ch5RebootDelay;

    private Integer ch6RebootDelay;

    private Integer ch7RebootDelay;

    private Integer ch8RebootDelay;

    /* 各个端口开机动作*/
    private Integer ch1BootAction;

    private Integer ch2BootAction;

    private Integer ch3BootAction;

    private Integer ch4BootAction;

    private Integer ch5BootAction;

    private Integer ch6BootAction;

    private Integer ch7BootAction;

    private Integer ch8BootAction;

    /* 自动获取ip(0关/1开) */
    private Integer dhcp;

    /* 电压上限 */
    private Float uUpperLimit;

    /* 电流上限 */
    private Float iUpperLimit;

    /* 功率上限 */
    private Float pUpperLimit;

    /* 电压下限 */
    private Float uLowerLimit;

    /* 电流下限 */
    private Float iLowerLimit;

    /* 功率下限 */
    private Float pLowerLimit;

    /* 警告电压 */
    private Float uWarmLimit;

    /* 警告电流 */
    private Float iWarmLimit;

    /* 警告功率 */
    private Float pWarmLimit;

    /* 设置时间 */
    private long updateTimeStamp;

    /* 设置用户名 */
    private String username;

    /* 设置登录密码 */
    private String password;

    /* 电压上限动作 */
    private Integer uUpperAct;

    /* 电流上限动作 */
    private Integer iUpperAct;

    /* 功率上限动作 */
    private Integer pUpperAct;

    /* 设置状态 */
    private String status;

    /* 指令发起时间 */
    private long settingTimeStamp;

    /* 执行者id */
    private Integer userId;

    /* 端口名 */
    private String port1Name;

    private String port2Name;

    private String port3Name;

    private String port4Name;

    private String port5Name;

    private String port6Name;

    private String port7Name;

    private String port8Name;

    /* 端口图标 */
    private Integer icoId1;

    private Integer icoId2;

    private Integer icoId3;

    private Integer icoId4;

    private Integer icoId5;

    private Integer icoId6;

    private Integer icoId7;

    private Integer icoId8;
}
