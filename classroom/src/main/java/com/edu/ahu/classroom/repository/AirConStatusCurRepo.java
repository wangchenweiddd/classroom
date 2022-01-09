package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.AirConStatusCurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/6/14 14:40
 */
public interface AirConStatusCurRepo extends JpaRepository<AirConStatusCurEntity,Integer> {
}
