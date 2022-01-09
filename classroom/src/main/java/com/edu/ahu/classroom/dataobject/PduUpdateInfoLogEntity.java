package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "pdu_update_info_log")
public class PduUpdateInfoLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* 设备id (对应base_info表id) */
    @Column(name = "equ_id")
    private Integer equId;

    /* 功率 */
    @Column(name = "p")
    private Float p;

    /* 电压 */
    @Column(name = "u")
    private Float u;

    /* 电流 */
    @Column(name = "i")
    private Float i;

    /* 上传时间 */
    @Column(name = "update_time")
    private Date updateTime;
}
