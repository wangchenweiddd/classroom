package com.edu.ahu.classroom.dataobject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
/**
 * @author wcw
 * @data 2020/5/26 20:14
 */

@Data
@Entity
@Table(name = "authairconcontrol")
public class AuthAirConControlEntity {

    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;                       //主键id

    @Column(name="defaulttemp")
    private Integer defaultTemp;              //默认温度

    @Column(name="defaultmode")
    private String defaultMode;               //默认模式

    @Column(name="defaulteleclock")
    private String defaultElecLock;           //默认电子锁

    @Column(name="defaultaoc")
    private String defaultAoc;                //默认开关机

    @Column(name="aoc")
    private String aoc;                       //开机、关机（List）

    @Column(name="starttime")
    private Date startTime;                   //开始时间

    @Column(name = "endtime")
    private Date endTime;                     //结束时间

    @Column(name="mintemp")
    private Integer minTemp;                  //最小温度

    @Column(name="maxtemp")
    private Integer maxTemp;                  //最大温度

    @Column(name="mode")
    private String mode;                      //除湿、自动、制冷、制热、送风（List）

    @Column(name="eleclock")
    private String elecLock;                  //有效、无效（List）

    @Column(name="userid")
    private Integer userId;                   //用户id

    @Transient
    public void setAocList(List<String> aocList) {
        this.aoc = JSON.toJSONString(aocList);
    }
    @Transient
    public List<String> getAocList() {
        return JSONObject.parseArray(aoc,String.class);
    }
    @Transient
    public void setModeList(List<String> modeList) {
        this.mode = JSON.toJSONString(modeList);
    }
    @Transient
    public List<String> getModeList() {
        return JSONObject.parseArray(mode,String.class);
    }
    @Transient
    public void setElecLockList(List<String> elecLockList) {
        this.elecLock = JSON.toJSONString(elecLockList);
    }
    @Transient
    public List<String> getElecLockList() {
        return JSONObject.parseArray(elecLock,String.class);
    }
}
