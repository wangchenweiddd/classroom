package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.vo.AirConControlCountVo;

public interface ILogService {

    ServerResponse<AirConControlCountVo> countAirConControlByOperateId(Integer operateId);
}
