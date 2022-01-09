package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.dao.AirConStasitisticsDao;
import com.edu.ahu.classroom.dataobject.BuildStatisticsTime;
import com.edu.ahu.classroom.repository.BuildStatisticsTimeRepo;
import com.edu.ahu.classroom.service.AirConStasitisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wcw
 * @data 2020/6/13 17:00
 */
@Service
public class AirConStasitisticsServiceImpl implements AirConStasitisticsService {
    @Autowired
    private AirConStasitisticsDao airConStasitisticsDao;

    @Autowired
    private BuildStatisticsTimeRepo buildStatisticsTimeRepo;

    @Override
    public List<BuildStatisticsTime> findAll() {
        BuildStatisticsTime bonanA=buildStatisticsTimeRepo.findById(5).orElse(null);
        Integer open=(airConStasitisticsDao.getCount("开机",1,36)).size();
        Integer close=(airConStasitisticsDao.getCount("关机",1,36)).size();
        Integer offline=(airConStasitisticsDao.getCount("离线",1,36)).size();
        bonanA.setOpend(open);
        bonanA.setClosed(close);
        bonanA.setOffline(offline);
        buildStatisticsTimeRepo.save(bonanA);

        BuildStatisticsTime bonanB=buildStatisticsTimeRepo.findById(6).orElse(null);
        Integer open2=(airConStasitisticsDao.getCount("开机",37,109)).size();
        Integer close2=(airConStasitisticsDao.getCount("关机",37,109)).size();
        Integer offline2=(airConStasitisticsDao.getCount("离线",37,109)).size();
        bonanB.setOpend(open2);
        bonanB.setClosed(close2);
        bonanB.setOffline(offline2);
        buildStatisticsTimeRepo.save(bonanB);

        BuildStatisticsTime bonanC=buildStatisticsTimeRepo.findById(7).orElse(null);
        Integer open3=(airConStasitisticsDao.getCount("开机",110,182)).size();
        Integer close3=(airConStasitisticsDao.getCount("关机",110,182)).size();
        Integer offline3=(airConStasitisticsDao.getCount("离线",110,182)).size();
        bonanC.setOpend(open3);
        bonanC.setClosed(close3);
        bonanC.setOffline(offline3);
        buildStatisticsTimeRepo.save(bonanC);

        BuildStatisticsTime bonanD=buildStatisticsTimeRepo.findById(8).orElse(null);
        Integer open4=(airConStasitisticsDao.getCount("开机",183,250)).size();
        Integer close4=(airConStasitisticsDao.getCount("关机",183,250)).size();
        Integer offline4=(airConStasitisticsDao.getCount("离线",183,250)).size();
        bonanD.setOpend(open4);
        bonanD.setClosed(close4);
        bonanD.setOffline(offline4);
        buildStatisticsTimeRepo.save(bonanD);

        BuildStatisticsTime bobeiA=buildStatisticsTimeRepo.findById(1).orElse(null);
        Integer open5=(airConStasitisticsDao.getCount("开机",251,302)).size();
        Integer close5=(airConStasitisticsDao.getCount("关机",251,302)).size();
        Integer offline5=(airConStasitisticsDao.getCount("离线",251,302)).size();
        bobeiA.setOpend(open5);
        bobeiA.setClosed(close5);
        bobeiA.setOffline(offline5);
        buildStatisticsTimeRepo.save(bobeiA);

        BuildStatisticsTime bobeiBD=buildStatisticsTimeRepo.findById(2).orElse(null);
        Integer open6=(airConStasitisticsDao.getCount("开机",451,546)).size();
        Integer close6=(airConStasitisticsDao.getCount("关机",451,546)).size();
        Integer offline6=(airConStasitisticsDao.getCount("离线",451,546)).size();
        bobeiBD.setOpend(open6);
        bobeiBD.setClosed(close6);
        bobeiBD.setOffline(offline6);
        buildStatisticsTimeRepo.save(bobeiBD);

        BuildStatisticsTime bobeiBS=buildStatisticsTimeRepo.findById(3).orElse(null);
        Integer open7=(airConStasitisticsDao.getCount("开机",355,450)).size();
        Integer close7=(airConStasitisticsDao.getCount("关机",355,450)).size();
        Integer offline7=(airConStasitisticsDao.getCount("离线",355,450)).size();
        bobeiBS.setOpend(open7);
        bobeiBS.setClosed(close7);
        bobeiBS.setOffline(offline7);
        buildStatisticsTimeRepo.save(bobeiBS);

        BuildStatisticsTime bobeiC=buildStatisticsTimeRepo.findById(4).orElse(null);
        Integer open8=(airConStasitisticsDao.getCount("开机",303,350)).size();
        Integer close8=(airConStasitisticsDao.getCount("关机",303,350)).size();
        Integer offline8=(airConStasitisticsDao.getCount("离线",303,350)).size();
        bobeiC.setOpend(open8);
        bobeiC.setClosed(close8);
        bobeiC.setOffline(offline8);
        buildStatisticsTimeRepo.save(bobeiC);

        return buildStatisticsTimeRepo.findAll();
    }
}
