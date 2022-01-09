package com.edu.ahu.classroom.service.impl;

import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import com.edu.ahu.classroom.dataobject.UserOperateEntity;
import com.edu.ahu.classroom.repository.UserInfoRepository;
import com.edu.ahu.classroom.repository.UserOperateRepository;
import com.edu.ahu.classroom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 12:04 2018/11/7
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserInfoRepository userRepository;

    @Autowired
    private UserOperateRepository userOperateRepository;


    @Override
    public ServerResponse<UserInfoEntity> UserInfoCheck(String name, String password) {
       UserInfoEntity userInfoEntity = userRepository.findByName(name);
        if (userInfoEntity== null|| !userInfoEntity.getPassword().equals(password)){
            return ServerResponse.createByErrorMessage("账号或密码错误");
        }
        return ServerResponse.createBySuccessMessage("登陆成功");
//        return ServerResponse.createBySuccess(userInfoEntity);
    }
//       if (userInfoEntity == null || !userInfoEntity.getPassword().equals(password)){
//           return ServerResponse.createByErrorMessage("账号或密码错误");
//       }
//        return ServerResponse.createBySuccess(userInfoEntity);
//    }


    @Override
    public Integer addUserOperate(UserOperateEntity userOperateEntity) {
        UserOperateEntity userOperateEntity1 = userOperateRepository.save(userOperateEntity);
        Integer id = userOperateEntity1.getId();

        return id;
    }
}
