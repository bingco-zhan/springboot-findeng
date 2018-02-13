package com.findeng.mvc.service;

import org.json.JSONObject;

import com.findeng.hibernate.entity.OrderForm;

/**
 * 订单头Service接口
 *
 * @author Alien
 */
public interface OrderFormService {

    public OrderForm save(OrderForm of);

    public JSONObject findByPaging(OrderForm of, Integer offset, Integer limit, String field, String sort);
}
