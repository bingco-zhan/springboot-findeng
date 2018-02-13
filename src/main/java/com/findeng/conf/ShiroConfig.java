package com.findeng.conf;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.findeng.shiro.AdminRealm;

/**
 * shiro配置
 *
 * @author Alien
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //去除静态资源
//        filterChainDefinitionMap.put("/static/**", "anon");
//        filterChainDefinitionMap.put("/admin/api/login", "anon");
//        
//        filterChainDefinitionMap.put("/admin/userAuthentication","authc, roles[6]");
//        filterChainDefinitionMap.put("/**", "authc");
//        shiroFilterFactoryBean.setLoginUrl("/admin/loginpage"); // 未授权界面;
// 
//        shiroFilterFactoryBean.setUnauthorizedUrl("/static/ErrorPage/550.html");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 返回管理员登陆域
     *
     * @return
     */
    @Bean
    public AdminRealm getAdminRealm() {
        return new AdminRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getAdminRealm());
        return securityManager;
    }

}
