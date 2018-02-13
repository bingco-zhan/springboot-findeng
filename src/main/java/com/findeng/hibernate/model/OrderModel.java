package com.findeng.hibernate.model;

import java.util.List;

import com.findeng.hibernate.entity.OrderForm;
import com.findeng.hibernate.entity.OrderItem;

/**
 * 订单模型
 *
 * @author Alien
 */
public class OrderModel {

    private OrderForm orderForm;

    private List<OrderItem> orderItemList;

    public OrderForm getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }


}
