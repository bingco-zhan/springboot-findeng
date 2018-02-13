package com.findeng.mvc.service;

import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.CapitalFlow;

/**
 * 订单流水表Service层接口
 *
 * @author Alien
 */
public interface CapitalFlowService {

    public Page<CapitalFlow> findByPaging(CapitalFlow cf, int offset, int limit, String field, String sort);

}
