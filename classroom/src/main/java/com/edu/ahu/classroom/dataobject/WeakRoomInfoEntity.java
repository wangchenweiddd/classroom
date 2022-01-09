package com.edu.ahu.classroom.dataobject;
import lombok.Data;

import javax.persistence.*;
/**
 * @author wcw
 * @data 2020/6/9 19:58
 */
@Data
@Entity
@Table(name = "weakroominfo")
public class WeakRoomInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* 弱电房所属建筑ID */
    @Column(name = "buildID")
    private Integer buildId;

    /* 弱电房名称 */
    @Column(name = "name")
    private String name;

    /* 弱电房安装位置 */
    @Column(name = "location")
    private String location;
}
