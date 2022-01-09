package com.edu.ahu.classroom.vo;

import lombok.Data;

/**
 * @author wcw
 * @data 2020/6/9 19:44
 */

@Data
public class OnlineStatusVO {
    private Integer all;
    private Integer online;
    private Integer offline;

    public OnlineStatusVO(Integer all, Integer online, Integer offline) {
        this.all = all;
        this.online = online;
        this.offline = offline;
    }
}
