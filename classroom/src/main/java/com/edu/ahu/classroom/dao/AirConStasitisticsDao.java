package com.edu.ahu.classroom.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author wcw
 * @data 2020/6/13 17:04
 */
@Repository
public class AirConStasitisticsDao {
    @PersistenceContext
    private EntityManager em;

    public List<Integer> getCount(String status, Integer num1, Integer num2){
        String dataSql="SELECT ac.deviceId from AirConStatusCurEntity ac where ac.deviceId >="+num1+" and ac" +
                ".deviceId<="+num2+"and ac.aoc='"+status+"'";
        List<Integer>list=em.createQuery(dataSql,
                Integer.class).getResultList();
        return list;
    }
}
