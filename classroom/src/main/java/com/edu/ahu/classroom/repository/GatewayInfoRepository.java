package com.edu.ahu.classroom.repository;


import com.edu.ahu.classroom.dataobject.GatewayInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/5/26 20:19
 */
public interface GatewayInfoRepository extends JpaRepository<GatewayInfoEntity,Integer> {
}
