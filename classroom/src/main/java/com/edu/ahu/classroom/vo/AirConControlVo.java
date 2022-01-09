package com.edu.ahu.classroom.vo;


import com.edu.ahu.classroom.exception.RequestException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 10:26 2018/11/14
 */
@Data
public class AirConControlVo {

    private List<Integer> deviceIdList;
    private AirConControlAttrVo airConControlAttrVo;
    private String description;
    private Integer userId;

    public AirConControlVo(){

    }
    @JsonCreator
    AirConControlVo(
            @JsonProperty("deviceId") List<Integer> deviceIdList,
            @JsonProperty("airConControlAttr") AirConControlAttrVo airConControlAttrVo,
            @JsonProperty("description") String description){
        setDeviceIdList(deviceIdList);
        setAirConControlAttrVo(airConControlAttrVo);
        setDescription(description);
    }

    public List<Integer> getDeviceIdList() {
        return deviceIdList;
    }

    public void setDeviceIdList(List<Integer> deviceIdList) {
        if (deviceIdList.isEmpty())
            throw new RequestException("deviceIdList 不得为 empty");
        this.deviceIdList = deviceIdList;
    }

    public AirConControlAttrVo getAirConControlAttrVo() {
        return airConControlAttrVo;
    }

    public void setAirConControlAttrVo(AirConControlAttrVo airConControlAttrVo) {
        this.airConControlAttrVo = airConControlAttrVo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
