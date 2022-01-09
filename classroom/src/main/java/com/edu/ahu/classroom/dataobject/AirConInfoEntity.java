package com.edu.ahu.classroom.dataobject;
import lombok.Data;

import javax.persistence.*;
/**
 * @author wcw
 * @data 2020/5/26 20:11
 */
@Data
@Entity
@Table(name = "airconinfo")
public class AirConInfoEntity {

    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;             //设备id

    @Column(name="address")
    private Integer address;        //设备地址

    @Column(name="gatewayid")
    private Integer gatewayId;      //网关id

    @Column(name="gatewayport")
    private Integer gatewayPort;    //网关串口

    @Column(name="roomid")
    private Integer roomId;         //房间id

    @Column(name="name")
    private String name;            //设备名称

    @Column(name="fullname")
    private String fullName;        //设备全称
}
