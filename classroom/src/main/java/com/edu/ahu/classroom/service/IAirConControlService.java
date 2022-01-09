package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.vo.AirConControlVo;

/**
 * @Author: HDC
 * @Description:空调控制服务类
 * @Date: Created in 10:33 2018/11/14
 */
public interface IAirConControlService {


    /**
     * 空调点选控制
     *
     * @param airConControlVo               前台提交的空调控制数据
     * @return                              用户操作id
     */
     ServerResponse airConControlByDeviceId(AirConControlVo airConControlVo, Integer userId);
}
