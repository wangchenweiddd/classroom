package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;


/**
 * @author wcw
 * @data 2020/6/9 19:19
 */
@Entity
@Data
@Table(name = "buildinfo")
public class BuildInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* 父级id */
    @Column(name = "buildgroupid")
    private Integer pid;

    /* 建筑名 */
    @Column(name = "buildname")
    private String name;

    /* 建筑描述 */
    @Column(name = "builddesc")
    private String desc;

    /* 建筑状态 */
    @Column(name = "state")
    private String state;

    @Transient
    public String getType(){
        return "build";
    }
}
