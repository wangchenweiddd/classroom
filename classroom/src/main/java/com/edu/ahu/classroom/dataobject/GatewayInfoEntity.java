package com.edu.ahu.classroom.dataobject;
import lombok.Data;

import javax.persistence.*;
/**
 * @author wcw
 * @data 2020/5/26 20:15
 */

@Data
@Entity
@Table(name = "gatewayinfo")
public class GatewayInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;         //网关id

    @Column(name = "ip")
    private String ip;          //网关ip

    @Column(name = "name")
    private String name;        //网关名称

    @Column(name = "port")
    private Integer port;       //通信端口

    @Column(name = "ip2")
    private String ip2;

    @Column(name = "username")
    private String username;

    @Column(name = "passwd")
    private String password;

    @Column(name = "build_id")
    private Integer buildId;    //建筑Id

    @Column(name = "group_id")
    private Integer groupId;    //建筑群Id

    @Column(name = "campus_id")
    private Integer campusId;   //校区Id
}
