package com.edu.ahu.classroom.service;


import com.edu.ahu.classroom.dataobject.BuildInfoEntity;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListCheckVO;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 14:38 2018/5/25
 */
public interface BuildInfoService {

    List<PduListCheckVO> findByPidAndSelectAndState(Integer id, String select, String state);

    List<BuildInfoEntity> findByPidAndStateTwo(Integer id, String state);

    List<PduList2VO>findByPidAndState2(Integer id, String state);
}
