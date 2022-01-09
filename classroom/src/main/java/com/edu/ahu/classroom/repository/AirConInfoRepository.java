package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.AirConInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/5/26 20:18
 */
public interface AirConInfoRepository extends JpaRepository<AirConInfoEntity,Integer> {
}
