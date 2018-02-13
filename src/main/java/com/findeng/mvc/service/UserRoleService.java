package com.findeng.mvc.service;

import java.util.List;

import org.json.JSONObject;

import com.findeng.hibernate.entity.UserRole;

/**
 * 用户权限表Service层接口
 *
 * @author Alien
 */
public interface UserRoleService {

    public UserRole findById(int id);

    public List<UserRole> findByAll();

    public JSONObject save(UserRole userRole);

    public JSONObject updata(UserRole userRole);
}
