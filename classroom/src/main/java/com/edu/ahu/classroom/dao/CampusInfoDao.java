package com.edu.ahu.classroom.dao;



import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.dataobject.PduPortCurEntity;
import com.edu.ahu.classroom.dataobject.PduSettingCurEntity;
import com.edu.ahu.classroom.dataobject.PduUpdateInfoCurEntity;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListVO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CampusInfoDao {

    @PersistenceContext
    private EntityManager em;

    public List<PduListVO> findByState(String state){

        String dataSql = "select distinct baseInfo,updateInfo,portCur " +
                "from CampusInfoEntity as campusInfo" +
                " left join BuildGroupInfoEntity as groupInfo on groupInfo.pid = campusInfo.id" +
                " left join BuildInfoEntity as buildInfo on buildInfo.pid = groupInfo.id" +
                " left join PduBaseInfoEntity as baseInfo on baseInfo.buildId = buildInfo.id" +
                " left join PduUpdateInfoCurEntity as updateInfo on updateInfo.equId = baseInfo.id " +
                " left join PduPortCurEntity as portCur on portCur.equId = baseInfo.id" +
                " where campusInfo.state = :state and baseInfo.state = :state" +
                " order by baseInfo.id";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("state",state)
                .getResultList();

        List<PduListVO> pduListVOList = new ArrayList<>();

        list.forEach(e-> pduListVOList.add(convert(e)));

        return pduListVOList;
    }

    public List<PduList2VO>findByState2(String state){

        String dataSql = "select distinct baseInfo,setCur " +
                "from PduBaseInfoEntity as baseInfo " +
                "left join PduSettingCurEntity as setCur on baseInfo.id = setCur.equId " +
                "left join BuildInfoEntity as buildInfo on baseInfo.buildId = buildInfo.id " +
                "left join BuildGroupInfoEntity as groupInfo on buildInfo.pid = groupInfo.id " +
                "left join CampusInfoEntity as campusInfo on buildInfo.pid = groupInfo.id " +
                "where campusInfo.state = :state and baseInfo.state = :state " +
                "order by baseInfo.id";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("state",state)
                .getResultList();

        List<PduList2VO> pduList2VOList = new ArrayList<>();

        list.forEach(e->pduList2VOList.add(convert2(e)));

        return pduList2VOList;
    }

    private PduListVO convert(Object[] e){
        return new PduListVO(
                (PduBaseInfoEntity)e[0],
                (PduUpdateInfoCurEntity)e[1],
                (PduPortCurEntity)e[2]
        );
    }

    private PduList2VO convert2(Object[] e){
        return new PduList2VO(
                (PduBaseInfoEntity) e[0],
                (PduSettingCurEntity) e[1]
        );
    }
}
