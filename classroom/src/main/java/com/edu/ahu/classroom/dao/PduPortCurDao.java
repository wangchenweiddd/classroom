package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dataobject.PduPortCurEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author wcw
 * @data 2020/6/9 21:04
 */
@Repository
public class PduPortCurDao {

    @PersistenceContext
    private EntityManager em;

    public List<PduPortCurEntity> findByState(String state) {

        String dataSql = "select portCur " +
                "from CampusInfoEntity as campusInfo" +
                " left join BuildGroupInfoEntity as groupInfo on groupInfo.pid = campusInfo.id" +
                " left join BuildInfoEntity as buildInfo on buildInfo.pid = groupInfo.id" +
                " left join PduBaseInfoEntity as baseInfo on baseInfo.buildId = buildInfo.id" +
                " left join PduUpdateInfoCurEntity as updateInfo on updateInfo.equId = baseInfo.id " +
                " left join PduPortCurEntity as portCur on portCur.equId = baseInfo.id" +
                " where campusInfo.state = :state and baseInfo.state = :state" +
                " order by portCur.equId";

        List<PduPortCurEntity> list = em.createQuery(dataSql, PduPortCurEntity.class)
                .setParameter("state", state)
                .getResultList();

        return list;
    }

    public List<PduPortCurEntity> findByCampusIdAndState(Integer id,String state){

        String dataSql = "select portCur " +
                " from BuildGroupInfoEntity as groupInfo" +
                " left join BuildInfoEntity as buildInfo on buildInfo.pid = groupInfo.id" +
                " left join PduBaseInfoEntity as baseInfo on baseInfo.buildId = buildInfo.id" +
                " left join PduUpdateInfoCurEntity as updateInfo on updateInfo.equId = baseInfo.id " +
                " left join PduPortCurEntity as portCur on portCur.equId = baseInfo.id" +
                " where groupInfo.pid = :id and groupInfo.state = :state and baseInfo.state = :state" +
                " order by portCur.equId";

        List<PduPortCurEntity> list = em.createQuery(dataSql,PduPortCurEntity.class)
                .setParameter("id",id)
                .setParameter("state",state)
                .getResultList();

        return list;
    }

    public List<PduPortCurEntity> findByGroupIdAndState(Integer id, String state){

        String dataSql = "select portCur " +
                " from BuildInfoEntity as buildInfo " +
                " left join PduBaseInfoEntity as baseInfo on baseInfo.buildId = buildInfo.id" +
                " left join PduUpdateInfoCurEntity as updateInfo on updateInfo.equId = baseInfo.id " +
                " left join PduPortCurEntity as portCur on portCur.equId = baseInfo.id" +
                " where buildInfo.pid = :id and buildInfo.state = :state and baseInfo.state = :state" +
                " order by portCur.equId";

        List<PduPortCurEntity> list = em.createQuery(dataSql,PduPortCurEntity.class)
                .setParameter("id",id)
                .setParameter("state",state)
                .getResultList();

        return list;

    }

    public List<PduPortCurEntity> findByBuildIdAndState(Integer id, String state){

        String dataSql = "select portCur " +
                " from PduBaseInfoEntity as baseInfo " +
                " left join PduUpdateInfoCurEntity as updateInfo on updateInfo.equId = baseInfo.id " +
                " left join PduPortCurEntity as portCur on portCur.equId = baseInfo.id" +
                " where baseInfo.buildId = :id and baseInfo.state = :state" +
                " order by portCur.equId";

        List<PduPortCurEntity> list = em.createQuery(dataSql,PduPortCurEntity.class)
                .setParameter("id",id)
                .setParameter("state",state)
                .getResultList();

        return list;

    }

}

