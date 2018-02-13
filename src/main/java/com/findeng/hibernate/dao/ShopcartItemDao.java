package com.findeng.hibernate.dao;

import com.findeng.hibernate.entity.ShopcartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopcartItemDao extends JpaRepository<ShopcartItem, Integer>,JpaSpecificationExecutor<ShopcartItem> {

    /**
     * 查询购物车清单
     * @param shopcartId 购物车ID
     * @param deleteFlag 是否删除
     */
    @Query("FROM ShopcartItem WHERE shopcartId=?1 AND deleteFlag=?2")
    public List<ShopcartItem> findByShoopcartIdAndDeleteFlag(Integer shopcartId, int deleteFlag);

}
