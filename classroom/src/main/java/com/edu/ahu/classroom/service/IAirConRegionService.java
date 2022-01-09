package com.edu.ahu.classroom.service;


import com.edu.ahu.classroom.dataobject.AirConRegionEntity;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 18:53 2018/11/7
 */
public interface IAirConRegionService {

    /**
     * 获取用户权限内空调区域
     * @param userId        用户id
     * @return              用户权限内控制区域
     */
    List<AirConRegionEntity> getAirConRegionOfAuth(Integer userId);

    /**
     * 获取用户权限内空调区域
     * @param userId
     * @param regionCode
     * @param regionType
     * @return
     */
    List<AirConRegionEntity> getAirConRegionOfAuth(Integer userId, String regionCode, String regionType);

    /**
     * 获得用户权限父级空调区域
     * @param userId        用户id
     * @return              用户权限内控制区域
     */
    List<AirConRegionEntity> getAirConRegionOfParent(Integer userId);
}
