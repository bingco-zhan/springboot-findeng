package com.findeng.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.findeng.interceptor.AdminInterceptor;
import com.findeng.interceptor.LoginInterceptor;

/**
 * 配置SpringMVC拦截器
 *
 * @author Alien
 */
@Configuration
public class InterceptorsConfig extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public AdminInterceptor getAdminInterceptor() {
        return new AdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/wechat/**")
                .excludePathPatterns("/admin/**");
        registry.addInterceptor(getAdminInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/api/login")
                .excludePathPatterns("/admin/loginPage")
                .excludePathPatterns("/admin/api/logout");
    }

    /**
     * 项目资源映射到本地磁盘,作为未上线时测试用
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/picture/carousel/**")
                .addResourceLocations("file:D:/carouselImage/");
        registry.addResourceHandler("/LampPermissionAuthro/**")
                .addResourceLocations("file:D:/LampPermissionAuthro/");
        registry.addResourceHandler("/static/**")//默认路径会被shiro拦截
                .addResourceLocations("classpath:/static/");
    }
}
