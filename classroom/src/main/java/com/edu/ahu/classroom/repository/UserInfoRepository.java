package com.edu.ahu.classroom.repository;


import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 12:01 2018/11/7
 */
public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Integer> {

    UserInfoEntity findByName(String name);

    UserInfoEntity findByNameAndPassword(String name,String password);
}
