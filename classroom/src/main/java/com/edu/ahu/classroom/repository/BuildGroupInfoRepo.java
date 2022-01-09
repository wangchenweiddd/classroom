package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.BuildGroupInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wcw
 * @data 2020/6/9 21:12
 */
public interface BuildGroupInfoRepo extends JpaRepository<BuildGroupInfoEntity,Integer> {

    List<BuildGroupInfoEntity> findByPidAndState(Integer pid, String state);
}
