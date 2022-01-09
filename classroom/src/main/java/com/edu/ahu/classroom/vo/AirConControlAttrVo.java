package com.edu.ahu.classroom.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 10:27 2018/11/14
 */
@Data
public class AirConControlAttrVo {

    private String aoc;                     //开关机
    private Integer temp;                   //温度
    private String model;                   //模式
    private String elecLock;                //电子锁
    public AirConControlAttrVo(){

    }
    @JsonCreator
    AirConControlAttrVo(@JsonProperty("aoc") String aoc,
                        @JsonProperty("temp") String temp,
                        @JsonProperty("model") String model,
                        @JsonProperty("elecLock") String elecLock){
        setAoc(aoc);
        setTemp(temp);
        setModel(model);
        setElecLock(elecLock);
    }


    public String getAoc() {
        return aoc;
    }

    public void setAoc(String aoc) {
        this.aoc = aoc;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = Integer.parseInt(temp);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getElecLock() {
        return elecLock;
    }

    public void setElecLock(String elecLock) {
        this.elecLock = elecLock;
    }

}
