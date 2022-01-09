package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dataobject.AirConStatusCurEntity;
import com.edu.ahu.classroom.dataobject.NumberCount;
import com.edu.ahu.classroom.dto.ClassDto;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wcw
 * @data 2020/5/28 10:43
 */
@Repository
public class GetClassMessageDao {
    @PersistenceContext
    private EntityManager em;


//    public List<ClassDto> getNum(Integer userId){
//        StringBuffer sqlBf=new StringBuffer();
//        sqlBf.append("select ");
//    }

    /**
     * 根据房间id获取空调状态信息
     * @param roomIdList
     * @return
     */
    public List<ClassDto>findClassByRoomId(List<Integer>roomIdList){
        String dataSql="select airConStatusCur,numCount from AirConStatusCurEntity as airConStatusCur " +
                "join NumberCount as numCount on airConStatusCur.deviceId=numCount.deviceId " +
                "join AirConRegionEntity as airConRegion on airConRegion.regionType = 'room' " +
                "and airConRegion.regionId = numCount.id " +
                "where numCount.id in :roomIdList " +
                "order by airConRegion.regionCode asc";
        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("roomIdList",roomIdList)
                .getResultList();

        List<ClassDto>classDtoList=new ArrayList<>();
        list.forEach(e->classDtoList.add(convert(e)));
        return classDtoList;
    }

    private ClassDto convert(Object[]e){
        return new ClassDto(
                (AirConStatusCurEntity)e[0],
                (NumberCount)e[1]
        );
    }

    /**
     * 当教室人数为0时，设置关闭空调
     * @return
     */
    public List<Integer>findByClassNumZero(Integer num){
        String dataSql="select acinfo.id from AirConInfoEntity acinfo,NumberCount nc,AirConStatusCurEntity acstatus " +
                "where acinfo.roomId =nc.Id and acinfo.id = acstatus.deviceId " +
                "and nc.NumCount ="+num+"and acstatus.aoc= '开机'";
        List<Integer>list=em.createQuery(dataSql,
                Integer.class).getResultList();
        return list;

    }


}
