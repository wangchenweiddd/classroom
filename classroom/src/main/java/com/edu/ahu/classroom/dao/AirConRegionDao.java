package com.edu.ahu.classroom.dao;

import com.edu.ahu.classroom.dataobject.AirConRegionEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository("airConRegionDao")
public class AirConRegionDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * 根据用户id查询其空调控制的原始权限区域 联合查询到 空调区域上
     * @param userId
     * @return
     */
    public List<AirConRegionEntity> findByUserId(Integer userId){

        String dataSql = "select airConRegion from " +
                "AirConRegionEntity AS airConRegion," +
                "AuthAirConRegionEntity AS authAirConRegion " +
                "where authAirConRegion.userId = :userId " +
                "and airConRegion.regionType = authAirConRegion.regionType " +
                "and airConRegion.regionId = authAirConRegion.regionId " +
                "order by airConRegion.regionCode asc";

        List<AirConRegionEntity> list = em.createQuery(dataSql,AirConRegionEntity.class)
                .setParameter("userId",userId)
                .getResultList();

        return list;
    }

    /**
     * 根据区域编码获取其下所有子集空调区域
     * @param regionCode        区域编码
     * @return                  空调区域List
     */
    public List<AirConRegionEntity> likeByRegionCode(String regionCode){

        String dataSql = "select airConRegion " +
                "from AirConRegionEntity as airConRegion " +
                "where airConRegion.regionCode like :regionCode " +
                "order by airConRegion.regionCode asc";

        List<AirConRegionEntity> list = em.createQuery(dataSql,AirConRegionEntity.class)
                .setParameter("regionCode",regionCode + "%")
                .getResultList();

        return list;
    }

    /**
     * 根据区域编码获取该RegionCode的空调区域数据
     * @param regionCodeList        区域编码
     * @return                      空调区域List
     */
    public List<AirConRegionEntity> findByRegionCode(List<String> regionCodeList) {

        String dataSql = "select airConRegion from AirConRegionEntity as airConRegion " +
                "where airConRegion.regionCode in :regionCodeList " +
                "order by airConRegion.regionCode asc";

        List<AirConRegionEntity> list = em.createQuery(dataSql, AirConRegionEntity.class)
                .setParameter("regionCodeList", regionCodeList)
                .getResultList();

        return list;
    }


    /**
     * 根据区域编码获取其下某一个区域类型的空调区域
     * @param regionCode
     * @param regionType
     * @return
     */
    public List<AirConRegionEntity> LikeByRegionCodeAndRegionType(String regionCode,String regionType){
        String dataSql = " select airConRegion " +
                "from AirConRegionEntity as airConRegion " +
                "where airConRegion.regionCode like :regionCode and airConRegion.regionType = :regionType " +
                "order by airConRegion.regionCode asc";

        List<AirConRegionEntity> list = em.createQuery(dataSql, AirConRegionEntity.class)
                .setParameter("regionCode", regionCode + "%")
                .setParameter("regionType",regionType)
                .getResultList();

        return list;
    }


}
