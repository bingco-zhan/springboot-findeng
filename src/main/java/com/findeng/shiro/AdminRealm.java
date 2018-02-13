package com.findeng.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.entity.UserRole;
import com.findeng.mvc.serviceimpl.UserRoleServiceImpl;
import com.findeng.mvc.serviceimpl.UserServiceImpl;

/**
 * shiro管理员域
 *
 * @author Alien
 */
@Component
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRoleServiceImpl userRoleServiceImpl;

    /**
     * 权限拦截
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限设置开始");
        String userName = (String) principals.getPrimaryPrincipal();//获取用户名
        User user = userServiceImpl.findByPhoneNumber(userName);//获取用户实体
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserRole userRole = userRoleServiceImpl.findById(user.getRole().getId());//获取用户角色
        //初始化角色权限
        String[] permissions = userRole.getPermissions().split(";");
        Set<String> roles = new HashSet<>();
        for (String p : permissions) {
            roles.add(p);
        }
        info.setRoles(roles);
        System.out.println("权限设置结束");
        return info;
    }

    /**
     * 登陆拦截
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userServiceImpl.findByPhoneNumber(token.getUsername());
        if (user != null) return new SimpleAuthenticationInfo(user.getPhoneNumber(), user.getPassword(), getName());
        return null;
    }

}
