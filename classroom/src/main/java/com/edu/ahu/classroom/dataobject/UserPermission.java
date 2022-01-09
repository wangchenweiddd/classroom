package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wcw
 * @data 2020/5/30 21:12
 */

@Data
@Entity
@Table(name = "userpermission")
public class UserPermission {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;         //用户id

    private String userName;

    private String area;

    private Date openTime;

    private Date endTime;

    private String lowTemp;

    private String highTemp;

    private String aoc;

    private String model;

    private String elec;

    private Integer status;

    private String password;


}
