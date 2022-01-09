package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.dao.AirConControlIdDao;
import com.edu.ahu.classroom.dto.AirConLogDto;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.AirConIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AirConIdServicelmpl implements AirConIdService {

    @Autowired
    private AirConControlIdDao airConControlIdDao;

    @Override
    public List<AirConLogDto> listUserOperateByUserId(Integer userId, Date startTime, Date endTime){
        RequestParamCheck.checkNull(userId,"userId");
        RequestParamCheck.checkNull(startTime,"startTime");
        RequestParamCheck.checkNull(endTime,"endTime");
        return airConControlIdDao.listUserOperateByUserId(userId,startTime,endTime);
    }
}
