package com.edu.ahu.classroom.service;


import com.edu.ahu.classroom.dataobject.CampusInfoEntity;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListCheckVO;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 14:32 2018/5/25
 */
public interface CampusInfoService {

    List<PduListCheckVO> findBySelectAndState(String select, String state);

    List<CampusInfoEntity> findByStateTwo(String state);

    List<PduList2VO>findByState2(String state);
}
