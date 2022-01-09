package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.PduControlInfoLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author wcw
 * @data 2020/6/9 20:57
 */
public interface PduControlInfoLogRepo extends JpaRepository<PduControlInfoLogEntity,Integer> {

    @Query("select base.name ,control from PduBaseInfoEntity as base left join PduControlInfoLogEntity as control on base.id = control.equId where base.id = :equId order by control.controlTime desc ")
    Page<Object[]> findByEquId(@Param("equId") Integer equId, Pageable pageable);

    Page<PduControlInfoLogEntity>findAll(Pageable pageable);
}
