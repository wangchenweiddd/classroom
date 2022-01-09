package com.edu.ahu.classroom.service.impl;


import com.edu.ahu.classroom.dao.BuildInfoDao;
import com.edu.ahu.classroom.dataobject.BuildInfoEntity;
import com.edu.ahu.classroom.dto.PduPortCurDTO;
import com.edu.ahu.classroom.exception.RequestException;
import com.edu.ahu.classroom.repository.BuildInfoRepo;
import com.edu.ahu.classroom.service.BuildInfoService;
import com.edu.ahu.classroom.utils.OnlineJudgeUtil;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListCheckVO;
import com.edu.ahu.classroom.vo.PduListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BuildInfoServiceImpl implements BuildInfoService {

    @Autowired
    private BuildInfoDao buildInfoDao;

    @Autowired
    private BuildInfoRepo buildInfoRepo;

    @Override
    public List<PduListCheckVO> findByPidAndSelectAndState(Integer id, String select, String state) {

        List<PduListVO> pduListVOList = buildInfoDao.findByPidAndState(id,state);
        List<PduListCheckVO> pduListCheckVOList = new ArrayList<>();

        for (PduListVO pduListVO:pduListVOList) {
            PduListCheckVO pduListCheckVO = new PduListCheckVO();
            PduPortCurDTO pduPortCurDTO = new PduPortCurDTO();
            if (pduListVO.getPduPortCur() != null){
                BeanUtils.copyProperties(pduListVO.getPduPortCur(),pduPortCurDTO);
                if (OnlineJudgeUtil.isOnline(pduPortCurDTO.getUpdateTime()) == 0){
                    pduPortCurDTO.setStatus(0);
                }else {
                    pduPortCurDTO.setStatus(1);
                }
            }else {
                pduPortCurDTO = null;
            }

            BeanUtils.copyProperties(pduListVO,pduListCheckVO);
            pduListCheckVO.setPduPortCurDTO(pduPortCurDTO);
            pduListCheckVOList.add(pduListCheckVO);
        }

        List<PduListCheckVO> pduListCheckVOS = new ArrayList<>();

        switch(select){
            case "总数":
                return pduListCheckVOList;
            case "在线数":
                pduListCheckVOList.forEach(e -> {if (e.getPduPortCurDTO() != null){
                    if (e.getPduPortCurDTO().getStatus() == 1 ){
                        pduListCheckVOS.add(e);
                    }
                } });
                return pduListCheckVOS;
            case "离线数":
                pduListCheckVOList.forEach(e -> {if (e.getPduPortCurDTO() != null){
                    if (e.getPduPortCurDTO().getStatus() == 0 ){
                        pduListCheckVOS.add(e);
                    }
                } });
                return pduListCheckVOS;
            default:
                throw new RequestException("参数非法，无此选项");
        }

    }

    @Override
    public List<BuildInfoEntity> findByPidAndStateTwo(Integer id, String state) {
        return buildInfoRepo.findByPidAndState(id,state);
    }

    @Override
    public List<PduList2VO> findByPidAndState2(Integer id, String state) {
        return buildInfoDao.findByPidAndState2(id,state);
    }
}
