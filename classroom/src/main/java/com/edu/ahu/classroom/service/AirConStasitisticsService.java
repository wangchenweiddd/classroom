package com.edu.ahu.classroom.service;

import com.edu.ahu.classroom.dataobject.BuildStatisticsTime;

import java.util.List;

/**
 * @author wcw
 * @data 2020/6/13 17:00
 */
public interface AirConStasitisticsService {
    List<BuildStatisticsTime>findAll();
}
