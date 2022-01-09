package com.edu.ahu.classroom.Json;

import lombok.Data;

import java.util.List;

/**
 * @author wcw
 * @data 2020/6/10 16:09
 * Controller层使用Json
 */

@Data
public class ControllerUserJson {
    private String type;
    private Integer id;//tree所用字段

    private Integer equId;
    private Integer port;
    private Integer mark;//switch所用字段

    private Integer check;

    List<Integer> equIds;
    List<Integer> marks;

    private Integer pageNumber;
    private Integer pageSize;

    private Integer userId;

    private String select;

    private String name;
    private String password;
}
