package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 19:29 2018/5/28
 */
@Data
@Entity
@Table(name = "pdu_control_info")
public class PduControlInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "equ_id")
    private Integer equId;

    /* 端口 */
    @Column(name = "port1")
    private Integer port1;

    @Column(name = "port2")
    private Integer port2;

    @Column(name = "port3")
    private Integer port3;

    @Column(name = "port4")
    private Integer port4;

    @Column(name = "port5")
    private Integer port5;

    @Column(name = "port6")
    private Integer port6;

    @Column(name = "port7")
    private Integer port7;

    @Column(name = "port8")
    private Integer port8;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "setting_time")
    private Date settingTime;

    @Column(name = "status")
    private Integer status;
}
