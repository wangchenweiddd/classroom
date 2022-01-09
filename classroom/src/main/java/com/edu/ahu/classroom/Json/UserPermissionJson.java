package com.edu.ahu.classroom.Json;

import com.edu.ahu.classroom.dataobject.UserPermission;
import lombok.Data;

import java.util.Date;

/**
 * @author wcw
 * @data 2020/5/30 21:35
 */
@Data
public class UserPermissionJson {
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

    /**
     * 新增管理员
     * @return
     */
    public UserPermission add(){
        UserPermission userPermission=new UserPermission();
        userPermission.setUserName(getUserName());
        userPermission.setArea(getArea());
        userPermission.setOpenTime(getOpenTime());
        userPermission.setEndTime(getEndTime());
        userPermission.setLowTemp(getLowTemp());
        userPermission.setHighTemp(getHighTemp());
        userPermission.setAoc(getAoc());
        userPermission.setModel(getModel());
        userPermission.setElec(getElec());
        userPermission.setStatus(1);
        userPermission.setPassword(getPassword());
        return userPermission;
    }
}
