package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.findeng.hibernate.entity.CertificationApplication;

/**
 * 用户认证表DAO层
 *
 * @author Alien
 */
@Repository
public interface CertificationApplicationDao extends JpaRepository<CertificationApplication, Integer>, JpaSpecificationExecutor<CertificationApplication> {

}
