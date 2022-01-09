package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.service.AirConStasitisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcw
 * @data 2020/6/13 19:13
 */
@RestController
@RequestMapping("/statistics")
public class AirConStatisticsController {
    @Autowired
    private AirConStasitisticsService airConStasitisticsService;

    /**
     * 空调图表展示
     * @return
     */
    @GetMapping("/show")
    public ServerResponse getStatistics(){
        return ServerResponse.createBySuccess(airConStasitisticsService.findAll());
    }
}
