package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.service.AirConLogService;
import com.edu.ahu.classroom.service.ILogService;
import com.edu.ahu.classroom.vo.AirConControlCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ILogServiceImpl implements ILogService {

    @Autowired
    private AirConLogService airConLogService;

    @Override
    @Transactional
    public ServerResponse<AirConControlCountVo> countAirConControlByOperateId(Integer operateId) {
        AirConControlCountVo airConControlCountVo =new AirConControlCountVo();
        Integer executing = airConLogService.countAirConControlByOperateId(operateId,"正在执行");
        Integer sendFailure = airConLogService.countAirConControlByOperateId(operateId,"发送失败");
        Integer execFailure = airConLogService.countAirConControlByOperateId(operateId,"执行失败");
        Integer execSuccess = airConLogService.countAirConControlByOperateId(operateId,"执行成功");

        Integer all = executing + sendFailure + execFailure + execSuccess;
        airConControlCountVo.setExecutIng(executing);
        airConControlCountVo.setSendFailure(sendFailure);
        airConControlCountVo.setExecuteSuccess(execSuccess);
        airConControlCountVo.setExecuteFailure(execFailure);
        airConControlCountVo.setAll(all);

        return ServerResponse.createBySuccess(airConControlCountVo);
    }
}
