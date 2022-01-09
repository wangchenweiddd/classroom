package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import com.edu.ahu.classroom.dataobject.UserOperateEntity;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 11:56 2018/11/7
 */
public interface IUserService {

    /**
     * 根据用户名获取用户信息
     * @param name 用户名
     * @return     用户信息
     */
    ServerResponse<UserInfoEntity> UserInfoCheck(String name, String password);

    /**
     * 添加用户动作并返回动作编号
     * @param userOperateEntity     用户动作
     * @return                      动作编号
     */
    Integer addUserOperate(UserOperateEntity userOperateEntity);
}
