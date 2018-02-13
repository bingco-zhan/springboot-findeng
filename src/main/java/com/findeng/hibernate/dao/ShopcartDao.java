package com.findeng.hibernate.dao;

import com.findeng.hibernate.entity.Shopcart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物车数据层
 * @author bingco
 * @version v1.0
 */
@Repository
public interface ShopcartDao extends JpaRepository<Shopcart, Integer>, JpaSpecificationExecutor<Shopcart> {

    /**
     * 根据条件查询购物车列表
     * @param buyerId 买家ID
     * @param deleteFlag 是否删除
     */
    @Query("FROM Shopcart WHERE buyerId=?1 AND deleteFlag=?2")
    public List<Shopcart> findShopcartBy(Integer buyerId, Integer deleteFlag);

    /**
     * 根据条件查询购物车列表
     * @param sellerId 厂家ID
     * @param buyerId 买家ID
     * @param deleteFlag 是否删除
     */
    @Query("FROM Shopcart WHERE sellerId=?1 AND buyerId=?2 AND deleteFlag=?3")
    public List<Shopcart> findShopcartBy(Integer sellerId, Integer buyerId, Integer deleteFlag);

}
