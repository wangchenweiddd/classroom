package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dao.GetClassMessageDao;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.GetClassMessageService;
import com.edu.ahu.classroom.service.TimedTaskService;
import com.edu.ahu.classroom.vo.AirConControlAttrVo;
import com.edu.ahu.classroom.vo.AirConControlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wcw
 * @data 2020/5/28 9:17
 */

@RestController
@RequestMapping("/class")
public class ClassCountController {
    @Autowired
    private GetClassMessageService getClassMessageService;

    @Autowired
    private GetClassMessageDao getClassMessageDao;

    @Autowired
    private TimedTaskService timedTaskService;


    /**
     * 教室详细信息展示
     * @param userId
     * @param regionCode
     * @return
     */
    @GetMapping("/status")
    public ServerResponse getClassStatus(Integer userId,String regionCode){
        RequestParamCheck.checkNull(userId,"userId");
        RequestParamCheck.checkNull(regionCode,"regionCode");
        return getClassMessageService.getClassMesageByRegionCode(userId, regionCode);

    }

}
