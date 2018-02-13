package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.CustomProduct;

@Repository
public interface CustomProductDao extends JpaRepository<CustomProduct, Integer>, JpaSpecificationExecutor<CustomProduct> {

    /**
     * 查询配灯系统经销商自定义产品
     *
     * @param userid 经销商id
     * @param item   查询条数
     * @return List 产品列表
     */
    @Query(value = "select * from custom_product where product_status=5 and user_id=?1 ORDER BY creat_time DESC LIMIT 0,?2", nativeQuery = true)
    List<CustomProduct> findByUserId(int userid, int item);
}
