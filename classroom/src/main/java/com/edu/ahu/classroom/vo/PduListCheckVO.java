package com.edu.ahu.classroom.vo;

import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.dataobject.PduUpdateInfoCurEntity;
import com.edu.ahu.classroom.dto.PduPortCurDTO;
import lombok.Data;


@Data
public class PduListCheckVO {

    private PduBaseInfoEntity pduBaseInfo;

    private PduUpdateInfoCurEntity pduUpdateInfoCur;

    private PduPortCurDTO pduPortCurDTO;
}
