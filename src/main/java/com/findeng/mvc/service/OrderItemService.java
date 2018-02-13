package com.findeng.mvc.service;

import java.util.List;

import org.json.JSONObject;

import com.findeng.hibernate.entity.OrderItem;

/**
 * 订单项Service接口
 *
 * @author Alien
 */
public interface OrderItemService {

    public OrderItem save(OrderItem oi);

    public JSONObject findByPaging(OrderItem oi, Integer offset, Integer limit, String field, String sort);

    public List<OrderItem> findByOrderNumber(String orderNumber);
}
