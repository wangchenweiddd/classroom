package com.edu.ahu.classroom.controller;

import com.edu.ahu.classroom.Json.SmartCloseJson;
import com.edu.ahu.classroom.Json.TimedTaskJson;
import com.edu.ahu.classroom.common.ServerResponse;
import com.edu.ahu.classroom.dao.TimedTaskDao;
import com.edu.ahu.classroom.vo.AirConControlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wcw
 * @data 2020/5/30 16:08
 */
@RestController
@RequestMapping("/config")
public class SmartCloseController {
    @Autowired
    private TimedTaskDao timedTaskDao;

    /**
     * 修改按照人数关闭空调的配置
     * @param smartCloseJson
     * @return
     */
    @PostMapping("/control")
    public ServerResponse airConControl(@RequestBody SmartCloseJson smartCloseJson){
        timedTaskDao.updateSmartClose(smartCloseJson.getLock(),smartCloseJson.getModel(),smartCloseJson.getTemp(),
                smartCloseJson.getNum());
        return ServerResponse.createBySuccess();
    }

    /**
     * 获取按照人数来关闭空调的设置信息
     * @return
     */
    @GetMapping("/get/control")
    public ServerResponse getConfig(){
        return ServerResponse.createBySuccess(timedTaskDao.getSmartCloseConfig());
    }



    /**
     * 更新定时任务信息
     * @param timedTaskJson
     * @return
     */
   @PostMapping("/modify")
    public ServerResponse modiftMessage(@RequestBody TimedTaskJson timedTaskJson){
        timedTaskDao.updateTimedTask(timedTaskJson.getCloseTime(),timedTaskJson.getStartTime(),
                timedTaskJson.getEndTime(),timedTaskJson.getIntervalTime(),timedTaskJson.getStatus());
        return ServerResponse.createBySuccess("修改成功");
   }

    /**
     * 获取定时任务信息
     * @return
     */
   @GetMapping("/get/task")
    public ServerResponse getTask(){
       return ServerResponse.createBySuccess(timedTaskDao.getTimedTask());
   }








}
