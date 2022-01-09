package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.dao.AirConControlCurDao;
import com.edu.ahu.classroom.dao.AirConControlLogDao;
import com.edu.ahu.classroom.dto.AirConControlDto;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.AirConCurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirConCurServicelmpl implements AirConCurService {

    @Autowired
    private AirConControlCurDao airConControlCurDao;

    @Autowired
    private AirConControlLogDao airConControlLogDao;


    public List<AirConControlDto> listAirConControlByOperateId(Integer operateId) {
        List<AirConControlDto> airConControlDtoList = new ArrayList<AirConControlDto>();
        airConControlDtoList.addAll(airConControlCurDao.listAirConControlByOperateId(operateId));
        airConControlDtoList.addAll(airConControlLogDao.listAirConControlByOperateId(operateId));
        return airConControlDtoList;
    }

    @Override
    public List<AirConControlDto> listAirConControlByOperateId(Integer operateId, String status) {
        RequestParamCheck.checkNull(operateId,"operateId");
        RequestParamCheck.checkNull(status,"status");
        if(status.equals("正在执行"))
            return airConControlCurDao.listAirConControlByOperateId(operateId);
        return airConControlLogDao.listAirConControlByOperateId(operateId, status);
    }
}
