package com.edu.ahu.classroom.dataobject;
import lombok.Data;

import javax.persistence.*;
/**
 * @author wcw
 * @data 2020/5/26 20:12
 */
@Data
@Entity
@Table(name = "airconregion")
public class AirConRegionEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="regiontype")
    private String regionType;

    @Column(name="regionid")
    private Integer regionId;

    @Column(name="parentregiontype")
    private String parentRegionType;

    @Column(name="parentregionid")
    private Integer parentRegionId;

    @Column(name="regionname")
    private String regionName;

    @Column(name="regioncode")
    private String regionCode;

    @Column(name="regionfullname")
    private String regionFullName;
}
