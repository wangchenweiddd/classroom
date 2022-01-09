package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;


/**
 * @author wcw
 * @data 2020/6/9 19:19
 */
@Entity
@Data
@Table(name = "buildgroupinfo")
public class BuildGroupInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* 父级id */
    @Column(name = "campusid")
    private Integer pid;

    /* 建筑群名称 */
    @Column(name = "buildgroupname")
    private String name;

    /* 建筑群描述 */
    @Column(name = "buildgroupdesc")
    private String desc;

    /* 建筑状态 */
    @Column(name = "state")
    private String state;

    @Transient
    public String getType(){
        return "group";
    }
}
