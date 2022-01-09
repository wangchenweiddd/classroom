package com.edu.ahu.classroom.vo;


import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.dataobject.PduSettingCurEntity;
import lombok.Data;


@Data
public class PduList2VO {

    private PduBaseInfoEntity pduBaseInfoEntity;
    private PduSettingCurEntity pduSettingCurEntity;

    public PduList2VO(PduBaseInfoEntity pduBaseInfoEntity,
                      PduSettingCurEntity pduSettingCurEntity) {
        this.pduBaseInfoEntity = pduBaseInfoEntity;
        this.pduSettingCurEntity = pduSettingCurEntity;
    }
}
