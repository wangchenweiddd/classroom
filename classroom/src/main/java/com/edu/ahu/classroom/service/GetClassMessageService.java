package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dataobject.AirConRegionEntity;

/**
 * @author wcw
 * @data 2020/5/28 9:29
 */
public interface GetClassMessageService {
    /**
     * 根据用户Id获取所显示树形区域数据
     */
    ServerResponse getClassRegionTreeByUserId(Integer userId);

    ServerResponse getClassMesageByRegionCode(Integer userId,String regionCode);

    /**
     * 获取用户权限内教室区域
     */


}

