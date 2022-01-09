package com.edu.ahu.classroom.dto;

import com.edu.ahu.classroom.dataobject.*;
import lombok.Data;

@Data
public class AirConControlDto {
    private AirConControlLogEntity airConControlLogEntity;
    private AirConControlCurEntity airConControlCurEntity;
    private AirConInfoEntity airConInfoEntity;
    private GatewayInfoEntity gatewayInfoEntity;
    private UserOperateEntity userOperateEntity;
    private AirConRegionEntity airConRegionEntity;
    public AirConControlDto(AirConControlLogEntity airConControlLogEntity,AirConInfoEntity airConInfoEntity,GatewayInfoEntity gatewayInfoEntity,UserOperateEntity userOperateEntity,AirConRegionEntity airConRegionEntity) {

        this.airConControlLogEntity = airConControlLogEntity;
        this.airConInfoEntity = airConInfoEntity;
        this.gatewayInfoEntity = gatewayInfoEntity;
        this.userOperateEntity = userOperateEntity;
        this.airConRegionEntity = airConRegionEntity;

    }
    public AirConControlDto(AirConControlCurEntity airConControlCurEntity,AirConInfoEntity airConInfoEntity,GatewayInfoEntity gatewayInfoEntity,UserOperateEntity userOperateEntity,AirConRegionEntity airConRegionEntity) {

        this.airConControlCurEntity = airConControlCurEntity;
        this.airConInfoEntity = airConInfoEntity;
        this.gatewayInfoEntity = gatewayInfoEntity;
        this.userOperateEntity = userOperateEntity;
        this.airConRegionEntity = airConRegionEntity;
    }

    public AirConControlLogEntity getAirConControlLogEntity() {
        return airConControlLogEntity;
    }

    public void setAirConControlLogEntity(AirConControlLogEntity airConControlLogEntity) {
        this.airConControlLogEntity = airConControlLogEntity;
    }

    public AirConControlCurEntity getAirConControlCurEntity() {
        return airConControlCurEntity;
    }

    public void setAirConControlCurEntity(AirConControlCurEntity airConControlCurEntity) {
        this.airConControlCurEntity = airConControlCurEntity;
    }

    public AirConInfoEntity getAirConInfoEntity() {
        return airConInfoEntity;
    }

    public void setAirConInfoEntity(AirConInfoEntity airConInfoEntity) {
        this.airConInfoEntity = airConInfoEntity;
    }

    public GatewayInfoEntity getGatewayInfoEntity() {
        return gatewayInfoEntity;
    }

    public void setGatewayInfoEntity(GatewayInfoEntity gatewayInfoEntity) {
        this.gatewayInfoEntity = gatewayInfoEntity;
    }

    public UserOperateEntity getUserOperateEntity() {
        return userOperateEntity;
    }

    public void setUserOperateEntity(UserOperateEntity userOperateEntity) {
        this.userOperateEntity = userOperateEntity;
    }

    public AirConRegionEntity getAirConRegionEntity() {
        return airConRegionEntity;
    }

    public void setAirConRegionEntity(AirConRegionEntity airConRegionEntity) {
        this.airConRegionEntity = airConRegionEntity;
    }
}
