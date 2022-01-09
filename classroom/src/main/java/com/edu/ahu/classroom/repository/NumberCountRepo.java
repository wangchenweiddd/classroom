package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.NumberCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wcw
 * @data 2020/6/13 11:20
 */
public interface NumberCountRepo extends JpaRepository<NumberCount,Integer> {
    List<NumberCount>findByPduId(Integer pduId);
}
