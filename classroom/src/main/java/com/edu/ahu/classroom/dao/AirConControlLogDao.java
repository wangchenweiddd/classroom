package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dto.AirConControlDto;
import com.edu.ahu.classroom.dataobject.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository("airConControlLogDao")
public class AirConControlLogDao {

    @PersistenceContext
    private EntityManager em;

    public Long countAirConControlByOperateId(Integer operateId,String status){
        String countSql="SELECT count(*) " +
                "FROM AirConControlLogEntity AS airConControlLog "+
                "WHERE airConControlLog.operateId =:operateId "+
                "AND airConControlLog.status = :status ";

        return em.createQuery(countSql,Long.class)
                .setParameter("operateId",operateId)
                .setParameter("status",status)
                .getSingleResult();
    }

    public Long countAirConControlByOperateId(Integer operateId){
        String hql="SELECT count(*) FROM "
                +"AirConControlCurEntity AS airConControlCur "+
                "WHERE airConControlCur.operateId = :operateId";

        return em.createQuery(hql,Long.class)
                .setParameter("operateId",operateId)
                .getSingleResult();
    }

    public List<AirConControlDto> listAirConControlByOperateId(Integer operateId, String status){
        String hql="SELECT airConControlLog,airConInfo,gatewayInfo,useroperate,airConRegion FROM "
                +"AirConControlLogEntity AS airConControlLog "+
                "JOIN AirConInfoEntity AS airConInfo  ON airConInfo.id = airConControlLog.deviceId "+
                "JOIN GatewayInfoEntity AS gatewayInfo ON gatewayInfo.id = airConInfo.gatewayId "+
                "JOIN UserOperateEntity AS useroperate ON useroperate.id = airConControlLog.operateId " +
                "JOIN AirConRegionEntity AS airConRegion ON airConRegion.regionId = airConInfo.roomId AND airConRegion.regionType = 'room'"+
                "WHERE airConControlLog.operateId = :operateId "+
                "AND airConControlLog.status = :status "+
                "ORDER BY airConRegion.regionCode ASC";

        List<Object[]> list = em.createQuery(hql,Object[].class)
                .setParameter("operateId",operateId)
                .setParameter("status",status)
                .getResultList();

        return objectToAirConControlDto(list);
    }


    public List<AirConControlDto> listAirConControlByOperateId(Integer operateId) {

        String dataSql="SELECT airConControlLog,airConInfo,gatewayInfo,useroperate,airConRegion FROM "
                +"AirConControlLogEntity AS airConControlLog "+
                "JOIN AirConInfoEntity AS airConInfo  ON airConInfo.id = airConControlLog.deviceId "+
                "JOIN GatewayInfoEntity AS gatewayInfo ON gatewayInfo.id = airConInfo.gatewayId "+
                "JOIN UserOperateEntity AS useroperate ON useroperate.id = airConControlLog.operateId " +
                "JOIN AirConRegionEntity AS airConRegion ON airConRegion.regionId = airConInfo.roomId AND airConRegion.regionType = 'room'"+
                "WHERE airConControlLog.operateId = :operateId "+
                "ORDER BY airConRegion.regionCode ASC,airConControlLog.status DESC";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
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
                (AirConControlLogEntity)obj[0],
                (AirConInfoEntity)obj[1],
                (GatewayInfoEntity)obj[2],
                (UserOperateEntity)obj[3],
                (AirConRegionEntity)obj[4]);
    }
}
