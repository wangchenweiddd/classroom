package com.edu.ahu.classroom.vo;

import com.edu.ahu.classroom.dataobject.BuildGroupInfoEntity;
import com.edu.ahu.classroom.dataobject.BuildInfoEntity;
import com.edu.ahu.classroom.dataobject.CampusInfoEntity;
import lombok.Data;

/**
 * @author wcw
 * @data 2020/6/9 19:15
 */
@Data
public class TreeResponseVo {
    private String pid;
    private String name;
    private Boolean isParent;
    private String type;
    private Integer id;

    public TreeResponseVo(CampusInfoEntity campusInfoEntity, Boolean isParent) {
        this.pid = "school_0";
        this.name = campusInfoEntity.getName();
        this.isParent = isParent;
        this.id = campusInfoEntity.getId();
        this.type = campusInfoEntity.getType();
    }

    public TreeResponseVo(BuildGroupInfoEntity buildGroupInfoEntity, Boolean isParent) {
        this.pid = "campus_" + buildGroupInfoEntity.getPid();
        this.name = buildGroupInfoEntity.getName();
        this.isParent = isParent;
        this.id = buildGroupInfoEntity.getId();
        this.type = buildGroupInfoEntity.getType();
    }

    public TreeResponseVo(BuildInfoEntity buildInfoEntity, Boolean isParent) {
        this.pid = "group_" + buildInfoEntity.getPid();
        this.name = buildInfoEntity.getName();
        this.isParent = isParent;
        this.id = buildInfoEntity.getId();
        this.type = buildInfoEntity.getType();
    }
}
