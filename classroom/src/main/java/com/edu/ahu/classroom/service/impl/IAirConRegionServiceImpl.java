package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.dao.AirConRegionDao;
import com.edu.ahu.classroom.dataobject.AirConRegionEntity;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.IAirConRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 18:55 2018/11/7
 */
@Service
public class IAirConRegionServiceImpl implements IAirConRegionService {

    @Autowired
    private AirConRegionDao airConRegionDao;


    @Override
    @Transactional
    public List<AirConRegionEntity> getAirConRegionOfAuth(Integer userId) {

        RequestParamCheck.checkNull(userId,"userId");

        //获取用户原始空调区域权限数据
        List<AirConRegionEntity> airConRegionEntityList = new ArrayList<AirConRegionEntity>();
        List<AirConRegionEntity> airConRegionEntityListOfOrigin = airConRegionDao.findByUserId(userId);

        if (airConRegionEntityListOfOrigin.isEmpty())
            return airConRegionEntityList;

        //获取本级和子级空调区域
        for (AirConRegionEntity airConRegionEntity:airConRegionEntityListOfOrigin){
            airConRegionEntityList.addAll(airConRegionDao.likeByRegionCode(airConRegionEntity.getRegionCode()));
        }
        return airConRegionEntityList;
    }

    @Override
    public List<AirConRegionEntity> getAirConRegionOfAuth(Integer userId, String regionCode, String regionType) {
        //入口数据验证
        RequestParamCheck.checkNull(userId,"userId");
        RequestParamCheck.checkNull(regionCode,"regionCode");
        RequestParamCheck.checkNull(regionType,"regionType");

        //获取用户空调控制的原始权限空调区域
        List<String> regionCodeList = new ArrayList<String>();
        List<AirConRegionEntity> airConRegionEntityListOfOrigin = airConRegionDao.findByUserId(userId);
        for (AirConRegionEntity airConRegionEntity:airConRegionEntityListOfOrigin){
            //权限内子级
            if (regionCode.startsWith(airConRegionEntity.getRegionCode()))
                regionCodeList.add(regionCode);
                //权限外父级
            else if (airConRegionEntity.getRegionCode().startsWith(regionCode))
                regionCodeList.add(airConRegionEntity.getRegionCode());
        }
        //获取指定区域信息
        List<AirConRegionEntity> airConRegionEntityList = new ArrayList<AirConRegionEntity>();
        if (regionCodeList.isEmpty())
            return airConRegionEntityList;
        for (String regionCodeString:regionCodeList){

            airConRegionEntityList.addAll(airConRegionDao.LikeByRegionCodeAndRegionType(regionCodeString,regionType));
        }


        return airConRegionEntityList;
    }

    @Override
    @Transactional
    public List<AirConRegionEntity> getAirConRegionOfParent(Integer userId) {

        RequestParamCheck.checkNull(userId,"userId");

        //获取用户原始空调区域权限数据
        List<AirConRegionEntity> airConRegionEntityList = new ArrayList<AirConRegionEntity>();
        List<AirConRegionEntity> airConRegionEntityListOfOrigin = airConRegionDao.findByUserId(userId);

        if (airConRegionEntityListOfOrigin.isEmpty())
            return airConRegionEntityList;

        //获取上级空调区域
        List<String> regionCodeList = new ArrayList<String>();
        for (AirConRegionEntity airConRegionEntity:airConRegionEntityListOfOrigin){
            for (int i=2;i<airConRegionEntity.getRegionCode().length();i=i+2){
                regionCodeList.add(airConRegionEntity.getRegionCode().substring(0,i));
            }
        }

        if (!regionCodeList.isEmpty())
            airConRegionEntityList.addAll(airConRegionDao.findByRegionCode(regionCodeList));
        return airConRegionEntityList;
    }
}
