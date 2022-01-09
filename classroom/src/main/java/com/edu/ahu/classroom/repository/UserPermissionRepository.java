package com.edu.ahu.classroom.repository;

import com.edu.ahu.classroom.dataobject.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wcw
 * @data 2020/5/30 21:22
 */
public interface UserPermissionRepository extends JpaRepository<UserPermission,Integer> {
    List<UserPermission>findByStatus(Integer status);
}
