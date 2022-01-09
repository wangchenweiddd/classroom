package com.edu.ahu.classroom.dto;

import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import com.edu.ahu.classroom.dataobject.UserOperateEntity;
import lombok.Data;

@Data
public class AirConLogDto {
    private UserOperateEntity userOperateEntity;
    private UserInfoEntity userInfoEntity;
    public AirConLogDto(UserOperateEntity userOperateEntity,UserInfoEntity userInfoEntity){

        this.userOperateEntity = userOperateEntity;
        this.userInfoEntity = userInfoEntity;
    }

    public UserOperateEntity getUserOperateEntity() {
        return userOperateEntity;
    }

    public void setUserOperateEntity(UserOperateEntity userOperateEntity) {
        this.userOperateEntity = userOperateEntity;
    }

    public UserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }
}
