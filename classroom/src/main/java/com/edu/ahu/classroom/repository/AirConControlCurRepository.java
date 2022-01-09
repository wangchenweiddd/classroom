package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.AirConControlCurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/5/26 20:16
 */
public interface AirConControlCurRepository extends JpaRepository<AirConControlCurEntity,Integer> {
}
