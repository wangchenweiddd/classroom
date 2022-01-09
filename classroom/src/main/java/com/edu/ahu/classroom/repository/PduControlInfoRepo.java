package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.PduControlInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/6/9 20:05
 */
public interface PduControlInfoRepo extends JpaRepository<PduControlInfoEntity,Integer> {

    Page<PduControlInfoEntity> findAll(Pageable pageable);
}
