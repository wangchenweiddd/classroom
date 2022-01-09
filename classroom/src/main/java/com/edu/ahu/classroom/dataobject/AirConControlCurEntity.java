package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wcw
 * @data 2020/5/26 20:09
 */

@Data
@Entity
@Table(name = "airconcontrolcur")
public class AirConControlCurEntity {
    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;             //控制编号

    @Column(name="operateid")
    private Integer operateId;      //操作编号

    @Column(name="randomid")
    private String randomId;          //随机标识

    @Column(name="deviceid")
    private Integer deviceId;       //空调id

    @Column(name="temp")
    private Integer temp;           //设置温度

    @Column(name="aoc")
    private String aoc;             //开关设置

    @Column(name="wind")
    private String wind;            //风速设置

    @Column(name="model")
    private String model;           //模式设置

    @Column(name="eleclock")
    private String elecLock;        //电子锁设置

    @Column(name="status")
    private String status;          //执行状态

    @Column(name="createtime")
    private Date createTime;        //创建时间

    @Column(name="updatetime")
    private Date updateTime;        //更新时间
}
