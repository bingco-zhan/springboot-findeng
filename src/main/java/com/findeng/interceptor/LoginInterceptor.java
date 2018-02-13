package com.findeng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.findeng.hibernate.entity.User;
import com.findeng.mvc.serviceimpl.UserServiceImpl;
import com.findeng.wechat.WeChatCoreService;

/**
 * 用户登录访问拦截器
 *
 * @author Alien
 */
public class LoginInterceptor implements HandlerInterceptor {

    boolean isdebug = true;

    @Autowired
    private WeChatCoreService weChatCoreService;

    //服务器地址
    @Value("${ServerPath}")
    private String ServerPath;
    //网络环境普通产品缩略图路径
    @Value("${httpFile.ProductThumbnailSrc}")
    private String ProductThumbnailSrc;
    //网络环境配灯系统产品缩略图路径
    @Value("${httpFile.CustomProductThumbnailSrc}")
    private String CustomProductThumbnailSrc;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse rep, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse rep, Object arg2, ModelAndView model)
            throws Exception {
        if (model != null && model.hasView()) {
            //产品缩略图路径
            model.addObject("ProductThumbnailSrc", ProductThumbnailSrc);
            //配灯系统产品缩略图
            model.addObject("CustomProductThumbnailSrc", CustomProductThumbnailSrc);
            //设置服务器地址
            model.addObject("ServerPath", ServerPath);
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse rep, Object arg2) throws Exception {
        HttpSession session = req.getSession();
        String openid = (String) session.getAttribute("openid");
        User user = (User) session.getAttribute("user");
        User upuser = (User) session.getAttribute("upuser");
        if (openid == null) {//用户会话域没有携带openid
            if (isdebug)
                return true;
            //用户重定向到验证地址
            String OAuth2Url = weChatCoreService.getOAuth2CodeUrl(
                    ServerPath + "wechat/OAuth2Validate"
                    , "snsapi_base", req.getRequestURL().toString());
            rep.sendRedirect(OAuth2Url);
            return false;
        } else {//用户会话域有携带openid
            if (user == null) {//没有确定用户身份
                user = userServiceImpl.findByOpenId(openid);
                if (user == null) {//游客身份
                    if (upuser == null)
                        session.setAttribute("upuser", userServiceImpl.findByUserId(1));//设置上级为平台
                    session.setAttribute("rloe", -1);//设置身份为游客
                } else {//已注册但未确认身份
                    session.setAttribute("upuser", userServiceImpl.findByUserId(user.getUpperUserId()));//设置上级
                    session.setAttribute("role", user.getRole());
                    session.setAttribute("user", user);
                }
            }
            return true;
        }
    }

}
