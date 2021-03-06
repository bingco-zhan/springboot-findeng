package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.OrderForm;

/**
 * 订单头Dao层
 *
 * @author Alien
 */
@Repository
public interface OrderFormDao extends JpaRepository<OrderForm, Integer>, JpaSpecificationExecutor<OrderForm> {

}
