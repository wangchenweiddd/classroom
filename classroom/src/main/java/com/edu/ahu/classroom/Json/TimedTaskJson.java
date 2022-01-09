package com.edu.ahu.classroom.Json;

import lombok.Data;

/**
 * @author wcw
 * @data 2020/5/30 17:08
 */
@Data
public class TimedTaskJson {
    private String closeTime;

    private String startTime;

    private String endTime;

    private String intervalTime;

    private String status;

    public TimedTaskJson(String closeTime,String startTime,String endTime,String intervalTime,String status){
        this.closeTime=closeTime;
        this.startTime=startTime;
        this.endTime=endTime;
        this.intervalTime=intervalTime;
        this.status=status;
    }
}
