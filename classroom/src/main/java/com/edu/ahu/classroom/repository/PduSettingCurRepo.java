package com.edu.ahu.classroom.repository;


import com.edu.ahu.classroom.dataobject.PduSettingCurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 10:12 2018/6/8
 */
public interface PduSettingCurRepo extends JpaRepository<PduSettingCurEntity,Integer> {

    @Query("select setCur from PduSettingCurEntity as setCur where setCur.equId = :equId")
    PduSettingCurEntity findByEquId(@Param("equId") Integer equId);
}
