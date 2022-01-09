package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.vo.AirConControlVo;
import com.edu.ahu.classroom.vo.ClassMessageVo;

/**
 * @author wcw
 * @data 2020/5/30 10:31
 */
public interface TimedTaskService {
    void updateTimedTask(String closeTime,String startTime,String endTime,String intervalTime,String status);

    ServerResponse airConControlWhenZero(AirConControlVo airConControlVo,
                                           Integer userId);
}
