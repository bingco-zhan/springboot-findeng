package com.findeng.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.UserPermission;

/**
 * 用户权限表DAO
 *
 * @author Alien
 */
@Repository
public interface UserPermissionDao extends JpaRepository<UserPermission, Integer> {

}
