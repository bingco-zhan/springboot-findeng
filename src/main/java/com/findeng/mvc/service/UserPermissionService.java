package com.findeng.mvc.service;

import java.util.List;

import com.findeng.hibernate.entity.UserPermission;

/**
 * 用户权限表Service层接口
 *
 * @author Alien
 */
public interface UserPermissionService {
    public UserPermission findById(int id);

    public List<UserPermission> findByAll();
}
