package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.dto.AirConControlDto;

import java.util.List;

public interface AirConCurService {

    List<AirConControlDto> listAirConControlByOperateId(Integer operateId);

    List<AirConControlDto> listAirConControlByOperateId(Integer operateId, String status);

}
