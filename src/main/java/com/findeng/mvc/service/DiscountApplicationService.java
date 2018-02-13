package com.findeng.mvc.service;

import org.json.JSONObject;
import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.DiscountApplication;

/**
 * 用户折扣表Service层接口
 *
 * @author Alien
 */
public interface DiscountApplicationService {

    public DiscountApplication findById(int id);

    public DiscountApplication save(DiscountApplication da);

    public Page<DiscountApplication> findByPaging(DiscountApplication da, Integer offset, Integer limit, String field, String sort);

    public JSONObject applicationDiscount(int id, int status);
}
