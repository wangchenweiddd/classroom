package com.edu.ahu.classroom.repository;


import com.edu.ahu.classroom.dataobject.PduSettingInfoLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 10:22 2018/6/8
 */
public interface PduSettingInfoLogRepo extends JpaRepository<PduSettingInfoLogEntity,Integer> {

    @Query("select base.name,setting from PduBaseInfoEntity as base left join PduSettingInfoLogEntity as setting on setting.equId = base.id where base.id = :equId order by setting.updateTime desc ")
    Page<Object[]> findByEquId(@Param("equId") Integer equId, Pageable pageable);

    Page<PduSettingInfoLogEntity>findAll(Pageable pageable);
}
