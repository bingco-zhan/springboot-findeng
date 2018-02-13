package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.UserRole;

/**
 * 用户角色表DAO
 *
 * @author Alien
 */
@Repository
public interface UserRoleDao extends JpaRepository<UserRole, Integer> {

}
