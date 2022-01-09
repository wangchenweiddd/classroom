package com.edu.ahu.classroom.Json;

import lombok.Data;

/**
 * @author wcw
 * @data 2020/5/30 16:28
 */

@Data
public class SmartCloseJson {
    private String lock;

    private String model;

    private String temp;

    private Integer num;

    public SmartCloseJson(String lock, String model, String temp, Integer num) {
        this.lock = lock;
        this.model = model;
        this.temp = temp;
        this.num = num;
    }
}
