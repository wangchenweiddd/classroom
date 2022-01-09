package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dao.GetClassMessageDao;
import com.edu.ahu.classroom.service.TimedTaskService;
import com.edu.ahu.classroom.vo.AirConControlAttrVo;
import com.edu.ahu.classroom.vo.AirConControlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;

/**
 * @author wcw
 * @data 2020/5/30 11:11
 * 定时任务
 */
//@Component
//@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
//public class TimingTask {
//    @Autowired
//    private TimedTaskService timedTaskService;
//
//    @Autowired
//    private GetClassMessageDao getClassMessageDao;
//
//
//    @Scheduled(cron = "0 */1 * * * ?")
//    @Transactional
//     public void airControlInTime(){
//        AirConControlAttrVo airConControlAttrVo=new AirConControlAttrVo();
//        airConControlAttrVo.setAoc("关机");
//        airConControlAttrVo.setElecLock("无效");
//        airConControlAttrVo.setModel("制冷");
//        airConControlAttrVo.setTemp("26");
//        AirConControlVo airConControlVo=new AirConControlVo();
//        airConControlVo.setDeviceIdList(getClassMessageDao.findByClassNumZero(0));
//        airConControlVo.setAirConControlAttrVo(airConControlAttrVo);
//        airConControlVo.setDescription("定时关机");
//        timedTaskService.airConControlWhenZero(airConControlVo,160);
//        }
//}
