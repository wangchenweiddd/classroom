package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "pdu_port_cur")
public class PduPortCurEntity {

    @Id
    @Column(name = "equ_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    /* 更新时间 */
    @Column(name = "update_time")
    private Date updateTime;
}
