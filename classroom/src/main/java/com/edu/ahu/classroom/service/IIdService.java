package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.vo.AirConLogVo;

import java.util.Date;
import java.util.List;

public interface IIdService {

    ServerResponse<List<AirConLogVo>> listAirConControlByUserId(Integer userId, Date startTime, Date endTime);
}
