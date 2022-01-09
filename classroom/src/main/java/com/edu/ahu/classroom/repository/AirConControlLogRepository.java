package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.AirConControlLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/5/26 20:17
 */
public interface AirConControlLogRepository extends JpaRepository<AirConControlLogEntity,Integer> {
}
