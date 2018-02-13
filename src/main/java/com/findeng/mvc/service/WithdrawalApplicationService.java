package com.findeng.mvc.service;

import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.WithdrawalApplication;

/**
 * 提现申请表Service接口
 *
 * @author Alien
 */
public interface WithdrawalApplicationService {

    public Page<WithdrawalApplication> findByPaging(WithdrawalApplication wa, int offset, int limit, String field, String sort);
}
