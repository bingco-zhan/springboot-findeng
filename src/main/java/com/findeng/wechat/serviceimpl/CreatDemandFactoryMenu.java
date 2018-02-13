package com.findeng.wechat.serviceimpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.service.CreateMenu;

/**
 * 创建需求厂家菜单
 *
 * @author Alien
 */
@Service(value = "demandfactorymenu")
public class CreatDemandFactoryMenu implements CreateMenu {

    @Autowired
    private WeChatCoreService weChatCoreService;

    @Override
    public JSONObject Create() {
        //主按键
        JSONArray menus = new JSONArray();
        //子按键
        JSONArray submenus = new JSONArray();

        //菜单按键1
        JSONObject menu1 = new JSONObject();
        menu1.put("name", "繁灯商城");
        //子按键1
        JSONObject submenu = new JSONObject();
        submenu.put("name", "商城主页");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键1");
        submenus.put(submenu);
        //子按键2
        submenu = new JSONObject();
        submenu.put("name", "发布需求");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键2");
        submenus.put(submenu);

        //菜单按键2
        JSONObject menu2 = new JSONObject();
        menu2.put("name", "查看求购");
        menu2.put("type", "view");
        menu2.put("url", "http://www.baidu.com/s?wd=菜单2");

        //菜单按键3
        JSONObject menu3 = new JSONObject();
        menu3.put("name", "我的消息");
        submenus = new JSONArray();
        //子按键1
        submenu = new JSONObject();
        submenu.put("name", "个人中心");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键1");
        submenus.put(submenu);
        //子按键2
        submenu = new JSONObject();
        submenu.put("name", "查看报价");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键2");
        submenus.put(submenu);
        menu3.put("sub_button", submenus);

        //匹配规则
        JSONObject matchrule = new JSONObject();
        matchrule.put("tag_id", 106);

        menus.put(menu1).put(menu2).put(menu3);
        String data = new JSONObject()
                .put("button", menus)
                .put("matchrule", matchrule)
                .toString();
        return weChatCoreService.createIndividualityMenu(data);
    }

}
