package com.edu.ahu.classroom.dataobject;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
/**
 * @author wcw
 * @data 2020/5/26 20:13
 */
@Data
@Entity
@Table(name = "airconstatuscur")
public class AirConStatusCurEntity {

    @Id
    @GeneratedValue(generator = "paymentTableGenerator")
    @GenericGenerator(name = "paymentTableGenerator", strategy = "assigned")
    @Column(name = "deviceid",nullable=false,unique=true,updatable=false)
    private Integer deviceId;             //设备id

    @Column(name = "aoc")
    private String aoc;                   //开关机状态

    @Column(name = "temp")
    private Integer temp;                 //温度

    @Column(name = "wind")
    private String wind;                  //风速

    @Column(name = "model")
    private String model;                 //模式

    @Column(name = "eleclock")
    private String elecLock;              //电子锁

    @Column(name = "envtemp")
    private Integer envTemp;              //环境温度

    @Column(name = "errormsg")
    private String errorMsg;              //错误信息

    @Column(name = "updatetime")
    private Date updateTime;              //更新时间

    @Column(name = "aoctime")
    private Date aocTime;                 //开关转换时间

    @Column(name = "opensumtime")
    private Integer openSumTime;          //开机累计时间
}
