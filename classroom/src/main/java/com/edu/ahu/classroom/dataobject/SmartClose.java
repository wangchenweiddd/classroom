package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wcw
 * @data 2020/5/30 16:04
 */
@Entity
@Data
@Table(name = "smartclose")
public class SmartClose {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String lock;

    private String model;

    private String temp;

    private Integer num;


}
