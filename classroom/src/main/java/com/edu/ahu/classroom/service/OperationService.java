package com.edu.ahu.classroom.service;


import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dataobject.PduPortCurEntity;
import com.edu.ahu.classroom.dto.PduControlInfoLogDTO;
import com.edu.ahu.classroom.dto.PduSettingInfoLogDTO;
import com.edu.ahu.classroom.dto.PduWarmInfoDTO;
import com.edu.ahu.classroom.vo.ChartResponse2Vo;
import com.edu.ahu.classroom.vo.OnlineStatusVO;
import com.edu.ahu.classroom.vo.PduDetailInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;


public interface OperationService {

    void singleSwitchOperation(Integer equId, Integer port, Integer mark, Integer userId);

    void someSwitchOperation(List<Integer> euqIds, Integer port, List<Integer> marks, Integer userId);

    ServerResponse checkAll(String type, Integer id);

    void checkOne(Integer id, Integer check);

    ServerResponse cancelAll(String type, Integer id);

    OnlineStatusVO findOnlineStatus(String type, Integer id);

    List<PduDetailInfoVO> detailFindByEquIdAndState(Integer equId, String state);

    Page<PduWarmInfoDTO> warmFindByEquId(Integer equId, Pageable pageable);

    Page<PduSettingInfoLogDTO> settingFindByEquId(Integer equId, Pageable pageable);

    Page<PduControlInfoLogDTO> conFindByEquId(Integer equId, Pageable pageable);

    PduPortCurEntity onePortFindByEquId(Integer equId);

    ChartResponse2Vo currentChart(Date date1, Date date2, Integer equId);

    ChartResponse2Vo voltageChart(Date date1, Date date2, Integer equId);
}
