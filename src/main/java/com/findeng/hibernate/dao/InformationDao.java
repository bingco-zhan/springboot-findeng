package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.Information;

/**
 * 聊天信息表dao层
 *
 * @author Alien
 */
@Repository
public interface InformationDao extends JpaRepository<Information, Integer> {

}
	