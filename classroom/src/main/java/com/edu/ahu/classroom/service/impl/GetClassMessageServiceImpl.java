package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dao.GetClassMessageDao;
import com.edu.ahu.classroom.dataobject.AirConRegionEntity;
import com.edu.ahu.classroom.dto.ClassDto;
import com.edu.ahu.classroom.service.GetClassMessageService;
import com.edu.ahu.classroom.service.IAirConRegionService;
import com.edu.ahu.classroom.vo.AirConStatusCurVo;
import com.edu.ahu.classroom.vo.ClassMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wcw
 * @data 2020/5/28 10:19
 */
@Service
public class GetClassMessageServiceImpl implements GetClassMessageService {

    @Autowired
    private IAirConRegionService iAirConRegionService;

    @Autowired
    private GetClassMessageDao getClassMessageDao;

    @Override
    public ServerResponse getClassRegionTreeByUserId(Integer userId) {
        return null;
    }

    @Override
    public ServerResponse getClassMesageByRegionCode(Integer userId, String regionCode) {
        List<AirConRegionEntity> airConRegionEntityList = iAirConRegionService.getAirConRegionOfAuth(userId, regionCode, "room");
        List<Integer> roomIdList = new ArrayList<Integer>();
        for (AirConRegionEntity airConRegionEntity : airConRegionEntityList) {
            roomIdList.add(airConRegionEntity.getRegionId());
        }
        if (roomIdList.isEmpty())
            return ServerResponse.createBySuccess(new ArrayList<ClassMessageVo>());

         List<ClassMessageVo> airConStatusCurVoList = new ArrayList<ClassMessageVo>();
         List<ClassDto>classDtoList;
         classDtoList=getClassMessageDao.findClassByRoomId(roomIdList);
         for(ClassDto item:classDtoList){
             ClassMessageVo classMessageVo=new ClassMessageVo();
             classMessageVo.setRoomId(item.getNumberCount().getId());
             classMessageVo.setAoc(item.getAirConStatusCurEntity().getAoc());
             classMessageVo.setETemp(item.getAirConStatusCurEntity().getEnvTemp());
             classMessageVo.setNumCount(item.getNumberCount().getNumCount());
             classMessageVo.setRegionFullName(item.getNumberCount().getRegionFullName());
             classMessageVo.setRegionCode(item.getNumberCount().getRegionCode());
             classMessageVo.setLightFront(item.getNumberCount().getLightOne());
             classMessageVo.setLightBehind(item.getNumberCount().getLightTwo());
             airConStatusCurVoList.add(classMessageVo);
         }
         return ServerResponse.createBySuccess(airConStatusCurVoList);

    }
}
