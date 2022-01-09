package com.edu.ahu.classroom.dataobject;

/**
 * @author wcw
 * @data 2020/5/26 15:42
 */

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@Table(name="user_face_info")
@DynamicUpdate
public class UserFaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Integer groupId;

    private String faceId;

    private String name;

    private Integer age;

    private String email;

    private Short gender;

    private String phoneNumber;

    private String createTime;

    private String updateTime;

    private byte[] faceFeature;
}
