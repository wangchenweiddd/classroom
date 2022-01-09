package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.PduWarmInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 10:23 2018/6/8
 */
public interface PduWarmInfoRepo extends JpaRepository<PduWarmInfoEntity,Integer> {

    @Query("select base.name,warm from PduBaseInfoEntity as base left join PduWarmInfoEntity as warm on warm.equId = base.id where base.id = :equId order by warm.updateTime desc ")
    Page<Object[]> findByEquId(@Param("equId") Integer equId, Pageable pageable);
}
