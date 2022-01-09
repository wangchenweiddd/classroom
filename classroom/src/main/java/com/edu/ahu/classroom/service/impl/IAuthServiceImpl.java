package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dao.AirConStatusCurDao;
import com.edu.ahu.classroom.dao.AuthAirConControlDao;
import com.edu.ahu.classroom.dataobject.AirConRegionEntity;
import com.edu.ahu.classroom.dataobject.AuthAirConControlEntity;
import com.edu.ahu.classroom.dto.AirConStatusCurDto;
import com.edu.ahu.classroom.service.IAirConRegionService;
import com.edu.ahu.classroom.service.IAuthService;
import com.edu.ahu.classroom.vo.AirConControlAuthVo;
import com.edu.ahu.classroom.vo.AirConRegionTreeVo;
import com.edu.ahu.classroom.vo.AirConStatusCountVo;
import com.edu.ahu.classroom.vo.AirConStatusCurVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class IAuthServiceImpl implements IAuthService {

    @Autowired
    private IAirConRegionService iAirConRegionService;

    @Autowired
    private AirConStatusCurDao airConStatusCurDao;

    @Autowired
    private AuthAirConControlDao authAirConControlDao;

    @Override
    @Transactional
    public ServerResponse getAirConRegionTreeByUserId(Integer userId) {

        List<AirConRegionTreeVo> airConRegionTreeVoList = new ArrayList<AirConRegionTreeVo>();

        //根据用户id获取用户权限内空调区域
        List<AirConRegionEntity> airConRegionEntityList = iAirConRegionService.getAirConRegionOfAuth(userId);
        //将用户权限内空调区域数据转换成树形区域数据
        for (AirConRegionEntity airConRegionEntity:airConRegionEntityList){
            AirConRegionTreeVo airConRegionTreeVo = new AirConRegionTreeVo();
            airConRegionTreeVo.setId(airConRegionEntity.getRegionType()+"."+airConRegionEntity.getRegionId());
            airConRegionTreeVo.setPId(airConRegionEntity.getParentRegionType()+"."+airConRegionEntity.getParentRegionId());
            airConRegionTreeVo.setName(airConRegionEntity.getRegionFullName());
            airConRegionTreeVo.setRegionCode(airConRegionEntity.getRegionCode());
            airConRegionTreeVo.setOpen(false);
            airConRegionTreeVoList.add(airConRegionTreeVo);
        }

        //获取用户空调区域权限的父级区域
        List<AirConRegionEntity> pAirConRegionEntityList = iAirConRegionService.getAirConRegionOfParent(userId);

        //将用户权限内空调区域数据转换成树形区域数据
        for (AirConRegionEntity airConRegionEntity:pAirConRegionEntityList){
            AirConRegionTreeVo airConRegionTreeVo = new AirConRegionTreeVo();
            airConRegionTreeVo.setId(airConRegionEntity.getRegionType()+"."+airConRegionEntity.getRegionId());
            airConRegionTreeVo.setPId(airConRegionEntity.getParentRegionType()+"."+airConRegionEntity.getParentRegionId());
            airConRegionTreeVo.setName(airConRegionEntity.getRegionFullName());
            airConRegionTreeVo.setRegionCode(airConRegionEntity.getRegionCode());
            airConRegionTreeVo.setOpen(true);
            airConRegionTreeVoList.add(airConRegionTreeVo);
        }

        return ServerResponse.createBySuccess(airConRegionTreeVoList);
    }

    @Override
    @Transactional
    public ServerResponse getAirConStatusByRegionCode(Integer userId, String regionCode, String select) {

        List<AirConRegionEntity> airConRegionEntityList = iAirConRegionService.getAirConRegionOfAuth(userId, regionCode, "room");

        List<Integer> roomIdList = new ArrayList<Integer>();
        for (AirConRegionEntity airConRegionEntity : airConRegionEntityList) {
            roomIdList.add(airConRegionEntity.getRegionId());
        }

        if (roomIdList.isEmpty())
            return ServerResponse.createBySuccess(new ArrayList<AirConStatusCurVo>());

        List<AirConStatusCurVo> airConStatusCurVoList = new ArrayList<AirConStatusCurVo>();
        List<AirConStatusCurDto> airConStatusCurDtoList;
        if(select.equals("总数"))
                airConStatusCurDtoList = airConStatusCurDao.findByRoomId(roomIdList);
        else if (select.equals("运行"))
                airConStatusCurDtoList = airConStatusCurDao.findByRoomIdAndAoc(roomIdList, "开机");
        else if (select.equals("停止"))
                airConStatusCurDtoList = airConStatusCurDao.findByRoomIdAndAoc(roomIdList, "关机");
        else if (select.equals("离线"))
                airConStatusCurDtoList = airConStatusCurDao.findByRoomIdAndAoc(roomIdList, "离线");
        else
                airConStatusCurDtoList = airConStatusCurDao.findByRoomId(roomIdList);

        for(AirConStatusCurDto item : airConStatusCurDtoList) {
            AirConStatusCurVo airConStatusCurVo = new AirConStatusCurVo();
            airConStatusCurVo.setDeviceId(item.getAirConStatusCurEntity().getDeviceId());
            airConStatusCurVo.setAoc(item.getAirConStatusCurEntity().getAoc());

            if (item.getAirConStatusCurEntity().getAoc().equals("开机")) {
                airConStatusCurVo.setOpenTime(calOpenTime(item));
            } else {
                airConStatusCurVo.setOpenTime(0);
            }

            airConStatusCurVo.setTemp(item.getAirConStatusCurEntity().getTemp());
            airConStatusCurVo.setWind(item.getAirConStatusCurEntity().getWind());
            airConStatusCurVo.setMode(item.getAirConStatusCurEntity().getModel());
            airConStatusCurVo.setElec(item.getAirConStatusCurEntity().getElecLock());
            airConStatusCurVo.setRoomId(item.getAirConInfoEntity().getRoomId());
            airConStatusCurVo.setFullName(item.getAirConInfoEntity().getFullName());
            Integer openSumTimeOfHour = item.getAirConStatusCurEntity().getOpenSumTime()/3600;
            airConStatusCurVo.setOpenSumTime(openSumTimeOfHour);
            airConStatusCurVoList.add(airConStatusCurVo);

        }

            return ServerResponse.createBySuccess(airConStatusCurVoList);
        }

    @Override
    @Transactional
    public ServerResponse countAirConStatusByRegionCode(Integer userId, String regionCode) {
        AirConStatusCountVo airConStatusCountVo=new AirConStatusCountVo();
        List<AirConRegionEntity> airConRegionEntityList = iAirConRegionService.getAirConRegionOfAuth(userId,regionCode,"room");
        List<Integer> roomIdList=new ArrayList<Integer>();
        for(AirConRegionEntity airConRegionEntity:airConRegionEntityList){
            roomIdList.add(airConRegionEntity.getRegionId());
        }
        if(roomIdList.isEmpty()){
            airConStatusCountVo.setAll(0);
            airConStatusCountVo.setOpen(0);
            airConStatusCountVo.setClose(0);
            airConStatusCountVo.setOffline(0);
            return ServerResponse.createBySuccess(airConStatusCountVo);
        }
        airConStatusCountVo.setAll(airConStatusCurDao.countByRoomId(roomIdList).intValue());
        airConStatusCountVo.setOpen(airConStatusCurDao.countByRoomIdAndStatus(roomIdList,"开机").intValue());
        airConStatusCountVo.setClose(airConStatusCurDao.countByRoomIdAndStatus(roomIdList,"关机").intValue());
        airConStatusCountVo.setOffline(airConStatusCurDao.countByRoomIdAndStatus(roomIdList,"离线").intValue());

        return ServerResponse.createBySuccess(airConStatusCountVo);
    }

    @Override
    @Transactional
    public ServerResponse getAirConControlAuth(Integer userId,Date time) {

        //时间调整到2000年
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.YEAR,2000);

        AuthAirConControlEntity authAirConControlEntity = authAirConControlDao.findByUserId(userId, time);
        if (authAirConControlEntity == null)
            return null;

        AirConControlAuthVo airConControlAuthVo = new AirConControlAuthVo();
        airConControlAuthVo.setAoc(authAirConControlEntity.getAocList());
        airConControlAuthVo.setDefaultAoc(authAirConControlEntity.getDefaultAoc());
        airConControlAuthVo.setMode(authAirConControlEntity.getModeList());
        airConControlAuthVo.setDefaultMode(authAirConControlEntity.getDefaultMode());
        airConControlAuthVo.setElecLock(authAirConControlEntity.getElecLockList());
        airConControlAuthVo.setDefaultElecLock(authAirConControlEntity.getDefaultElecLock());
        airConControlAuthVo.setMinTemp(authAirConControlEntity.getMinTemp());
        airConControlAuthVo.setMaxTemp(authAirConControlEntity.getMaxTemp());
        airConControlAuthVo.setDefaultTemp(authAirConControlEntity.getDefaultTemp());

        return ServerResponse.createBySuccess(airConControlAuthVo);
    }

    /**
     * 计算使用时间
     * @param airConStatusCurDto
     * @return
     */
    private int calOpenTime(AirConStatusCurDto airConStatusCurDto){
        Date now = new Date();
        int diff = (int) (now.getTime() - airConStatusCurDto.getAirConStatusCurEntity().getAocTime().getTime())/(1000 * 60);
        return  diff;
    }



}
