package com.edu.ahu.classroom.dataobject;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
/**
 * @author wcw
 * @data 2020/5/26 20:59
 */

@Data
@Entity
@Table(name = "useroperate")
public class UserOperateEntity {

    @Id
    @Column(name="id",nullable = false,unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;         //用户操作id

    @Column(name="type")
    private String type;        //类型

    @Column(name="userid")
    private Integer userId;     //用户id

    @Column(name="createtime")
    private Date createTime;    //创建时间

    @Column(name="description")
    private String description; //描述

    @Column(name="property")
    private String property;    //属性
}
