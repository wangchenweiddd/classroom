package com.edu.ahu.classroom.dataobject;

import javax.persistence.*;

@Entity
@Table(name = "timed_task")
public class TimedTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* 关机时间 */
    @Column(name = "close_time")
    private String closeTime;

    /* 开始时间 */
    @Column(name = "start_time")
    private String startTime;

    /* 结束时间 */
    @Column(name = "end_time")
    private String endTime;

    /* 时间间隔(天) */
    @Column(name = "interval_time")
    private String intervalTime;

    /* 状态 */
    @Column(name = "status")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
