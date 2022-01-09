package com.edu.ahu.classroom.vo;


import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.dataobject.PduPortCurEntity;
import com.edu.ahu.classroom.dataobject.PduUpdateInfoCurEntity;
import lombok.Data;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 19:49 2018/5/24
 */
@Data
public class PduListVO {

    private PduBaseInfoEntity pduBaseInfo;

    private PduUpdateInfoCurEntity pduUpdateInfoCur;

    private PduPortCurEntity pduPortCur;

    public PduListVO(PduBaseInfoEntity pduBaseInfo, PduUpdateInfoCurEntity pduUpdateInfoCur, PduPortCurEntity pduPortCur) {
        this.pduBaseInfo = pduBaseInfo;
        this.pduUpdateInfoCur = pduUpdateInfoCur;
        this.pduPortCur = pduPortCur;
    }
}
