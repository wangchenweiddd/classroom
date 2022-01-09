package com.edu.ahu.classroom.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 20:33 2018/6/10
 */
@Data
public class ChartResponse2Vo {

    private List<Object> xValue;

    private List<Object> yValue;

    public ChartResponse2Vo(List<Object> xValue, List<Object> yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }
}
