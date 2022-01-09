package com.edu.ahu.classroom.dao;

import java.util.ArrayList;
import java.util.List;

import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.dataobject.PduPortCurEntity;
import com.edu.ahu.classroom.dataobject.PduSettingCurEntity;
import com.edu.ahu.classroom.dataobject.PduUpdateInfoCurEntity;
import com.edu.ahu.classroom.vo.PduList2VO;
import com.edu.ahu.classroom.vo.PduListVO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * @author wcw
 * @data 2020/6/9 21:10
 */
@Repository
public class PduBaseInfoDao {

    @PersistenceContext
    private EntityManager em;

    public Object sumOfPdu(){

        String countSql = " select count( distinct info.ip) from PduBaseInfoEntity as info ";

        Object sum = em.createQuery(countSql,Object.class).getSingleResult();

        return sum;
    }

    public Object sumOfBuild(){

        String countSql = " select count( distinct info.buildId) from PduBaseInfoEntity as info ";

        Object sum = em.createQuery(countSql,Object.class).getSingleResult();

        return sum;
    }

    public Object sumOfWeakRoom(){

        String countSql = " select count( distinct info.name) from PduBaseInfoEntity as info ";

        Object sum = em.createQuery(countSql,Object.class).getSingleResult();

        return sum;
    }

    public List<PduListVO> findByPidAndState(Integer id, String state){

        String dataSql = "select distinct baseInfo,updateInfo,portCur " +
                " from PduBaseInfoEntity as baseInfo " +
                " left join PduUpdateInfoCurEntity as updateInfo on updateInfo.equId = baseInfo.id " +
                " left join PduPortCurEntity as portCur on portCur.equId = baseInfo.id" +
                " where baseInfo.buildId = :id and baseInfo.state = :state" +
                " order by baseInfo.id";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("id",id)
                .setParameter("state",state)
                .getResultList();

        List<PduListVO> pduListVOList = new ArrayList<>();

        list.forEach(e-> pduListVOList.add(convert(e)));

        return pduListVOList;
    }

    public List<PduList2VO>findByPidAndState2(Integer id, String state){

        String dataSql = "select distinct baseInfo,setCur " +
                "from PduBaseInfoEntity as baseInfo " +
                "left join PduSettingCurEntity as setCur on baseInfo.id = setCur.equId " +
                "where baseInfo.id = :id and baseInfo.state = :state " +
                "order by baseInfo.id";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("id",id)
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

    private PduList2VO convert2(Object[] e) {
        return new PduList2VO(
                (PduBaseInfoEntity) e[0],
                (PduSettingCurEntity) e[1]
        );
    }
}