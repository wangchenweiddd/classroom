package com.edu.ahu.classroom.Json;

import com.edu.ahu.classroom.dataobject.UserFaceInfo;
import com.edu.ahu.classroom.utils.DateStringTranUtil;
import lombok.Data;

/**
 * @author wcw
 * @data 2020/5/26 16:48
 */
@Data
public class FaceInfoJson {
    private Integer Id;

    private Integer groupId;

    private String faceId;

    private String name;

    private Integer age;

    private String email;

    private Short gender;

    private String phoneNumber;

    private String createTime;

    private String updateTime;

    private byte[] faceFeature;

    public UserFaceInfo AddUserFaceInfo(){
        String DATE_FORMAT_MM_T = "yyy-MM-dd HH:mm:ss";
        UserFaceInfo userFaceInfo=new UserFaceInfo();
        userFaceInfo.setGroupId(getGroupId());
        userFaceInfo.setFaceId(getFaceId());
        userFaceInfo.setName(getName());
        userFaceInfo.setFaceFeature(getFaceFeature());
        userFaceInfo.setCreateTime(DateStringTranUtil.getDate(DATE_FORMAT_MM_T));
        return userFaceInfo;
    }
}
