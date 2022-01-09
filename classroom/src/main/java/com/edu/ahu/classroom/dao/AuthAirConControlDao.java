package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dataobject.AuthAirConControlEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


@Repository("authAirConControlDao")
public class AuthAirConControlDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * 根据用户id和时间获得该用户当前时间下的空调控制权限
     * @param userId                    用户id
     * @param time                      当前时间
     * @return                          空调控制权限
     */
    public AuthAirConControlEntity findByUserId(Integer userId, Date time){

        String dataSql = "select authAirConControl " +
                " FROM AuthAirConControlEntity AS authAirConControl" +
                " WHERE authAirConControl.userId = :userId " +
                "AND authAirConControl.startTime <= :time " +
                "AND authAirConControl.endTime >= :time";

        List<AuthAirConControlEntity> list = em.createQuery(dataSql,AuthAirConControlEntity.class)
                .setParameter("userId",userId)
                .setParameter("time",time)
                .getResultList();

        if (list == null || list.isEmpty())
            return null;
        return list.get(0);
    }
}
