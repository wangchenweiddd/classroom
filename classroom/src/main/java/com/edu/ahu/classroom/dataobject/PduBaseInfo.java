package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wcw
 * @data 2020/5/31 9:57
 */
@Entity
@Data
@Table(name = "pducontrolinfo")
public class PduBaseInfo {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    private String Ip;

    private String switchIp;

    private String name;

    private String mac;

    private String ch1Name;

    private String ch2Name;

    private String ch3Name;

    private String ch4Name;

    private String ch5Name;

    private String ch6Name;

    private String ch7Name;

    private String ch8Name;

    private Date createTime;

    private Integer buildId;

    private String state;

    private Date lastUpdateTime;

    private Integer modifyState;


}
