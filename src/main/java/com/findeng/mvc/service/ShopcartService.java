package com.findeng.mvc.service;

import com.findeng.hibernate.entity.Shopcart;

import java.util.List;

/**
 * 购物车服务层
 * @author bingco
 * @version v1.0
 */
public interface ShopcartService {

    /**
     * 根据条件查询某个购物车
     * @param sellerId 厂家ID
     * @param buyerId 买家ID
     * @param deleteFlag 是否删除
     */
    public Shopcart findShopcartBy(Integer sellerId, Integer buyerId, Integer deleteFlag);

    /**
     * 添加商品到购物车
     * @param userId 用户ID
     * @param pid 商品ID
     * @param count 商品数量
     */
    public void addShopcart(Integer userId, Integer pid, Integer count);

    /**
     * 根据用户ID查询购物车
     * @param userId 用户ID
     */
    public List<Shopcart> findShopcart(Integer userId);
}
