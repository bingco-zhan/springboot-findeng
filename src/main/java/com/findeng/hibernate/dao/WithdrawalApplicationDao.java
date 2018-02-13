package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.WithdrawalApplication;

/**
 * 用户提现申请Dao层接口
 *
 * @author Alien
 */
@Repository
public interface WithdrawalApplicationDao extends JpaRepository<WithdrawalApplication, Integer>, JpaSpecificationExecutor<WithdrawalApplication> {

    public List<WithdrawalApplication> findByMoney(float money);
}
