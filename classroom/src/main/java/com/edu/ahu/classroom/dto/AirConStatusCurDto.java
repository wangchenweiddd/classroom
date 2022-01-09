package com.edu.ahu.classroom.dto;

import com.edu.ahu.classroom.dataobject.AirConInfoEntity;
import com.edu.ahu.classroom.dataobject.AirConStatusCurEntity;
import lombok.Data;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 15:05 2018/11/13
 */
@Data
public class AirConStatusCurDto {

    private AirConStatusCurEntity airConStatusCurEntity; //空调状态表实体

    private AirConInfoEntity airConInfoEntity; //空调信息表实体

    public AirConStatusCurDto(AirConStatusCurEntity airConStatusCurEntity, AirConInfoEntity airConInfoEntity) {
        this.airConStatusCurEntity = airConStatusCurEntity;
        this.airConInfoEntity = airConInfoEntity;
    }

}
