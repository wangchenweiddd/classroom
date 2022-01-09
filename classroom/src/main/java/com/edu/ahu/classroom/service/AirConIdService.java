package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.dto.AirConLogDto;

import java.util.Date;
import java.util.List;

public interface AirConIdService {
    List<AirConLogDto> listUserOperateByUserId(Integer userId, Date startTime, Date endTime);
}
