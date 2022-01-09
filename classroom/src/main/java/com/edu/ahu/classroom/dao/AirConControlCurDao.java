package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dto.AirConControlDto;
import com.edu.ahu.classroom.dataobject.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository("airConControlCurDao")
public class AirConControlCurDao {

    @PersistenceContext
    private EntityManager em;

    public List<AirConControlDto> listAirConControlByOperateId(Integer operateId) {

        String hql = "SELECT airConControlCur,airConInfo,gatewayInfo,useroperate,airConRegion FROM "
                + " AirConControlCurEntity AS airConControlCur " +
                "JOIN AirConInfoEntity AS airConInfo  ON airConInfo.id = airConControlCur.deviceId " +
                "JOIN GatewayInfoEntity AS gatewayInfo ON gatewayInfo.id = airConInfo.gatewayId " +
                "JOIN UserOperateEntity AS useroperate ON useroperate.id = airConControlCur.operateId " +
                "JOIN AirConRegionEntity AS airConRegion ON airConRegion.regionId = airConInfo.roomId AND airConRegion.regionType = 'room'" +
                "WHERE airConControlCur.operateId = :operateId " +
                "ORDER BY airConRegion.regionCode ASC";

        List<Object[]> list  =  em.createQuery(hql,Object[].class)
                .setParameter("operateId", operateId)
                .getResultList();

                return objectToAirConControlDto(list);

    }
    private List<AirConControlDto> objectToAirConControlDto(List list){

        List<AirConControlDto> airConControlDtoList = new ArrayList<AirConControlDto>();
        for (Object object : list){
            airConControlDtoList.add(objectToAirConControlDto(object));
        }
        return airConControlDtoList;
    }

    private AirConControlDto objectToAirConControlDto(Object object){
        Object[] obj = (Object[])object;
        return new AirConControlDto(
                (AirConControlCurEntity) obj[0],
                (AirConInfoEntity)obj[1],
                (GatewayInfoEntity)obj[2],
                (UserOperateEntity)obj[3],
                (AirConRegionEntity)obj[4]);
    }
}
