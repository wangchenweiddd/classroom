package com.edu.ahu.classroom.dao;


import com.edu.ahu.classroom.utils.DateTranUtil;
import com.edu.ahu.classroom.vo.ChartResponse2Vo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class PduUpdateInfoLogDao {

    @PersistenceContext
    private EntityManager em;

    public ChartResponse2Vo currentChart(Date startTime, Date endTime, Integer equId){

        String dataSql = " select log.updateTime,log.i" +
                " from PduUpdateInfoLogEntity as log " +
                "where log.updateTime >= :startTime and log.updateTime <= :endTime and log.equId = :equId";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("startTime",startTime)
                .setParameter("endTime",endTime)
                .setParameter("equId",equId)
                .getResultList();

        List<Object> xValue = new ArrayList<>();

        List<Object> yValue = new ArrayList<>();

        list.forEach(e -> { xValue.add(DateTranUtil.dateToStamp((Date) e[0]));yValue.add(e[1]);});

        return new ChartResponse2Vo(xValue,yValue);
    }

    public ChartResponse2Vo voltageChart(Date startTime, Date endTime,Integer equId){

        String dataSql = " select log.updateTime,log.u " +
                "from PduUpdateInfoLogEntity as log " +
                "where log.updateTime >= :startTime and log.updateTime <= :endTime and log.equId = :equId";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("startTime",startTime)
                .setParameter("endTime",endTime)
                .setParameter("equId",equId)
                .getResultList();

        List<Object> xValue = new ArrayList<>();

        List<Object> yValue = new ArrayList<>();

        list.forEach(e -> { xValue.add(DateTranUtil.dateToStamp((Date) e[0]));yValue.add(e[1]);});

        return new ChartResponse2Vo(xValue,yValue);
    }
}
