package com.edu.ahu.classroom.repository;


import com.edu.ahu.classroom.dataobject.CampusInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CampusInfoRepo extends JpaRepository<CampusInfoEntity,Integer> {

    List<CampusInfoEntity> findByState(String State);
}
