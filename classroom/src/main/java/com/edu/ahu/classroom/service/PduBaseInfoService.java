package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListVO;

import java.util.List;


public interface PduBaseInfoService {

    List<PduListVO> findByPidAndState(Integer id, String state);

    List<PduList2VO> findByPidAndState2(Integer id, String state);

    void saveEquip(PduBaseInfoEntity pduBaseInfoEntity);
}
