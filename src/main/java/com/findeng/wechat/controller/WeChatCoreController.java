package com.findeng.wechat.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.WeChatToken;
import com.findeng.wechat.factory.WeChatEventListenFactory;

/**
 * 微信核心控制器
 *
 * @author Alien
 */
@RestController
@RequestMapping(value = "/wechat")
public class WeChatCoreController {

    @Autowired
    private WeChatCoreService weChatCoreService;

    @Autowired
    private WeChatEventListenFactory WeChatEventListenFactory;

    /**
     * 微信web页面注册
     *
     * @param 需要注册的url
     */
    @GetMapping(value = "/websign")
    public Map<String, String> WebSign(@PathParam(value = "url") String url) {
        return weChatCoreService.WebSign(WeChatToken.Jsapi_Ticket, url);
    }

    /**
     * 接受微信所有事件
     *
     * @param request  请求对象
     * @param response 响应对象
     * @throws IOException
     */
    @RequestMapping(value = "/wechateventlisten")
    public String EventListen(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String echostr = request.getParameter("echostr");
        //return echostr;
        WeChatEventListenFactory.handleEvent(request);
        return "";
    }

    /**
     * 微信oauth2验证回调地址
     *
     * @param code     oauth2验证回调code
     * @param state    oauth2验证回调自定义字符串(实际需要跳转页面的控制器)
     * @param request  请求对象
     * @param response 响应对象
     */
    @GetMapping(value = "/OAuth2Validate")
    public void OAuth2Validate(@RequestParam String code, @RequestParam(required = false) String state, HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject obj = weChatCoreService.executeOAuth2Validate(code);//进行oauth2验证
        HttpSession session = request.getSession();//获取用户会话
        session.setAttribute("openid", obj.getString("openid"));//获取用户openid
        if (state != null && !state.trim().equals(""))
            response.sendRedirect(state);//重定向到需要前往的页面
    }

    /**
     * 调用微信统计接口
     *
     * @param key       统计接口key
     * @param beginDate 统计开始时间
     * @param endDate   统计结束时间
     */
    @GetMapping(value = "/statistics")
    public String statistics(@RequestParam String key, @RequestParam String beginDate, @RequestParam String endDate) {
        return weChatCoreService.statistics(key, beginDate, endDate).toString();
    }

    @GetMapping(value = "/speak")
    public String userSpeak(HttpSession session) {
        String openid = (String) session.getAttribute("openid");
        return weChatCoreService.sendTextMessage(openid, "您好,请在下方输入您的问题").toString();
    }
}
