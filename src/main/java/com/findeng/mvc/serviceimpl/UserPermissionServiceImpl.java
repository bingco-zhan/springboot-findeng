package com.findeng.mvc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.UserPermissionDao;
import com.findeng.hibernate.entity.UserPermission;
import com.findeng.mvc.service.UserPermissionService;

/**
 * 用户权限表Service层实现
 *
 * @author Alien
 */
@Transactional
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    private UserPermissionDao userPermissionDao;

    public UserPermission findById(int id) {
        return userPermissionDao.findOne(id);
    }

    public List<UserPermission> findByAll() {
        return userPermissionDao.findAll();
    }
}
