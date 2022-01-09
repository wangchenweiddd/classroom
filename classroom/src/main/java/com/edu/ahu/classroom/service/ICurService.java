package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dto.AirConControlDto;

import java.util.List;

public interface ICurService {


    ServerResponse<List<AirConControlDto>> listAirConControlByOperateId(Integer operateId, String select);
}
