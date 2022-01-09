package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dto.AirConControlDto;
import com.edu.ahu.classroom.service.AirConCurService;
import com.edu.ahu.classroom.service.ICurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ICurServicelmpl implements ICurService {

    @Autowired
    private AirConCurService airConCurService;

    @Transactional
    @Override
    public ServerResponse<List<AirConControlDto>> listAirConControlByOperateId(Integer operateId, String select) {
        List<AirConControlDto> airConControlDtoList;
//        if(select.equals("总数"))
//            airConControlDtoList = airConCurService.listAirConControlByOperateId(operateId);
//        else if (select.equals("正在执行"))
//            airConControlDtoList = airConCurService.listAirConControlByOperateId(operateId,"正在执行");
//        else if (select.equals("执行失败"))
//            airConControlDtoList = airConCurService.listAirConControlByOperateId(operateId,"执行失败");
//        else if (select.equals("发送失败"))
//            airConControlDtoList = airConCurService.listAirConControlByOperateId(operateId,"发送失败");
//        else if (select.equals("执行成功"))
//            airConControlDtoList = airConCurService.listAirConControlByOperateId(operateId,"执行成功");
//        else
//            airConControlDtoList = airConCurService.listAirConControlByOperateId(operateId,select);
            airConControlDtoList = airConCurService.listAirConControlByOperateId(operateId, "发送失败");
            airConControlDtoList.addAll(airConCurService.listAirConControlByOperateId(operateId, "执行成功"));
        return ServerResponse.createBySuccess(airConControlDtoList);
    }

}
