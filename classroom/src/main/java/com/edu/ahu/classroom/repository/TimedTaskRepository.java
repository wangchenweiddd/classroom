package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.TimedTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/5/30 10:29
 */
public interface TimedTaskRepository extends JpaRepository<TimedTaskEntity,Integer> {
}
