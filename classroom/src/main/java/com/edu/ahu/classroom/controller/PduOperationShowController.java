package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.Json.ControllerUserJson;
import com.edu.ahu.classroom.common.Const;
import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.exception.RequestException;
import com.edu.ahu.classroom.exception.RequestParamCheck;
import com.edu.ahu.classroom.service.*;
import com.edu.ahu.classroom.vo.TreeResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author wcw
 * @data 2020/6/9 19:15
 */

@RestController
@RequestMapping(value = "/operation/show")
public class PduOperationShowController {
    @Autowired
    private CampusInfoService campusInfoService;

    @Autowired
    private BuildGroupInfoService buildGroupInfoService;

    @Autowired
    private BuildInfoService buildInfoService;

    @Autowired
    private PduBaseInfoService pduBaseInfoService;

    @Autowired
    private OperationService operationService;

    /**
     * 控制与展示—列表展示—树数据
     * @param controllerUserJson
     * @return
     */
    @PostMapping("/tree")
    public List<TreeResponseVo> treeShow(@RequestBody ControllerUserJson controllerUserJson){

        List<TreeResponseVo> treeResponseVoList = new ArrayList<>();
        if (controllerUserJson.getType() == null || controllerUserJson.getId() == null)
            campusInfoService.findByStateTwo(Const.STATUS_ENABLE).forEach(e-> treeResponseVoList.add(new TreeResponseVo(e,true)));
         if (controllerUserJson.getType() .equals("campus"))
            buildGroupInfoService.findByPidAndStateTwo(controllerUserJson.getId(),Const.STATUS_ENABLE).forEach(e-> treeResponseVoList.add(new TreeResponseVo(e,true)));
        else if (controllerUserJson.getType() .equals("group"))
            buildInfoService.findByPidAndStateTwo(controllerUserJson.getId(),Const.STATUS_ENABLE).forEach(e-> treeResponseVoList.add(new TreeResponseVo(e,false)));
        else
            throw new RequestException("参数非法，建筑类型非法");

        return treeResponseVoList;
    }

    /**
     * 控制与展示—列表展示—列表数据
     * @param controllerUserJson
     * @return
     */
    @PostMapping("/list")
    public ServerResponse listShow(@RequestBody ControllerUserJson controllerUserJson) {
        switch(controllerUserJson.getType()){
            case "school":
                return ServerResponse.createBySuccess(campusInfoService.findBySelectAndState(controllerUserJson.getSelect(),
                        Const.STATUS_ENABLE));
            case "campus":
                return ServerResponse.createBySuccess(buildGroupInfoService.findByPidAndSelectAndState(controllerUserJson.getId(), controllerUserJson.getSelect(),
                        Const.STATUS_ENABLE));
            case "group":
                return ServerResponse.createBySuccess(buildInfoService.findByPidAndSelectAndState(controllerUserJson.getId(), controllerUserJson.getSelect(),Const.STATUS_ENABLE));
            case "build":
                return ServerResponse.createBySuccess(pduBaseInfoService.findByPidAndState(controllerUserJson.getId(), Const.STATUS_ENABLE));
            default:
                throw new RequestException("参数非法，建筑类型非法");
        }
    }



//    @GetMapping("/list")
//    public ServerResponse listShow(String type, Integer id, String select) {
//        //检查参数是否为空
//        RequestParamCheck.checkNull(type, "type");
//        RequestParamCheck.checkNull(id, "id");
//        RequestParamCheck.checkNull(select, "select");
//
//        switch (type) {
//            case "school":
//                return ServerResponse.createBySuccess(campusInfoService.findBySelectAndState(select, Const.STATUS_ENABLE));
//            case "campus":
//                return ServerResponse.createBySuccess(buildGroupInfoService.findByPidAndSelectAndState(id, select, Const.STATUS_ENABLE));
//            case "group":
//                return ServerResponse.createBySuccess(buildInfoService.findByPidAndSelectAndState(id, select, Const.STATUS_ENABLE));
//            case "build":
//                return ServerResponse.createBySuccess(pduBaseInfoService.findByPidAndState(id, Const.STATUS_ENABLE));
//            default:
//                throw new RequestException("参数非法，建筑类型非法");
//        }
//    }

    /**
     * 控制与展示—设备控制—单开关操作
     * @param controllerUserJson
     * @return
     */
    @Transactional
    @PostMapping(value = "/single/switch")
    public ServerResponse singleSwitchOperation(@RequestBody ControllerUserJson controllerUserJson){

        //port:5--打开  6--关闭  mark：1口代表lightOne，2口代表linghtTwo
        RequestParamCheck.checkNull(controllerUserJson.getEquId(), "equId");
        RequestParamCheck.checkNull(controllerUserJson.getPort(), "port");
        RequestParamCheck.checkNull(controllerUserJson.getMark(), "mark");

        //160暂时使用
        operationService.singleSwitchOperation(controllerUserJson.getEquId(),controllerUserJson.getPort(),controllerUserJson.getMark(),160);
        return ServerResponse.createBySuccessMessage("成功");
    }

    /**
     * 控制与展示—列表展示—在线状态
     * @return
     */
    @PostMapping("/line/status")
    public ServerResponse lineStatus(@RequestBody ControllerUserJson controllerUserJson){

        RequestParamCheck.checkNull(controllerUserJson.getType(), "type");
        RequestParamCheck.checkNull(controllerUserJson.getId(), "id");

        return ServerResponse.createBySuccess(operationService.findOnlineStatus(controllerUserJson.getType(),controllerUserJson.getId()));
    }

    /**
     * 控制与展示—设备控制—全选
     * @return
     */
    @PostMapping("/check/all")
    @Transactional
    public ServerResponse checkAll(@RequestBody ControllerUserJson controllerUserJson){

        RequestParamCheck.checkNull(controllerUserJson.getType(), "type");
        RequestParamCheck.checkNull(controllerUserJson.getId(), "id");

        return operationService.checkAll(controllerUserJson.getType(),controllerUserJson.getId());
    }

    /**
     * 控制与展示—设备控制—单选
     * @return
     */
    @PostMapping("/check/one")
    @Transactional
    public ServerResponse checkOne(@RequestBody ControllerUserJson controllerUserJson){

        RequestParamCheck.checkNull(controllerUserJson.getId(), "id");
        RequestParamCheck.checkNull(controllerUserJson.getCheck(), "check");

        operationService.checkOne(controllerUserJson.getId(), controllerUserJson.getCheck());

        return ServerResponse.createBySuccessMessage("成功");
    }

    /**
     * 控制与展示—设备控制—全部取消
     * @return
     */
    @PostMapping("/cancel/all")
    @Transactional
    public ServerResponse cancelAll(@RequestBody ControllerUserJson controllerUserJson){

        RequestParamCheck.checkNull(controllerUserJson.getType(), "type");
        RequestParamCheck.checkNull(controllerUserJson.getId(), "id");

        return operationService.cancelAll(controllerUserJson.getType(), controllerUserJson.getId());
    }

    /**
     * 控制与展示—设备控制—批量操作
     * @param controllerUserJson
     * @return
     */
    @Transactional
    @PostMapping("/some/switch")
//    public ServerResponse someSwitchOperation(@RequestParam("equIds") List<Integer> equIds,
//                                              @RequestParam("port") Integer port,
//                                              @RequestParam("marks") List<Integer> marks){

    public ServerResponse someSwitchOperation(@RequestBody ControllerUserJson controllerUserJson){
        RequestParamCheck.checkNull(controllerUserJson.getEquIds(), "equIds");
        RequestParamCheck.checkNull(controllerUserJson.getPort(), "port");
        RequestParamCheck.checkNull(controllerUserJson.getMarks(), "marks");

        operationService.someSwitchOperation(controllerUserJson.getEquIds(),controllerUserJson.getPort(),
                controllerUserJson.getMarks(),160);

        return ServerResponse.createBySuccessMessage("成功");
    }

    /**
     * 控制与展示—列表展示—详情展示
     * @param controllerUserJson
     * @return
     */
    @PostMapping("/detail/info")
    public ServerResponse showDetailInfo(@RequestBody ControllerUserJson controllerUserJson){

//        UserInfoEntity userInfoEntity = (UserInfoEntity)session.getAttribute(Const.CURRENT_USER);
//        if (userInfoEntity == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),ResponseCodeEnum.NEED_LOGIN.getDesc());
//        }

        RequestParamCheck.checkNull(controllerUserJson.getEquId(), "equId");

        return ServerResponse.createBySuccess(operationService.detailFindByEquIdAndState(controllerUserJson.getEquId(),
                Const.STATUS_ENABLE));

    }

    @PostMapping("/detail/info/warm")
    public ServerResponse showWarInfo(@RequestBody ControllerUserJson controllerUserJson){

        RequestParamCheck.checkNull(controllerUserJson.getEquId(), "equId");
        RequestParamCheck.checkNull(controllerUserJson.getPageNumber(), "pageNumber");
        RequestParamCheck.checkNull(controllerUserJson.getPageSize(), "pageSize");

        Pageable pageable = PageRequest.of(controllerUserJson.getPageNumber() -1 ,controllerUserJson.getPageSize());

        return ServerResponse.createBySuccess(operationService.warmFindByEquId(controllerUserJson.getEquId(),pageable));

    }

    @PostMapping("/detail/info/chart/current")
    public ServerResponse currentChart(@RequestBody ControllerUserJson controllerUserJson){

        RequestParamCheck.checkNull(controllerUserJson.getEquId(), "equId");

        Date date1 = new Date();
        Date date2 = new Date();

        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(date2);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -2);  //设置为前三天
        date1 = calendar.getTime();   //得到前三天的时间

        return ServerResponse.createBySuccess(operationService.currentChart(date1,date2,controllerUserJson.getEquId()));
    }


    @PostMapping("/detail/info/chart/voltage")
    public ServerResponse voltageChart( @RequestBody ControllerUserJson controllerUserJson){

        RequestParamCheck.checkNull(controllerUserJson.getEquId(), "equId");

        Date date1 = new Date();
        Date date2 = new Date();

        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(date2);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -2);  //设置为前三天
        date1 = calendar.getTime();   //得到前三天的时间

        return ServerResponse.createBySuccess(operationService.voltageChart(date1,date2,controllerUserJson.getEquId()));
    }





}
