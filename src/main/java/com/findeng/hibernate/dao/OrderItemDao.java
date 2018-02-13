package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.OrderItem;

/**
 * 订单项Dao层
 *
 * @author Alien
 */
@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Integer>, JpaSpecificationExecutor<OrderItem> {

    public List<OrderItem> findByOrderNumber(String orderNumber);
}
