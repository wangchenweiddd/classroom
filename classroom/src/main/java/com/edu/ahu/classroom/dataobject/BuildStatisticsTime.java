package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wcw
 * @data 2020/6/13 16:56
 */
@Entity
@Data
@Table(name = "buildstatisticstime")
public class BuildStatisticsTime {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String fullName;

    private String UseTime;

    private Integer count;

    private Integer opend;

    private Integer closed;

    private Integer offline;
}
