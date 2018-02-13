package com.findeng.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.CustomProduct;

public interface CustomProductService {

    public List<CustomProduct> findByUserId(int userid, int item);

    public Page<CustomProduct> findByPaging(CustomProduct customProduct, int offset, int limit, String field, String sort);

}
