package com.edu.ahu.classroom.vo;

import lombok.Data;

/**
 * @author wcw
 * @data 2020/5/28 9:42
 */
@Data
public class ClassMessageVo {
    private Integer roomId;

    private String regionCode;

    private String regionFullName;

    private Integer numCount;

    private Integer eTemp;

    private String aoc;

    private String lightFront;

    private String lightBehind;

}
