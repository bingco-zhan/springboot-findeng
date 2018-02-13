package com.findeng.mvc.serviceimpl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.UserRoleDao;
import com.findeng.hibernate.entity.UserRole;
import com.findeng.mvc.service.UserRoleService;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;

@Transactional
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public UserRole findById(int id) {
        return userRoleDao.findOne(id);
    }

    @Override
    public List<UserRole> findByAll() {
        return userRoleDao.findAll();
    }

    /**
     * 保存用户角色
     */
    @Override
    public JSONObject save(UserRole userRole) {
        userRoleDao.save(userRole);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    /**
     * 更新用户角色
     */
    @Override
    public JSONObject updata(UserRole userRole) {
        int id = userRole.getId();
        if (userRoleDao.findOne(id) == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(300), "", null, null);
        userRoleDao.save(userRole);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }
}
