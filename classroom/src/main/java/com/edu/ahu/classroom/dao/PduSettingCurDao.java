package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import com.edu.ahu.classroom.dataobject.PduSettingCurEntity;
import com.edu.ahu.classroom.dataobject.WeakRoomInfoEntity;
import com.edu.ahu.classroom.vo.PduDetailInfoVO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wcw
 * @data 2020/6/9 21:02
 */
@Repository
public class PduSettingCurDao {

    @PersistenceContext
    private EntityManager em;

    public List<PduDetailInfoVO> findByEquIdAndState(Integer equId, String state){

        String dataSql = "select base,setCur,room " +
                "from PduBaseInfoEntity as base " +
                "left join PduSettingCurEntity as setCur on setCur.equId = base.id " +
                "left join WeakRoomInfoEntity as room on room.id = base.id" +
                " where base.id = :equId and base.state = :state";

        List<Object[]> list = em.createQuery(dataSql,Object[].class)
                .setParameter("equId",equId)
                .setParameter("state",state)
                .getResultList();

        List<PduDetailInfoVO> pduDetailInfoVOList = new ArrayList<>();

        list.forEach(e -> pduDetailInfoVOList.add(convert(e)));

        return pduDetailInfoVOList;
    }

    private PduDetailInfoVO convert(Object[] e){

        return new PduDetailInfoVO(
                (PduBaseInfoEntity)e[0],
                (PduSettingCurEntity)e[1],
                (WeakRoomInfoEntity)e[2]
        );
    }
}

