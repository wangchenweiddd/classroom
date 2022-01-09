package com.edu.ahu.classroom.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 10:00 2018/11/14
 */
@Data
public class AirConControlAuthVo {

    private List<String> aoc;

    private List<String> mode;

    private List<String> elecLock;

    private Integer minTemp;

    private Integer maxTemp;

    private String defaultAoc;

    private String defaultMode;

    private String defaultElecLock;

    private Integer defaultTemp;
}
