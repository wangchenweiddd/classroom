package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wcw
 * @data 2020/6/9 19:19
 */
@Entity
@Data
@Table(name = "campusinfo")
public class CampusInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* 校区名 */
    @Column(name = "campusname")
    private String name;

    /* 校区描述 */
    @Column(name = "campusdesc")
    private String desc;

    /* 校区状态 */
    @Column(name = "state")
    private String state;

    @Transient
    public String getType(){
        return "campus";
    }
}