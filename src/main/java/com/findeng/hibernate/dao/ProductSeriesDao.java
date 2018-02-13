package com.findeng.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.ProductSeries;

@Repository
public interface ProductSeriesDao extends JpaRepository<ProductSeries, Serializable>, JpaSpecificationExecutor<ProductSeries> {

    /**
     * 通过用户ID查询系列
     *
     * @param role
     * @return
     */
    List<ProductSeries> findByUserId(int userId);
}
