package com.findeng.mvc.mobile.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.hibernate.entity.Shopcart;
import com.findeng.hibernate.entity.User;
import com.findeng.mvc.service.ShopcartService;
import com.findeng.mvc.service.UserService;
import com.findeng.util.WebUtil;

/**
 * 购物车api控制器
 * @author bingco
 * @version v1.0
 */
@RestController
@RequestMapping("/mobilemall")
public class ShopCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShopcartService shopcartService;

    /**
     * 添加商品到购物车
     * @param pid 商品ID
     * @param count 商品数量
     */
    @PostMapping("/shopcart")
    public String addShopcart(@RequestParam("pid") Integer pid, @RequestParam("count") Integer count, HttpSession session)
    {
        try {
            String openId = (String) session.getAttribute("openId");
            if (openId == null) if (openId == null) return WebUtil.resposeTableData(0, null, 400, "尚未登陆!").toString();
            User user = userService.findByOpenId(openId); // 查询用户

            shopcartService.addShopcart(user.getUserId(), pid, count);
            return WebUtil.resposeTableData(0, null, 200, "添加成功!").toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return WebUtil.resposeTableData(0, null, 400, "系统出误!").toString();
        }
    }

    /**
     * 查询当前用户的购物车
     */
    public String findShopcart(HttpSession session) {
        String openId = (String) session.getAttribute("openId");
        if (openId == null) return WebUtil.resposeTableData(0, null, 400, "尚未登陆!").toString();
        try {
            User user = userService.findByOpenId(openId); // 查询用户
            List<Shopcart> arr = shopcartService.findShopcart(user.getUserId());
            return WebUtil.resposeTableData(1, arr, 200, null).toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return WebUtil.resposeTableData(1, null, 400, "系统出错!").toString();
        }
    }
}
