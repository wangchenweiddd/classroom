package com.edu.ahu.classroom.dataobject;
import lombok.Data;

import javax.persistence.*;
/**
 * @author wcw
 * @data 2020/5/26 20:15
 */
@Data
@Entity
@Table(name = "authairconregion")
public class AuthAirConRegionEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="regiontype")
    private String regionType;

    @Column(name="regionid")
    private Integer regionId;

    @Column(name="userid")
    private Integer userId;
}
