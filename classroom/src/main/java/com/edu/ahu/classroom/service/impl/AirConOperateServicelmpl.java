package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.dao.AirConOperateDao;
import com.edu.ahu.classroom.dto.AirConLogDto;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.AirConOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AirConOperateServicelmpl implements AirConOperateService {

    @Autowired
    private AirConOperateDao airConOperateDao;

    @Override
    public List<AirConLogDto> listUserOperateByAdministrator(Date startTime, Date endTime){

        RequestParamCheck.checkNull(startTime,"startTime");
        RequestParamCheck.checkNull(endTime,"endTime");
        return airConOperateDao.listUserOperateByAdministrator(startTime,endTime);
    }
}
