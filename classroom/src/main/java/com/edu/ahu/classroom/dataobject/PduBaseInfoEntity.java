package com.edu.ahu.classroom.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: HDC
 * @Description:
 * @Date: Created in 15:38 2018/5/21
 */
@Entity
@Data
@Table(name = "pdu_base_info")
public class PduBaseInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* ip地址 */
    @Column(name = "ip")
    private String ip;

    /* 当前设备挂载的上级ip地址 */
    @Column(name = "switch_ip")
    private String switchIp;

    /* 设备安装位置 */
    @Column(name = "name")
    private String name;

    /* mac地址 */
    @Column(name = "mac")
    private String mac;

    /* 1端口设备名 */
    @Column(name = "ch1_name")
    private String ch1Name;

    /* 2端口设备名 */
    @Column(name = "ch2_name")
    private String ch2Name;

    /* 3端口设备名 */
    @Column(name = "ch3_name")
    private String ch3Name;

    /* 4端口设备名 */
    @Column(name = "ch4_name")
    private String ch4Name;

    /* 5端口设备名 */
    @Column(name = "ch5_name")
    private String ch5Name;

    /* 6端口设备名 */
    @Column(name = "ch6_name")
    private String ch6Name;

    /* 7端口设备名 */
    @Column(name = "ch7_name")
    private String ch7Name;

    /* 8端口设备名 */
    @Column(name = "ch8_name")
    private String ch8Name;

    /* 安装时间 */
    @Column(name = "create_time")
    private Date createTime;

    /* 附属于建筑ID */
    @Column(name = "build_id")
    private Integer buildId;

    /* 启用 or 弃用 */
    @Column(name = "state")
    private String state;

    /* 最后一次更新时间 */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /* pdu修改标注位：（0 未修改 1 修改） */
    @Column(name = "modify_state")
    private Integer modifyState;

    /* 用户名 */
    @Column(name = "user_name")
    private String username;

    /* 密码 */
    @Column(name = "password")
    private String password;

    /* 勾选控制 （0 未勾选 1 已勾选）*/
    @Column(name = "check_")
    private Integer check;
}
