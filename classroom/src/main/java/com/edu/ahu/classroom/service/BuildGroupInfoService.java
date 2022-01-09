package com.edu.ahu.classroom.service;


import com.edu.ahu.classroom.dataobject.BuildGroupInfoEntity;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListCheckVO;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 14:37 2018/5/25
 */
public interface BuildGroupInfoService {

    List<PduListCheckVO> findByPidAndSelectAndState(Integer id, String select, String state);

    List<BuildGroupInfoEntity> findByPidAndStateTwo(Integer id, String state);

    List<PduList2VO>findByPidAndState2(Integer id, String state);
}
