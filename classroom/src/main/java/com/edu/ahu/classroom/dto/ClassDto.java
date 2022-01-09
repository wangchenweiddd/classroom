package com.edu.ahu.classroom.dto;

import com.edu.ahu.classroom.dataobject.AirConStatusCurEntity;
import com.edu.ahu.classroom.dataobject.NumberCount;
import lombok.Data;

/**
 * @author wcw
 * @data 2020/5/28 10:20
 */
@Data
public class ClassDto {
 private AirConStatusCurEntity airConStatusCurEntity;

 private NumberCount numberCount;

 public ClassDto(AirConStatusCurEntity airConStatusCurEntity,NumberCount numberCount){
  this.airConStatusCurEntity=airConStatusCurEntity;
  this.numberCount=numberCount;
 }

}
