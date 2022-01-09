package com.edu.ahu.classroom.vo;

import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.dataobject.PduSettingCurEntity;
import com.edu.ahu.classroom.dataobject.WeakRoomInfoEntity;
import lombok.Data;

/**
 * @author wcw
 * @data 2020/6/9 19:45
 */
@Data
public class PduDetailInfoVO {
    private PduBaseInfoEntity pduBaseInfoEntity;

    private PduSettingCurEntity pduSettingCurEntity;

    private WeakRoomInfoEntity weakRoomInfoEntity;


    public PduDetailInfoVO(PduBaseInfoEntity pduBaseInfoEntity, PduSettingCurEntity pduSettingCurEntity, WeakRoomInfoEntity weakRoomInfoEntity) {
        this.pduBaseInfoEntity = pduBaseInfoEntity;
        this.pduSettingCurEntity = pduSettingCurEntity;
        this.weakRoomInfoEntity = weakRoomInfoEntity;
    }
}
