package com.edu.ahu.classroom.dataobject;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wcw
 * @data 2020/5/26 20:58
 */

@Data
@Entity
@Table(name = "userinfo")
public class UserInfoEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;         //用户id

    @Column(name="password")
    private String password;    //用户密码

    @Column(name="name")
    private String name;        //用户名

    @Column(name = "username")
    private String userName;

    @Column(name = "status")
    private String status;

    @Column(name = "lock")
    private Integer lock;

    @Column(name = "lock_time")
    private Date lockTime;
}
