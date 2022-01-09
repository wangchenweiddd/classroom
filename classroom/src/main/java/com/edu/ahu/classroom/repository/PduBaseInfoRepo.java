package com.edu.ahu.classroom.repository;


import com.edu.ahu.classroom.dataobject.PduBaseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 15:51 2018/5/21
 */
public interface PduBaseInfoRepo extends JpaRepository<PduBaseInfoEntity,Integer> {

    List<PduBaseInfoEntity> findByBuildIdAndState(Integer pid, String state);

    @Modifying
    @Query("update PduBaseInfoEntity as info set info.check = :check where info.id in :ids")
    void saveCheck(@Param("ids") List<Integer> ids, @Param("check") Integer check);



}
