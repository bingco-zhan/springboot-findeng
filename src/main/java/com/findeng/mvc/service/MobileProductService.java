package com.findeng.mvc.service;

import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.model.MobileProductModel;
import org.springframework.data.domain.Page;

public interface MobileProductService {
    /**
     * 产品分页
     *
     * @param pmodel 商品属性装箱
     */
    public Page<Product> findByPaging(MobileProductModel pmodel);

    /**
     * 根据ID查询商品信息
     *
     * @param productId
     */
    public Product findByProductId(Integer productId);
}
