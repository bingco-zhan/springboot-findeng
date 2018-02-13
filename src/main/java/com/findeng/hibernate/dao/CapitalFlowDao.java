package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.CapitalFlow;

/**
 * 订单流水表dao层
 *
 * @author Alien
 */
@Repository
public interface CapitalFlowDao extends JpaRepository<CapitalFlow, Integer>, JpaSpecificationExecutor<CapitalFlow> {

}
