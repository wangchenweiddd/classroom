package com.edu.ahu.classroom.service;


import com.edu.ahu.classroom.common.ServerResponse;

import java.util.Date;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 19:03 2018/11/7
 */
public interface IAuthService {

    /**
     * 根据用户id获取用户所显示的树形区域数据
     * @param userId
     * @return
     */
    ServerResponse getAirConRegionTreeByUserId(Integer userId);

    ServerResponse getAirConStatusByRegionCode(Integer userId, String regionCode, String select);

    ServerResponse countAirConStatusByRegionCode(Integer userId, String regionCode);

    /**
     * 获得用户控制权限
     * @param userId
     * @param time
     * @return
     */
    ServerResponse getAirConControlAuth(Integer userId, Date time);
}
