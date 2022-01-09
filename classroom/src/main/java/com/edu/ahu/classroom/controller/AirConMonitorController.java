package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.Json.ControllerUserJson;
import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.IAirConControlService;
import com.edu.ahu.classroom.service.IAuthService;
import com.edu.ahu.classroom.vo.AirConControlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: wcw
 * @Description:
 * @Date: Created in 19:32 2020/5/7
 */
@RestController
@RequestMapping("/manage/monitor")
public class AirConMonitorController {

    @Autowired
    private IAuthService iAuthService;

    @Autowired
    private IAirConControlService iAirConControlService;

    /**
     * 建筑树数据
     * @param userId
     * @return
     */
    @GetMapping("/tree")
    public ServerResponse getAirConTree(Integer userId){

        RequestParamCheck.checkNull(userId,"userId");

        return iAuthService.getAirConRegionTreeByUserId(userId);
    }

    /**
     * 空调详细信息展示
     * @param userId
     * @param regionCode
     * @param select
     * @return
     */
    @GetMapping("/status")
    public ServerResponse getAirConStatus(Integer userId,String regionCode,String select){

        RequestParamCheck.checkNull(userId,"userId");
        RequestParamCheck.checkNull(regionCode,"regionCode");
        RequestParamCheck.checkNull(select,"select");

        //数据获取后返回
        return  iAuthService.getAirConStatusByRegionCode(userId,regionCode,select);
    }



    /**
     * 空调当前状态的统计
     * @param userId
     * @param regionCode
     * @return
     */
    @GetMapping("/status/count")
    public ServerResponse countAirConStatus(Integer userId,String regionCode){

        RequestParamCheck.checkNull(userId,"userId");
        RequestParamCheck.checkNull(regionCode,"regionCode");

        //数据获取后返回
        return  iAuthService.countAirConStatusByRegionCode(userId, regionCode);
    }

    /**
     * 控制空调
     * @param airConControlVo
     * @param
     * @return
     */
    @PostMapping("/control")
//    public ServerResponse airConControl(@RequestBody AirConControlVo airConControlVo, Integer userId){
    public ServerResponse airConControl(@RequestBody AirConControlVo airConControlVo){

        RequestParamCheck.checkNull(airConControlVo.getUserId(),"userId");
        RequestParamCheck.checkNull(airConControlVo.getDeviceIdList(),"deviceIdList");

        //数据获取后返回
        return  iAirConControlService.airConControlByDeviceId(airConControlVo, airConControlVo.getUserId());
    }
}
