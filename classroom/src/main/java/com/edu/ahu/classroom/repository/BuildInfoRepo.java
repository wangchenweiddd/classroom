package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.BuildInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wcw
 * @data 2020/6/9 21:14
 */
public interface BuildInfoRepo extends JpaRepository<BuildInfoEntity,Integer> {

    List<BuildInfoEntity> findByPidAndState(Integer pid, String state);
}
