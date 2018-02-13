package com.findeng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.entity.UserRole;
import com.findeng.mvc.serviceimpl.UserRoleServiceImpl;

public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRoleServiceImpl userRoleServiceImpl;

    /**
     * 后置拦截器,用于检查用户登录信息完整性
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView model) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");//登录用户
        UserRole userRole = (UserRole) session.getAttribute("userRole");//用户角色

        if (userRole == null) {
            userRole = userRoleServiceImpl.findById(user.getRole().getId());
            session.setAttribute("userRole", userRole);
        }
        if (model != null && model.hasView()) {
            model.addObject("user", user);
            model.addObject("role", userRole);
            model.addObject("userPermission", userRole.getPermissions());
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse rep, Object handler)
            throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            rep.sendRedirect("/admin/loginPage");
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
