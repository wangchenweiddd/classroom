package com.edu.ahu.classroom.vo;

public class AirConControlCountVo {
    private Integer all;
    private Integer executIng;
    private Integer sendFailure;
    private Integer executeSuccess;
    private Integer executeFailure;

    public Integer getExecutIng() {
        return executIng;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public void setExecutIng(Integer executIng) {
        this.executIng = executIng;
    }

    public Integer getSendFailure() {
        return sendFailure;
    }

    public void setSendFailure(Integer sendFailure) {
        this.sendFailure = sendFailure;
    }

    public Integer getExecuteSuccess() {
        return executeSuccess;
    }

    public void setExecuteSuccess(Integer executeSuccess) {
        this.executeSuccess = executeSuccess;
    }

    public Integer getExecuteFailure() {
        return executeFailure;
    }

    public void setExecuteFailure(Integer executeFailure) {
        this.executeFailure = executeFailure;
    }
}
