package com.edu.ahu.classroom.dao;


import com.edu.ahu.classroom.Json.SmartCloseJson;
import com.edu.ahu.classroom.Json.TimedTaskJson;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wcw
 * @data 2020/5/30 10:32
 */
@Repository("timedTaskDao")
public class TimedTaskDao  {
    @PersistenceContext
    private EntityManager em;

    /**
     * 更新根据人数关闭的操作信息
     * @param lock
     * @param model
     * @param temp
     * @param num
     */
    @Transactional
    public void updateSmartClose(String lock,String model,String temp,Integer num){
        String dataSql="Update SmartClose SET lock='"+lock+"',model ='"+model+"',temp = '"+temp+"',num = "+num+"WHERE id =" +
                " 1";
        em.createQuery(dataSql)
                .executeUpdate();
    }

    /**
     * 获取根据设置的人数来关闭设备
     * @return
     */
    public Integer getNumCount(){
        String dataSql="select sc.num from SmartClose sc where sc.id=1";
        Integer num= (Integer) em.createQuery(dataSql).getSingleResult();
        return num;
    }

    public List<SmartCloseJson> getSmartCloseConfig(){
        String dataSql="select sc.lock,sc.model,sc.temp,sc.num from SmartClose sc" +
                " where sc.id=1";
        List<Object[]>list=em.createQuery(dataSql,Object[].class).getResultList();
        List<SmartCloseJson>smartCloseJsons=new ArrayList<>();
        list.forEach(e->smartCloseJsons.add(Convert(e)));
        return smartCloseJsons;

    }

    private  SmartCloseJson Convert(Object[]e){
        return new SmartCloseJson(
                (String)e[0],
                (String)e[1],
                (String)e[2],
                (Integer)e[3]
        );
    }

    /**
     * 更新定时任务
     * @param status
     */
    @Transactional
    public void updateStatus(String status){
        String dataSql = "UPDATE TimedTaskEntity SET status = :status WHERE id = 1";
        em.createQuery(dataSql).setParameter("status",status).executeUpdate();
    }


    /**
     * 更新定时任务信息
     * @param closeTime
     * @param startTime
     * @param endTime
     * @param intervalTime
     * @param status
     */
    @Transactional
    public void updateTimedTask(String closeTime,String startTime,String endTime,String intervalTime,String status) {
        String dataSql = "UPDATE TimedTaskEntity " +
                "SET closeTime = :closeTime,startTime = :startTime," +
                "endTime = :endTime," +
                "intervalTime = :intervalTime," +
                "status = :status WHERE id = 1";
        em.createQuery(dataSql).setParameter("status", status)
                .setParameter("closeTime", closeTime)
                .setParameter("startTime", startTime)
                .setParameter("endTime", endTime)
                .setParameter("intervalTime", intervalTime)
                .executeUpdate();
    }

    /**
     * 获取定时任务更新信息
     * @return
     */
    public List<TimedTaskJson>getTimedTask(){
        String dataSql="select tt.closeTime,tt.startTime,tt.endTime,tt.intervalTime,tt.status from TimedTaskEntity tt" +
                " where tt.id=1";
        List<Object[]>list=em.createQuery(dataSql,Object[].class).getResultList();
        List<TimedTaskJson>timedTaskJsons=new ArrayList<>(list.size());
        list.forEach(e->timedTaskJsons.add(TimedTaskConvert(e)));
        return timedTaskJsons;

    }

    private TimedTaskJson TimedTaskConvert(Object[]e){
        return new TimedTaskJson(
                (String)e[0],
                (String)e[1],
                (String)e[2],
                (String)e[3],
                (String)e[4]
        );
    }



}
