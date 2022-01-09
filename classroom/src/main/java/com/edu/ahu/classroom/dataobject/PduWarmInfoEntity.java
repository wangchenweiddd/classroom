package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wcw
 * @data 2020/6/9 20:13
 */
@Data
@Entity
@Table(name = "pdu_warm_info")
public class     PduWarmInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "equ_id")
    private Integer equId;

    /* 电压警告信息 */
    @Column(name = "u_warm_log")
    private String uWarmLog;

    /* 电流警告信息 */
    @Column(name = "i_warm_log")
    private String iWarmLog;

    /* 功率警告信息 */
    @Column(name = "p_warm_log")
    private String pWarmLog;

    /* 更新时间 */
    @Column(name = "update_time")
    private Date updateTime;
}
