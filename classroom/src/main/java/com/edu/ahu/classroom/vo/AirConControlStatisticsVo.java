package com.edu.ahu.classroom.vo;

import lombok.Data;

/**
 * @author wcw
 * @data 2020/6/13 16:30
 */
@Data
public class AirConControlStatisticsVo {
    private String fullName;
    private int allCount;
    private int openCount;
    private int closeCount;
    private int offlineCount;
}
