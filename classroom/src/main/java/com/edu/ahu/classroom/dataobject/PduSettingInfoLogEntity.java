package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "pdu_setting_info_log")
public class PduSettingInfoLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* 设备id(对应base_info表id) */
    @Column(name = "equ_id")
    private Integer equId;

    /* 各端口开机延时 */
    @Column(name = "ch1_on_delay")
    private Integer ch1OnDelay;

    @Column(name = "ch2_on_delay")
    private Integer ch2OnDelay;

    @Column(name = "ch3_on_delay")
    private Integer ch3OnDelay;

    @Column(name = "ch4_on_delay")
    private Integer ch4OnDelay;

    @Column(name = "ch5_on_delay")
    private Integer ch5OnDelay;

    @Column(name = "ch6_on_delay")
    private Integer ch6OnDelay;

    @Column(name = "ch7_on_delay")
    private Integer ch7OnDelay;

    @Column(name = "ch8_on_delay")
    private Integer ch8OnDelay;

    /* 各个端口关机延时 */
    @Column(name = "ch1_off_delay")
    private Integer ch1OffDelay;

    @Column(name = "ch2_off_delay")
    private Integer ch2OffDelay;

    @Column(name = "ch3_off_delay")
    private Integer ch3OffDelay;

    @Column(name = "ch4_off_delay")
    private Integer ch4OffDelay;

    @Column(name = "ch5_off_delay")
    private Integer ch5OffDelay;

    @Column(name = "ch6_off_delay")
    private Integer ch6OffDelay;

    @Column(name = "ch7_off_delay")
    private Integer ch7OffDelay;

    @Column(name = "ch8_off_delay")
    private Integer ch8OffDelay;

    /* 各个端口重启延时 */
    @Column(name = "ch1_reboot_delay")
    private Integer ch1RebootDelay;

    @Column(name = "ch2_reboot_delay")
    private Integer ch2RebootDelay;

    @Column(name = "ch3_reboot_delay")
    private Integer ch3RebootDelay;

    @Column(name = "ch4_reboot_delay")
    private Integer ch4RebootDelay;

    @Column(name = "ch5_reboot_delay")
    private Integer ch5RebootDelay;

    @Column(name = "ch6_reboot_delay")
    private Integer ch6RebootDelay;

    @Column(name = "ch7_reboot_delay")
    private Integer ch7RebootDelay;

    @Column(name = "ch8_reboot_delay")
    private Integer ch8RebootDelay;

    /* 各个端口开机动作*/
    @Column(name = "ch1_boot_action")
    private Integer ch1BootAction;

    @Column(name = "ch2_boot_action")
    private Integer ch2BootAction;

    @Column(name = "ch3_boot_action")
    private Integer ch3BootAction;

    @Column(name = "ch4_boot_action")
    private Integer ch4BootAction;

    @Column(name = "ch5_boot_action")
    private Integer ch5BootAction;

    @Column(name = "ch6_boot_action")
    private Integer ch6BootAction;

    @Column(name = "ch7_boot_action")
    private Integer ch7BootAction;

    @Column(name = "ch8_boot_action")
    private Integer ch8BootAction;

    /* 自动获取ip(0关/1开) */
    @Column(name = "dhcp")
    private Integer dhcp;

    /* 电压上限 */
    @Column(name = "u_upper_limit")
    private Float uUpperLimit;

    /* 电流上限 */
    @Column(name = "i_upper_limit")
    private Float iUpperLimit;

    /* 功率上限 */
    @Column(name = "p_upper_limit")
    private Float pUpperLimit;

    /* 电压下限 */
    @Column(name = "u_lower_limit")
    private Float uLowerLimit;

    /* 电流下限 */
    @Column(name = "i_lower_limit")
    private Float iLowerLimit;

    /* 功率下限 */
    @Column(name = "p_lower_limit")
    private Float pLowerLimit;

    /* 警告电压 */
    @Column(name = "u_warm_limit")
    private Float uWarmLimit;

    /* 警告电流 */
    @Column(name = "i_warm_limit")
    private Float iWarmLimit;

    /* 警告功率 */
    @Column(name = "p_warm_limit")
    private Float pWarmLimit;

    /* 设置时间 */
    @Column(name = "update_time")
    private Date updateTime;

    /* 设置用户名 */
    @Column(name = "user_name")
    private String username;

    /* 设置登录密码 */
    @Column(name = "password")
    private String password;

    /* 电压上限动作 */
    @Column(name = "u_upper_act")
    private Integer uUpperAct;

    /* 电流上限动作 */
    @Column(name = "i_upper_act")
    private Integer iUpperAct;

    /* 功率上限动作 */
    @Column(name = "p_upper_act")
    private Integer pUpperAct;

    /* 设置状态 */
    @Column(name = "status")
    private String status;

    /* 指令发起时间 */
    @Column(name = "settingtime")
    private Date settingTime;

    /* 执行者id */
    @Column(name = "userid")
    private Integer userId;

    /* 端口名 */
    @Column(name = "port1_name")
    private String port1Name;

    @Column(name = "port2_name")
    private String port2Name;

    @Column(name = "port3_name")
    private String port3Name;

    @Column(name = "port4_name")
    private String port4Name;

    @Column(name = "port5_name")
    private String port5Name;

    @Column(name = "port6_name")
    private String port6Name;

    @Column(name = "port7_name")
    private String port7Name;

    @Column(name = "port8_name")
    private String port8Name;

    /* 端口图标 */
    @Column(name = "icoid1")
    private Integer icoId1;

    @Column(name = "icoid2")
    private Integer icoId2;

    @Column(name = "icoid3")
    private Integer icoId3;

    @Column(name = "icoid4")
    private Integer icoId4;

    @Column(name = "icoid5")
    private Integer icoId5;

    @Column(name = "icoid6")
    private Integer icoId6;

    @Column(name = "icoid7")
    private Integer icoId7;

    @Column(name = "icoid8")
    private Integer icoId8;
}
