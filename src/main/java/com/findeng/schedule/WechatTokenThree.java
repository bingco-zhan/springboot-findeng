package com.findeng.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.WeChatToken;
import com.findeng.wechat.factory.WeChatCreateMenuFactory;

/**
 * 微信线程
 *
 * @author Alien
 */
@Component
public class WechatTokenThree {

    @Autowired
    private WeChatCoreService WeChatCoreService;

    @Autowired
    private WeChatCreateMenuFactory weChatCreateMenuFactory;

    //菜单创建标志
    private static boolean isCreateMenu = false;

    /**
     * 微信令牌和菜单刷新线程(1小时)
     *
     * @author Alien
     * @version 1.0
     */
    @Scheduled(fixedDelay = 1000 * 60 * 60)
    public void TokenTask() {
        try {
            WeChatToken.Access_Token = WeChatCoreService
                    .getaccess_token()
                    .getString("access_token");
            WeChatToken.Jsapi_Ticket = WeChatCoreService
                    .getjsapi_ticket(WeChatToken.Access_Token)
                    .getString("ticket");
            if (!isCreateMenu && !WeChatToken.Access_Token.isEmpty()) {
                //先清空微信菜单
                WeChatCoreService.deleteAllmenu(WeChatToken.Access_Token);
                weChatCreateMenuFactory.CreateMenu("defaultmenu");
                weChatCreateMenuFactory.CreateMenu("demandfactorymenu");
                weChatCreateMenuFactory.CreateMenu("factorymenu");
                weChatCreateMenuFactory.CreateMenu("salesmanmenu");
                isCreateMenu = true;
            }
            System.out.println("Access_Token:" + WeChatToken.Access_Token);
            System.out.println("Jsapi_Ticket" + WeChatToken.Jsapi_Ticket);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Thread.sleep(2000);
                //TokenTask();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("令牌刷新失败,重试中....");
        }
    }
}
