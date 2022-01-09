package com.edu.ahu.classroom.enums;

import lombok.Getter;

/**
 * @author wcw
 * @data 2020/5/26 17:03
 */
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
