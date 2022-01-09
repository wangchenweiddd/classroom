package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dto.AirConStatusCurDto;
import com.edu.ahu.classroom.dataobject.AirConInfoEntity;
import com.edu.ahu.classroom.dataobject.AirConStatusCurEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository("airConStatusCurDao")
public class AirConStatusCurDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * 根据房间id获取空调状态信息
     * @param roomIdList
     * @return
     */
    public List<AirConStatusCurDto> findByRoomId(List<Integer> roomIdList){

        String dataSql = "select airConStatusCur,airConInfo " +
                "from AirConStatusCurEntity as airConStatusCur " +
                "join AirConInfoEntity as airConInfo on airConInfo.id = airConStatusCur.deviceId " +
                "join AirConRegionEntity as airConRegion on airConRegion.regionType = 'room' and airConRegion.regionId = airConInfo.roomId " +
                "where airConInfo.roomId in :roomIdList " +
                "order by airConRegion.regionCode asc";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("roomIdList",roomIdList)
                .getResultList();

        List<AirConStatusCurDto> airConStatusCurDtoList = new ArrayList<>();

        list.forEach(e -> airConStatusCurDtoList.add(convert(e)));

        return  airConStatusCurDtoList;
    }

    public List<AirConStatusCurDto> findByRoomIdAndAoc(List<Integer> roomIdList, String aoc){

        String dataSql = "select airConStatusCur,airConInfo " +
                "from AirConStatusCurEntity as airConStatusCur " +
                "join AirConInfoEntity as airConInfo on airConInfo.id = airConStatusCur.deviceId " +
                "join AirConRegionEntity as airConRegion on airConRegion.regionType = 'room' and airConRegion.regionId = airConInfo.roomId " +
                "where airConInfo.roomId in :roomIdList " +
                "and airConStatusCur.aoc = :aoc " +
                "order by airConRegion.regionCode asc";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("roomIdList",roomIdList)
                .setParameter("aoc",aoc)
                .getResultList();

        List<AirConStatusCurDto> airConStatusCurDtoList = new ArrayList<>();

        list.forEach(e -> airConStatusCurDtoList.add(convert(e)));

        return  airConStatusCurDtoList;
    }

    public Long countByRoomId(List<Integer> roomIdList){

        String dataSql="SELECT COUNT(*) " +
                "FROM AirConStatusCurEntity AS airConStatusCur " +
                "JOIN AirConInfoEntity AS airConInfo ON airConInfo.id = airConStatusCur.deviceId " +
                "JOIN AirConRegionEntity AS airConRegion ON airConRegion.regionType='room' AND airConRegion.regionId = airConInfo.roomId " +
                "WHERE airConInfo.roomId IN :roomIdList";

        return em.createQuery(dataSql,Long.class)
                .setParameter("roomIdList",roomIdList)
                .getSingleResult();

    }

    public Long countByRoomIdAndStatus(List<Integer> roomIdList,String status){

        String dataSql="SELECT COUNT(*) FROM " +
                "AirConStatusCurEntity AS airConStatusCur " +
                "JOIN AirConInfoEntity AS airConInfo ON airConInfo.id = airConStatusCur.deviceId " +
                "JOIN AirConRegionEntity AS airConRegion ON airConRegion.regionType='room' AND airConRegion.regionId = airConInfo.roomId " +
                "WHERE airConInfo.roomId IN :roomIdList " +
                "AND airConStatusCur.aoc = :status";

        return em.createQuery(dataSql,Long.class)
                .setParameter("roomIdList",roomIdList)
                .setParameter("status",status)
                .getSingleResult();

    }
    /**
     * 将数据转变成AirConStatusCurDto格式
     * @param e
     * @return
     */
    private AirConStatusCurDto convert(Object[] e){

        return  new AirConStatusCurDto(
                (AirConStatusCurEntity) e[0],
                (AirConInfoEntity) e[1]
        );
    }
}
