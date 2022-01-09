package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wcw
 * @data 2020/5/28 9:02
 */
@Entity
@Data
@Table(name = "numbercount")
public class NumberCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String RegionCode;

    private Integer NumCount;

    private String RegionFullName;

    private Date updateTime;

    private Integer deviceId;

    private String regionType;

    private String lightOne;

    private String lightTwo;

    private Integer pduId;
}
