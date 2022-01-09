package com.edu.ahu.classroom.vo;

import lombok.Data;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 19:09 2018/11/27
 */

@Data
public class UserOperateVo {

    private Integer id;         //用户操作id

    private String type;        //类型

    private Integer userId;     //用户id

    private String createTimeStr;    //创建时间

    private String description; //描述

    private String property;    //属性



}
