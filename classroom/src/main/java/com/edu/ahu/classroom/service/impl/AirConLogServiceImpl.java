package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.dao.AirConControlLogDao;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.AirConLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirConLogServiceImpl implements AirConLogService {

    @Autowired
    private AirConControlLogDao airConControlLogDao;

    @Override
    public Integer countAirConControlByOperateId(Integer operateId, String status) {
        RequestParamCheck.checkNull(operateId,"operateId");
        RequestParamCheck.checkNull(status,"status");
        if(status.equals("正在执行")){
            return airConControlLogDao.countAirConControlByOperateId(operateId).intValue();
        }
        return airConControlLogDao.countAirConControlByOperateId(operateId, status).intValue();
    }

}
