package com.edu.ahu.classroom.service.impl;


import com.edu.ahu.classroom.common.Const;
import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dao.*;
import com.edu.ahu.classroom.dataobject.*;
import com.edu.ahu.classroom.dto.PduControlInfoLogDTO;
import com.edu.ahu.classroom.dto.PduSettingInfoLogDTO;
import com.edu.ahu.classroom.dto.PduWarmInfoDTO;
import com.edu.ahu.classroom.enums.UpperActEnum;
import com.edu.ahu.classroom.exception.RequestException;
import com.edu.ahu.classroom.repository.*;
import com.edu.ahu.classroom.service.OperationService;
import com.edu.ahu.classroom.utils.OnlineJudgeUtil;
import com.edu.ahu.classroom.vo.ChartResponse2Vo;
import com.edu.ahu.classroom.vo.OnlineStatusVO;
import com.edu.ahu.classroom.vo.PduDetailInfoVO;
import com.edu.ahu.classroom.vo.PduListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 12:58 2018/5/30
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private PduPortCurRepo pduPortCurRepo;

    @Autowired
    private PduControlInfoRepo pduControlInfoRepo;

    @Autowired
    private PduBaseInfoRepo pduBaseInfoRepo;

    @Autowired
    private CampusInfoDao campusInfoDao;

    @Autowired
    private BuildGroupInfoDao buildGroupInfoDao;

    @Autowired
    private BuildInfoDao buildInfoDao;

    @Autowired
    private PduSettingCurRepo pduSettingCurRepo;

    @Autowired
    private PduSettingInfoLogRepo pduSettingInfoLogRepo;

    @Autowired
    private PduWarmInfoRepo pduWarmInfoRepo;

    @Autowired
    private PduControlInfoLogRepo pduControlInfoLogRepo;

    @Autowired
    private PduSettingCurDao pduSettingCurDao;

    @Autowired
    private PduUpdateInfoLogDao pduUpdateInfoLogDao;

    @Autowired
    private PduPortCurDao pduPortCurDao;

    @Autowired
    private NumberCountRepo numberCountRepo;



    public void singleSwitchOperation(Integer equId,Integer port,Integer mark,Integer userId){

        PduControlInfoEntity pduControlInfoEntity = new PduControlInfoEntity();

        PduPortCurEntity pduPortCurEntity = pduPortCurRepo.findByEquId(equId);

        NumberCount numberCount=new NumberCount();

        pduControlInfoEntity.setEquId(equId);
        pduControlInfoEntity.setUserId(userId);

       if (mark == 1){
           if(port==5){
               List<NumberCount>classroom=numberCountRepo.findByPduId(equId);
               if(classroom!=null){
                    for(NumberCount n:classroom){
                        n.setLightOne("开");
                        numberCountRepo.save(n);
                    }
               }
           }
           if(port==6){
               List<NumberCount>classroom=numberCountRepo.findByPduId(equId);
               if(classroom!=null){
                   for(NumberCount n:classroom){
                       n.setLightOne("关");
                       numberCountRepo.save(n);
                   }
               }
           }
           pduControlInfoEntity.setPort1(port);
           pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
           pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
           pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
           pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
           pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
           pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
           pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());

           pduPortCurEntity.setPort1(UpperActEnum.PROCESSING.getCode());
       }
        if (mark == 2){
            if(port==5){
                List<NumberCount>classroom=numberCountRepo.findByPduId(equId);
                if(classroom!=null){
                    for(NumberCount n:classroom){
                        n.setLightTwo("开");
                        numberCountRepo.save(n);
                    }
                }
            }
            if(port==6){
                List<NumberCount>classroom=numberCountRepo.findByPduId(equId);
                if(classroom!=null){
                    for(NumberCount n:classroom){
                        n.setLightTwo("关");
                        numberCountRepo.save(n);
                    }
                }
            }
            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(port);
            pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());
            pduPortCurEntity.setPort2(UpperActEnum.PROCESSING.getCode());
        }
        if (mark == 3){
            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort3(port);
            pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());
            pduPortCurEntity.setPort3(UpperActEnum.PROCESSING.getCode());
        }
        if (mark == 4){
            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort4(port);
            pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());
            pduPortCurEntity.setPort4(UpperActEnum.PROCESSING.getCode());
        }
        if (mark == 5){
            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort5(port);
            pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());
            pduPortCurEntity.setPort5(UpperActEnum.PROCESSING.getCode());
        }
        if (mark == 6){
            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort6(port);
            pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());
            pduPortCurEntity.setPort6(UpperActEnum.PROCESSING.getCode());
        }
        if (mark == 7){
            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort7(port);
            pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());
            pduPortCurEntity.setPort7(UpperActEnum.PROCESSING.getCode());
        }
        if (mark == 8){
            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort8(port);
            pduPortCurEntity.setPort8(UpperActEnum.PROCESSING.getCode());
        }

        pduControlInfoEntity.setSettingTime(new Date());

        pduControlInfoRepo.save(pduControlInfoEntity);
        pduPortCurRepo.save(pduPortCurEntity);

    }

    @Override
    public void someSwitchOperation(List<Integer> euqIds, Integer port, List<Integer> marks,Integer userId) {


        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i < marks.size();i++){
            map.put(marks.get(i),port);
        }

        for (int i = 0; i < euqIds.size();i++ ){
            PduControlInfoEntity pduControlInfoEntity = new PduControlInfoEntity();
            PduPortCurEntity pduPortCurEntity = pduPortCurRepo.findByEquId(euqIds.get(i));

            pduControlInfoEntity.setPort1(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort2(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort3(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort4(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort5(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort6(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort7(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setPort8(UpperActEnum.IGNORE.getCode());
            pduControlInfoEntity.setEquId(euqIds.get(i));
            pduControlInfoEntity.setUserId(userId);

            for (int j = 0;j < marks.size();j++){
                if (marks.get(j) == 1){
                    if(port==5){
                        List<NumberCount> classroom=numberCountRepo.findByPduId(euqIds.get(i));
                        if(classroom!=null){
                            for(NumberCount n:classroom){
                                n.setLightOne("开");
                                numberCountRepo.save(n);
                            }
                        }
                    }
                    if(port==6){
                        List<NumberCount>classroom=numberCountRepo.findByPduId(euqIds.get(i));
                        if(classroom!=null){
                            for(NumberCount n:classroom){
                                n.setLightOne("关");
                                numberCountRepo.save(n);
                            }
                        }
                    }
                    pduControlInfoEntity.setPort1(map.get(marks.get(j)));
                    pduPortCurEntity.setPort1(UpperActEnum.PROCESSING.getCode());
                }
                if (marks.get(j) == 2){
                    if(port==5){
                        List<NumberCount>classroom=numberCountRepo.findByPduId(euqIds.get(i));
                        if(classroom!=null){
                            for(NumberCount n:classroom){
                                n.setLightTwo("开");
                                numberCountRepo.save(n);
                            }
                        }
                    }
                    if(port==6){
                        List<NumberCount>classroom=numberCountRepo.findByPduId(euqIds.get(i));
                        if(classroom!=null){
                            for(NumberCount n:classroom){
                                n.setLightTwo("关");
                                numberCountRepo.save(n);
                            }
                        }
                    }
                    pduControlInfoEntity.setPort2(map.get(marks.get(j)));
                    pduPortCurEntity.setPort2(UpperActEnum.PROCESSING.getCode());
                }
                if (marks.get(j) == 3){
                    pduControlInfoEntity.setPort3(map.get(marks.get(j)));
                    pduPortCurEntity.setPort3(UpperActEnum.PROCESSING.getCode());
                }
                if (marks.get(j) == 4){
                    pduControlInfoEntity.setPort4(map.get(marks.get(j)));
                    pduPortCurEntity.setPort4(UpperActEnum.PROCESSING.getCode());
                }
                if (marks.get(j) == 5){
                    pduControlInfoEntity.setPort5(map.get(marks.get(j)));
                    pduPortCurEntity.setPort5(UpperActEnum.PROCESSING.getCode());
                }
                if (marks.get(j) == 6){
                    pduControlInfoEntity.setPort6(map.get(marks.get(j)));
                    pduPortCurEntity.setPort6(UpperActEnum.PROCESSING.getCode());
                }
                if (marks.get(j) == 7){
                    pduControlInfoEntity.setPort7(map.get(marks.get(j)));
                    pduPortCurEntity.setPort7(UpperActEnum.PROCESSING.getCode());
                }
                if (marks.get(j) == 8){
                    pduControlInfoEntity.setPort8(map.get(marks.get(j)));
                    pduPortCurEntity.setPort8(UpperActEnum.PROCESSING.getCode());
                }
            }

            pduControlInfoEntity.setSettingTime(new Date());

            pduControlInfoRepo.save(pduControlInfoEntity);
            pduPortCurRepo.save(pduPortCurEntity);

        }
    }

    @Override
    public ServerResponse checkAll(String type, Integer id) {

        List<Integer> ids = new ArrayList<>();
        List<PduListVO> pduListVOList = new ArrayList<>();

        switch (type){
            case "school":
                pduListVOList = campusInfoDao.findByState(Const.STATUS_ENABLE);
                pduListVOList.forEach(e -> ids.add(e.getPduBaseInfo().getId()));
                if(ids.size() == 0)
                    throw new RequestException("当前建筑下无PDU");
                pduBaseInfoRepo.saveCheck(ids,1);
                return ServerResponse.createBySuccessMessage("成功");
            case "campus":
                pduListVOList = buildGroupInfoDao.findByPidAndState(id,Const.STATUS_ENABLE);
                pduListVOList.forEach(e -> ids.add(e.getPduBaseInfo().getId()));
                if(ids.size() == 0)
                    throw new RequestException("当前建筑下无PDU");
                pduBaseInfoRepo.saveCheck(ids,1);
                return ServerResponse.createBySuccessMessage("成功");
            case "group":
                pduListVOList = buildInfoDao.findByPidAndState(id,Const.STATUS_ENABLE);
                pduListVOList.forEach(e -> ids.add(e.getPduBaseInfo().getId()));
                if(ids.size() == 0)
                    throw new RequestException("当前建筑下无PDU");
                pduBaseInfoRepo.saveCheck(ids,1);
                return ServerResponse.createBySuccessMessage("成功");
            default:
                throw new RequestException("参数非法，建筑类型非法");

        }


    }

    @Override
    public void checkOne(Integer id,Integer check) {

        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        pduBaseInfoRepo.saveCheck(ids,check);
    }

    @Override
    public ServerResponse cancelAll(String type, Integer id) {

        List<Integer> ids = new ArrayList<>();
        List<PduListVO> pduListVOList = new ArrayList<>();

        switch (type){
            case "school":
                pduListVOList = campusInfoDao.findByState(Const.STATUS_ENABLE);
                pduListVOList.forEach(e -> ids.add(e.getPduBaseInfo().getId()));
                if(ids.size() == 0)
                    throw new RequestException("当前建筑下无PDU");
                pduBaseInfoRepo.saveCheck(ids,0);
                return ServerResponse.createBySuccessMessage("成功");
            case "campus":
                pduListVOList = buildGroupInfoDao.findByPidAndState(id,Const.STATUS_ENABLE);
                pduListVOList.forEach(e -> ids.add(e.getPduBaseInfo().getId()));
                if(ids.size() == 0)
                    throw new RequestException("当前建筑下无PDU");
                pduBaseInfoRepo.saveCheck(ids,0);
                return ServerResponse.createBySuccessMessage("成功");
            case "group":
                pduListVOList = buildInfoDao.findByPidAndState(id,Const.STATUS_ENABLE);
                pduListVOList.forEach(e -> ids.add(e.getPduBaseInfo().getId()));
                if(ids.size() == 0)
                    throw new RequestException("当前建筑下无PDU");
                pduBaseInfoRepo.saveCheck(ids,0);
                return ServerResponse.createBySuccessMessage("成功");
            default:
                throw new RequestException("参数非法，建筑类型非法");

        }
    }

    @Override
    public OnlineStatusVO findOnlineStatus(String type, Integer id) {

        List<PduPortCurEntity> pduPortCurEntityList ;


           if (type.equals("school")) {
               pduPortCurEntityList = pduPortCurDao.findByState(Const.STATUS_ENABLE);
           }else if (type.equals("campus")) {
               pduPortCurEntityList = pduPortCurDao.findByCampusIdAndState(id, Const.STATUS_ENABLE);
           }else if (type.equals("group")) {
               pduPortCurEntityList = pduPortCurDao.findByGroupIdAndState(id, Const.STATUS_ENABLE);
           }else if (type.equals("build")) {
               pduPortCurEntityList = pduPortCurDao.findByBuildIdAndState(id, Const.STATUS_ENABLE);
           }else {
                throw new RequestException("参数非法，建筑类型非法");
         }

        int i = 0,j = 0;
        for (PduPortCurEntity pduPortCurEntity:pduPortCurEntityList) {
            if (pduPortCurEntity != null) {
                if (OnlineJudgeUtil.isOnline(pduPortCurEntity.getUpdateTime()) == 1) {
                    i++;
                }
                if (OnlineJudgeUtil.isOnline(pduPortCurEntity.getUpdateTime()) == 0) {
                    j++;
                }
            }
        }
        return new OnlineStatusVO(i+j,i,j);
    }


    @Override
    public List<PduDetailInfoVO> detailFindByEquIdAndState(Integer equId, String state) {

        return pduSettingCurDao.findByEquIdAndState(equId,state);
    }

    @Override
    public Page<PduWarmInfoDTO> warmFindByEquId(Integer equId, Pageable pageable) {
        Page<Object[]>  objects = pduWarmInfoRepo.findByEquId(equId, pageable);
        List<PduWarmInfoDTO> pduWarmInfoDTOList = new ArrayList<>();
        for (Object[] objects1:objects.getContent()){
            PduWarmInfoDTO pduWarmInfoDTO = new PduWarmInfoDTO();
            String name = (String)  objects1[0];
            PduWarmInfoEntity pduWarmInfoEntity = (PduWarmInfoEntity) objects1[1];
            pduWarmInfoDTO.setName(name);
            if (pduWarmInfoEntity == null){
                return  new PageImpl<PduWarmInfoDTO>(pduWarmInfoDTOList,objects.getPageable(),objects.getTotalElements());
            }
            BeanUtils.copyProperties(pduWarmInfoEntity,pduWarmInfoDTO);
            if (pduWarmInfoEntity.getUpdateTime() == null ){
                pduWarmInfoDTO.setUpdateTimeStamp(0);
            }else {
                pduWarmInfoDTO.setUpdateTimeStamp(pduWarmInfoEntity.getUpdateTime().getTime());
            }

            pduWarmInfoDTOList.add(pduWarmInfoDTO);
        }

        return new PageImpl<PduWarmInfoDTO>(pduWarmInfoDTOList,objects.getPageable(),objects.getTotalElements());
    }

    @Override
    public Page<PduSettingInfoLogDTO> settingFindByEquId(Integer equId, Pageable pageable) {
        Page<Object[]>  objects =  pduSettingInfoLogRepo.findByEquId(equId, pageable);
        List<PduSettingInfoLogDTO> pduSettingInfoLogDTOList = new ArrayList<>();
        for (Object[] objects1:objects.getContent()){
            PduSettingInfoLogDTO pduSettingInfoLogDTO = new PduSettingInfoLogDTO();
            String name = (String)  objects1[0];
            PduSettingInfoLogEntity pduSettingInfoLogEntity = (PduSettingInfoLogEntity) objects1[1];
            pduSettingInfoLogDTO.setName(name);
            if (pduSettingInfoLogEntity == null){
                return new PageImpl<PduSettingInfoLogDTO>(pduSettingInfoLogDTOList,objects.getPageable(),objects.getTotalElements());
            }
            BeanUtils.copyProperties(pduSettingInfoLogEntity ,pduSettingInfoLogDTO);
            if (pduSettingInfoLogEntity.getSettingTime() == null){
                pduSettingInfoLogDTO.setSettingTimeStamp(0);
            }else {
                pduSettingInfoLogDTO.setSettingTimeStamp(pduSettingInfoLogEntity.getSettingTime().getTime());
            }
            if (pduSettingInfoLogEntity.getUpdateTime() == null){
                pduSettingInfoLogDTO.setUpdateTimeStamp(0);
            }else {
                pduSettingInfoLogDTO.setUpdateTimeStamp(pduSettingInfoLogEntity.getUpdateTime().getTime());
            }

            pduSettingInfoLogDTOList.add(pduSettingInfoLogDTO);
        }
        return new PageImpl<PduSettingInfoLogDTO>(pduSettingInfoLogDTOList,objects.getPageable(),objects.getTotalElements());
    }

    @Override
    public Page<PduControlInfoLogDTO> conFindByEquId(Integer equId, Pageable pageable) {
        Page<Object[]>  objects =  pduControlInfoLogRepo.findByEquId(equId, pageable);
        List<PduControlInfoLogDTO> pduControlInfoLogDTOList = new ArrayList<>();

        for (Object[] objects1:objects.getContent()) {
            PduControlInfoLogDTO pduControlInfoLogDTO = new PduControlInfoLogDTO();
            String name =  (String) objects1[0];
            pduControlInfoLogDTO.setName(name);
            PduControlInfoLogEntity pduControlInfoLogEntity =(PduControlInfoLogEntity) objects1[1];
            if (pduControlInfoLogEntity == null){
                return  new PageImpl<PduControlInfoLogDTO>(pduControlInfoLogDTOList,objects.getPageable(),objects.getTotalElements());
            }
            BeanUtils.copyProperties(pduControlInfoLogEntity,pduControlInfoLogDTO);
            if (pduControlInfoLogEntity.getSettingTime() == null){
                pduControlInfoLogDTO.setSettingTimeStamp(0);
            }else {
                pduControlInfoLogDTO.setSettingTimeStamp(pduControlInfoLogEntity.getSettingTime().getTime());
            }
            if (pduControlInfoLogEntity.getControlTime() == null){
                pduControlInfoLogDTO.setControlTimeStamp(0);
            }else {
                pduControlInfoLogDTO.setControlTimeStamp(pduControlInfoLogEntity.getControlTime().getTime());
            }

            pduControlInfoLogDTOList.add(pduControlInfoLogDTO);
        }


        return new PageImpl<PduControlInfoLogDTO>(pduControlInfoLogDTOList,objects.getPageable(),objects.getTotalElements());
    }

    @Override
    public PduPortCurEntity onePortFindByEquId(Integer equId) {
        return pduPortCurRepo.findByEquId(equId);
    }

    @Override
    public ChartResponse2Vo currentChart(Date date1, Date date2, Integer equId) {
        return pduUpdateInfoLogDao.currentChart(date1, date2,equId);
    }

    @Override
    public ChartResponse2Vo voltageChart(Date date1, Date date2,Integer equId) {
        return pduUpdateInfoLogDao.voltageChart(date1, date2,equId);
    }
}
