package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dto.AirConLogDto;
import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import com.edu.ahu.classroom.dataobject.UserOperateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("airConOperateDao")
public class AirConOperateDao {

    @PersistenceContext
    private EntityManager em;

    public List<AirConLogDto> listUserOperateByAdministrator(Date startTime, Date endTime){
        Timestamp startTimes= new Timestamp(startTime.getTime());
        Timestamp endTimes= new Timestamp(endTime.getTime());
        String hql=" SELECT userOperate , userInfo FROM UserOperateEntity AS userOperate  " +
                "JOIN UserInfoEntity AS  userInfo ON userInfo.id=userOperate.userId " +
                "WHERE userOperate.createTime >= :startTimes " +
                "AND userOperate.createTime <= :endTimes " +
                "ORDER BY userOperate.id DESC";
        List<Object[]> list = em.createQuery(hql,Object[].class)
                .setParameter("startTimes",startTimes)
                .setParameter("endTimes",endTimes)
                .getResultList();

        return objectToAirConLogDto(list);
    }

    private List<AirConLogDto> objectToAirConLogDto(List list){
        List<AirConLogDto> airConLogDtoList = new ArrayList<AirConLogDto>();
        for (Object object : list){
            airConLogDtoList.add(objectToAirConLogDto(object));
        }
        return airConLogDtoList;
    }

    private AirConLogDto objectToAirConLogDto(Object object){
        Object[] obj = (Object[])object;
        return new AirConLogDto(
                (UserOperateEntity)obj[0],
                (UserInfoEntity)obj[1]);
    }
}
