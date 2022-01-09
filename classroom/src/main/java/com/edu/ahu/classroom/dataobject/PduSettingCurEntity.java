package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "pdu_setting_cur")
public class PduSettingCurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /* 端口名 */
    @Column(name = "name1")
    private String port1Name;

    @Column(name = "name2")
    private String port2Name;

    @Column(name = "name3")
    private String port3Name;

    @Column(name = "name4")
    private String port4Name;

    @Column(name = "name5")
    private String port5Name;

    @Column(name = "name6")
    private String port6Name;

    @Column(name = "name7")
    private String port7Name;

    @Column(name = "name8")
    private String port8Name;
}
