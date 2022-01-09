package com.edu.ahu.classroom.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.edu.ahu.classroom.common.ResponsePojo;
import com.edu.ahu.classroom.common.ServerResponse;

import com.edu.ahu.classroom.dao.GetClassMessageDao;
import com.edu.ahu.classroom.dao.TimedTaskDao;
import com.edu.ahu.classroom.dataobject.*;
import com.edu.ahu.classroom.repository.AirConControlCurRepository;
import com.edu.ahu.classroom.repository.AirConControlLogRepository;
import com.edu.ahu.classroom.repository.AirConInfoRepository;
import com.edu.ahu.classroom.repository.GatewayInfoRepository;
import com.edu.ahu.classroom.service.IUserService;
import com.edu.ahu.classroom.service.TimedTaskService;
import com.edu.ahu.classroom.utils.HttpRequest;
import com.edu.ahu.classroom.vo.AirConControlAttrVo;
import com.edu.ahu.classroom.vo.AirConControlGateVo;
import com.edu.ahu.classroom.vo.AirConControlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wcw
 * @data 2020/5/30 10:32
 */

@Service
public class TimedTaskServiceImpl implements TimedTaskService {

    @Autowired
    private GetClassMessageDao getClassMessageDao;

    @Autowired
    private AirConInfoRepository airConInfoRepository;

    @Autowired
    private GatewayInfoRepository gatewayInfoRepository;

    @Autowired
    private AirConControlCurRepository airConControlCurRepository;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private AirConControlLogRepository airConControlLogRepository;

    @Autowired
    private TimedTaskDao timedTaskDao;



    @Override
    public void updateTimedTask(String closeTime, String startTime, String endTime, String intervalTime, String status) {

    }

    @Override
    public ServerResponse airConControlWhenZero(AirConControlVo airConControlVo, Integer userId) {
        //获取设置的人数
        List<Integer> deviceIdList=getClassMessageDao.findByClassNumZero(timedTaskDao.getNumCount());
        AirConControlAttrVo airConControlAttrVo = airConControlVo.getAirConControlAttrVo();
        String description = airConControlVo.getDescription();
        /*提交用户意图*/
        UserOperateEntity userOperateEntity = new UserOperateEntity();
        userOperateEntity.setUserId(userId);
        userOperateEntity.setCreateTime(new Date());
        userOperateEntity.setType("空调控制");
        userOperateEntity.setDescription(description);
        String userOperateProperty = JSONObject.toJSONString(airConControlAttrVo);
        userOperateEntity.setProperty(userOperateProperty);
        Integer userOperateId = iUserService.addUserOperate(userOperateEntity);
        controlAirCon(deviceIdList, airConControlAttrVo,userOperateId);//所有空调控制全部转换这种格式进行发送
        return ServerResponse.createBySuccess(userOperateId);
    }

    private void controlAirCon(List<Integer> deviceIdList, AirConControlAttrVo airConControlAttrVo, Integer userOperateId){
        //取出空调信息，写入map中供使用(免多次查询)
        List<AirConInfoEntity> airConInfoEntityList = airConInfoRepository.findAllById(deviceIdList);
        HashMap<Integer,Integer> gatewayIdHashMap = new HashMap<Integer, Integer>();
        for (AirConInfoEntity airConInfoEntity : airConInfoEntityList){
            gatewayIdHashMap.put(airConInfoEntity.getId(),airConInfoEntity.getGatewayId());
        }
        //校验deviceIdList，并依据网关id分类
        HashMap<Integer,List<Integer>> deviceIdGroupByGateIdMap = new HashMap<Integer, List<Integer>>();
        List<Integer> gatewayIdList = new ArrayList<Integer>();
        for (Integer deviceId:deviceIdList){
            Integer gatewayId = gatewayIdHashMap.get(deviceId);
            //若 gatewayId 为null 说明数据库中不存在该 deviceId 的空调
            if (gatewayId == null){
                continue;
            }
            List<Integer> deviceIdListOfOneGate = deviceIdGroupByGateIdMap.get(gatewayId);
            //若 deviceIdListOfOneGate 为 null 说明当前分类中暂未有该 gatewayId 的网关分类
            if (deviceIdListOfOneGate == null){
                deviceIdListOfOneGate = new ArrayList<Integer>();
                deviceIdGroupByGateIdMap.put(gatewayId,deviceIdListOfOneGate);
                gatewayIdList.add(gatewayId);
            }
            deviceIdListOfOneGate.add(deviceId);
        }

        //取出网关信息，并写入Map供使用(免多次查询)
        HashMap<Integer, GatewayInfoEntity> gatewayIpHashMap = new HashMap<Integer, GatewayInfoEntity>();
        List<GatewayInfoEntity> gatewayInfoEntityList = gatewayInfoRepository.findAllById(gatewayIdList);
        for (GatewayInfoEntity gatewayInfoEntity:gatewayInfoEntityList){
            gatewayIpHashMap.put(gatewayInfoEntity.getId(),gatewayInfoEntity);
        }

        //根据对应的网关id，取出相应的ip地址和deviceIdList发送数据
        for (Integer gatewayId:deviceIdGroupByGateIdMap.keySet()){
            List<Integer> deviceIdGroup = deviceIdGroupByGateIdMap.get(gatewayId);
            //将提交的数据转换为网关可用数据
            List<AirConControlGateVo> airConControlGateVoList = new ArrayList<AirConControlGateVo>();
            Integer selfGrowingNum = 1;
            for (Integer deviceId:deviceIdGroup){
                AirConControlGateVo airConControlGatePojo = new AirConControlGateVo();
                airConControlGatePojo.setDeviceId(deviceId);
                airConControlGatePojo.setAoc(airConControlAttrVo.getAoc());
                airConControlGatePojo.setAtemp(String.valueOf(airConControlAttrVo.getTemp()));
                airConControlGatePojo.setDwind("低风");
                airConControlGatePojo.setFmodel(airConControlAttrVo.getModel());
                airConControlGatePojo.setHelec(airConControlAttrVo.getElecLock());
                airConControlGatePojo.setRandomId(userOperateId + ":" + gatewayId + ":" + selfGrowingNum);
                selfGrowingNum++;
                airConControlGateVoList.add(airConControlGatePojo);
            }
            //若 gatewayIp 为 null 说明数据库中没有该gatewayId的网关
            String gatewayIp = gatewayIpHashMap.get(gatewayId).getIp();
            Integer gatewayPort = gatewayIpHashMap.get(gatewayId).getPort();
            if (gatewayIp == null || gatewayPort == null){
                continue;
            }
            //提交数据  提交数据失败 写入流水失败表  提交数据成功 写入实时表
            ResponsePojo response = HttpRequest.httpPostJsonThree(gatewayIp, gatewayPort, "aircondition/api/control/post", airConControlGateVoList);
            if (response.getMeta().getSuccess()){
                controlAirConSuccess(airConControlGateVoList,userOperateId);
            }else{
                controlAirConFail(airConControlGateVoList,userOperateId);
            }
        }
    }
    /**
     * 控制空调成功
     * 将发送给网关的数据转换为控制实时数据，定义属性为“正在执行”
     * @param airConControlGateVoList   发送网关空调控制数据
     * @param userOperateId             用户操作id
     */
    private void controlAirConSuccess(List<AirConControlGateVo> airConControlGateVoList,Integer userOperateId){
        List<AirConControlCurEntity> airConControlCurEntityList = new ArrayList<AirConControlCurEntity>();
        for (AirConControlGateVo airConControlGateVo : airConControlGateVoList){
            AirConControlCurEntity airConControlCurEntity = new AirConControlCurEntity();
            airConControlCurEntity.setOperateId(userOperateId);
            airConControlCurEntity.setRandomId(airConControlGateVo.getRandomId());
            airConControlCurEntity.setDeviceId(airConControlGateVo.getDeviceId());
            airConControlCurEntity.setTemp(Integer.parseInt(airConControlGateVo.getAtemp()));
            airConControlCurEntity.setAoc(airConControlGateVo.getAoc());
            airConControlCurEntity.setWind(airConControlGateVo.getDwind());
            airConControlCurEntity.setModel(airConControlGateVo.getFmodel());
            airConControlCurEntity.setElecLock(airConControlGateVo.getHelec());
            airConControlCurEntity.setStatus("正在执行");
            airConControlCurEntity.setCreateTime(new Date());
            airConControlCurEntityList.add(airConControlCurEntity);
        }
        airConControlCurRepository.saveAll(airConControlCurEntityList);
    }

    /**
     * 控制空调失败
     * 将发送给网关的数据转换为控制流水数据，定义属性为“发送失败”
     * 写入空调控制失败数据库
     * @param airConControlGateVoList   发送网关空调控制数据
     * @param userOperateId             用户操作id
     */
    private void controlAirConFail(List<AirConControlGateVo> airConControlGateVoList,Integer userOperateId){
        List<AirConControlLogEntity> airConControlLogEntityList = new ArrayList<AirConControlLogEntity>();
        for (AirConControlGateVo airConControlGateVo : airConControlGateVoList){
            AirConControlLogEntity airConControlLogEntity = new AirConControlLogEntity();
            airConControlLogEntity.setOperateId(userOperateId);
            airConControlLogEntity.setRandomId(airConControlGateVo.getRandomId());
            airConControlLogEntity.setDeviceId(airConControlGateVo.getDeviceId());
            airConControlLogEntity.setTemp(Integer.parseInt(airConControlGateVo.getAtemp()));
            airConControlLogEntity.setAoc(airConControlGateVo.getAoc());
            airConControlLogEntity.setWind(airConControlGateVo.getDwind());
            airConControlLogEntity.setModel(airConControlGateVo.getFmodel());
            airConControlLogEntity.setElecLock(airConControlGateVo.getHelec());
            airConControlLogEntity.setStatus("发送失败");
            airConControlLogEntity.setCreateTime(new Date());
            airConControlLogEntity.setUpdateTime(new Date());
            airConControlLogEntityList.add(airConControlLogEntity);
        }

        airConControlLogRepository.saveAll(airConControlLogEntityList);

    }

}
