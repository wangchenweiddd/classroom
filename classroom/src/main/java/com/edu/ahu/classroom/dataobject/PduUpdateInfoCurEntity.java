package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 16:48 2018/5/21
 */
@Entity
@Data
@Table(name = "pdu_update_info_cur")
public class PduUpdateInfoCurEntity {

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
