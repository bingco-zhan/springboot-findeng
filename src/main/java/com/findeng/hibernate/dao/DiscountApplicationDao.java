package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.findeng.hibernate.entity.DiscountApplication;

/**
 * 用户折扣申请Dao层
 *
 * @author Alien
 */
@Repository
public interface DiscountApplicationDao extends JpaRepository<DiscountApplication, Integer>, JpaSpecificationExecutor<DiscountApplication> {

}
