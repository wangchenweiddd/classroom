package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.UserFaceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcw
 * @data 2020/5/26 16:38
 */
public interface UserFaceInfoRepository extends JpaRepository<UserFaceInfo,Integer> {

}
