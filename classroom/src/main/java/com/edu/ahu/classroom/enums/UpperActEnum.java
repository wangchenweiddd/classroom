package com.edu.ahu.classroom.enums;

import lombok.Getter;

/**
 * @author wcw
 * @data 2020/6/9 21:05
 */
@Getter
public enum  UpperActEnum {

    REBOOT(1,"重启"),
    ON_DELAY(2,"延时开"),
    OFF_DELAY(3,"延时关"),
    REBOOT_DELAY(4,"延时重启"),
    ON(5,"打开"),
    OFF(6,"关闭"),
    PROCESSING(7,"执行中"),
    IGNORE(8,"忽略");

    private final int code;
    private final String desc;

    UpperActEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
