package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import com.edu.ahu.classroom.dto.AirConLogDto;
import com.edu.ahu.classroom.service.AirConOperateService;
import com.edu.ahu.classroom.service.IOperateService;
import com.edu.ahu.classroom.utils.DateTimeUtil;
import com.edu.ahu.classroom.vo.AirConLogVo;
import com.edu.ahu.classroom.vo.UserOperateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IOperateServicelmpl implements IOperateService {

    @Autowired
    private AirConOperateService airConOperateService;

    @Transactional
    @Override
    public ServerResponse<List<AirConLogVo>> listUserOperateByAdministrator(Date startTime, Date endTime){
        List<AirConLogDto> airConLogDtoList;
        List<AirConLogVo> airConLogVoList = new ArrayList<>();

        airConLogDtoList = airConOperateService.listUserOperateByAdministrator(startTime,endTime);
        for (AirConLogDto item:airConLogDtoList) {
            AirConLogVo airConLogVo = new AirConLogVo();
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            UserOperateVo userOperateVo = new UserOperateVo();
            BeanUtils.copyProperties(item.getUserInfoEntity(),userInfoEntity);
            BeanUtils.copyProperties(item.getUserOperateEntity(),userOperateVo);
            userOperateVo.setCreateTimeStr(DateTimeUtil.dateToStr(item.getUserOperateEntity().getCreateTime()));
            airConLogVo.setUserInfoEntity(userInfoEntity);
            airConLogVo.setUserOperateVo(userOperateVo);

            airConLogVoList.add(airConLogVo);
        }
        return ServerResponse.createBySuccess(airConLogVoList);
    }
}
