package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import com.edu.ahu.classroom.exception.RequestException;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.repository.UserInfoRepository;
import com.edu.ahu.classroom.service.ICurService;
import com.edu.ahu.classroom.service.IIdService;
import com.edu.ahu.classroom.service.ILogService;
import com.edu.ahu.classroom.service.IOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @Author: wcw
 * @Description:
 * @Date: 2020/5/30 11:11
 */
@RestController
@RequestMapping("/logger")
public class AirConLoggerController {

    @Autowired
    private ILogService iLogService;
    @Autowired
    private ICurService iCurService;
    @Autowired
    private IOperateService iOperateService;
    @Autowired
    private IIdService iIdService;
    @Autowired
    private UserInfoRepository userRepository;


    /**
     * 控制结果详情
     * @param operateId
     * @return
     */
    @GetMapping("/control/detail/count")
    public ServerResponse countAirConControlDetail(Integer operateId){

        RequestParamCheck.checkNull(operateId,"operateId");
        //数据获取
        return iLogService.countAirConControlByOperateId(operateId);
    }


    /**
     * 查看日志详情
     * @param operateId
     * @param status
     * @return
     */
    @GetMapping("/control/detail/list")
    public ServerResponse listAirConControlDetail(Integer operateId,String status) {
        RequestParamCheck.checkNull(operateId,"operateId");
        RequestParamCheck.checkNull(status,"status");
        //数据获取
        return iCurService.listAirConControlByOperateId(operateId,status);
    }

    /**
     * 查看某时间段的日志信息
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/control/all/list")
    public ServerResponse listAirConControlAll(Integer userId, String startTime, String endTime) {
        //入口数据检测
        RequestParamCheck.checkNull(userId, "userId");
        RequestParamCheck.checkNull(startTime, "startTime");
        RequestParamCheck.checkNull(endTime, "endTime");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date startTime1 = null;
        Date endTime1 = null;
        try {
            startTime1 = df.parse(startTime);
            endTime1 = df.parse(endTime);
        } catch (ParseException e) {
            throw new RequestException("传入时间格式有误");
        }

        Optional<UserInfoEntity> userInfoEntity = userRepository.findById(userId);

        //数据获取
        if (userInfoEntity.get().getUserName().equals("超级管理员")) {
            return iOperateService.listUserOperateByAdministrator(startTime1, endTime1);
        } else {
            return iIdService.listAirConControlByUserId(userId, startTime1, endTime1);
        }
    }
}
