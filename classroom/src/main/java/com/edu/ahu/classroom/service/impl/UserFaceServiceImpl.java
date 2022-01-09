package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.Json.FaceInfoJson;
import com.edu.ahu.classroom.dataobject.UserFaceInfo;
import com.edu.ahu.classroom.repository.UserFaceInfoRepository;
import com.edu.ahu.classroom.service.UserFaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcw
 * @data 2020/5/26 17:15
 */
@Service
public class UserFaceServiceImpl implements UserFaceInfoService {
    @Autowired
    private UserFaceInfoRepository userFaceInfoRepository;



    @Override
    public void insertSelective(UserFaceInfo userFaceInfo) {

    }
}
