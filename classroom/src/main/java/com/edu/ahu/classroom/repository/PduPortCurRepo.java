package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.PduPortCurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author wcw
 * @data 2020/6/9 20:04
 */
public interface PduPortCurRepo extends JpaRepository<PduPortCurEntity,Integer> {

    PduPortCurEntity findByEquId(Integer equId);

    @Query("select count (cur.equId) from PduPortCurEntity as cur")
    Integer findAllNum();
}
