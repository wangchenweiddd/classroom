package com.edu.ahu.classroom.service.impl;


import com.edu.ahu.classroom.dao.BuildInfoDao;
import com.edu.ahu.classroom.dao.PduBaseInfoDao;
import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.repository.PduBaseInfoRepo;
import com.edu.ahu.classroom.service.PduBaseInfoService;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PduBaseInfoServiceImpl implements PduBaseInfoService {

    @Autowired
    private PduBaseInfoDao pduBaseInfoDao;

    @Autowired
    private PduBaseInfoRepo pduBaseInfoRepo;

    @Autowired
    private BuildInfoDao buildInfoDao;


    @Override
    public List<PduListVO> findByPidAndState(Integer id, String state) {

        return pduBaseInfoDao.findByPidAndState(id,state);
    }

    @Override
    public List<PduList2VO> findByPidAndState2(Integer id, String state) {
        return buildInfoDao.findByPidAndState2(id,state);
    }


    @Override
    public void saveEquip(PduBaseInfoEntity pduBaseInfoEntity){

        pduBaseInfoRepo.save(pduBaseInfoEntity);
    }
}
