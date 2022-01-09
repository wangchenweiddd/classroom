package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.Json.ControllerUserJson;
import com.edu.ahu.classroom.Json.UserPermissionJson;
import com.edu.ahu.classroom.common.Const;
import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dataobject.UserInfoEntity;
import com.edu.ahu.classroom.dataobject.UserPermission;
import com.edu.ahu.classroom.repository.UserPermissionRepository;
import com.edu.ahu.classroom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: wcw
 * @Description:
 * @Date: 2020/5/30 11:11
 */
@RestController
@RequestMapping("/manage/user")
public class UserManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
//    @PostMapping("/login")
//    public ServerResponse login(String username, String password , HttpSession session){
//
//        ServerResponse<UserInfoEntity> response = iUserService.UserInfoCheck(username,password);
//        if (response.isSuccess()){
//            session.setAttribute(Const.CURRENT_USER,response.getData());
//        }
//        return response;
//    }
        @PostMapping("/login")
       public ServerResponse login(@RequestBody ControllerUserJson controllerUserJson){

        ServerResponse<UserInfoEntity> response = iUserService.UserInfoCheck(controllerUserJson.getName(),
                controllerUserJson.getPassword());
        return response;
      }




    /**
     * 用户登出
     * @param session
     * @return
     */
    @PostMapping("/logout")
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 获取用户权限管理信息
     * @return
     */
    @GetMapping("/all/admin")
    public ServerResponse adminAll(){
        return ServerResponse.createBySuccess(userPermissionRepository.findByStatus(1));
    }

    /**
     *
     */
    @PostMapping("/edit")
    public ServerResponse edit(@RequestBody UserPermissionJson userPermissionJson){
        return ServerResponse.createBySuccess();
    }


}
