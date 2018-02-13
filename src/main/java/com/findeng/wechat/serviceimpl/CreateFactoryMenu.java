package com.findeng.wechat.serviceimpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.service.CreateMenu;

/**
 * 创建生成厂家菜单
 *
 * @author Alien
 */
@Service(value = "factorymenu")
public class CreateFactoryMenu implements CreateMenu {

    @Autowired
    private WeChatCoreService weChatCoreService;

    @Override
    public JSONObject Create() {
        //主按键
        JSONArray menus = new JSONArray();
        //菜单按键2
        JSONObject menu1 = new JSONObject();
        menu1.put("name", "我的订单");
        menu1.put("type", "view");
        menu1.put("url", "http://www.baidu.com/s?wd=菜单1");
        //菜单按键2
        JSONObject menu2 = new JSONObject();
        menu2.put("name", "订单管理");
        menu2.put("type", "view");
        menu2.put("url", "http://www.baidu.com/s?wd=菜单2");
        //菜单按键2
        JSONObject menu3 = new JSONObject();
        menu3.put("name", "个人中心");
        menu3.put("type", "view");
        menu3.put("url", "http://www.baidu.com/s?wd=菜单3");

        //匹配规则
        JSONObject matchrule = new JSONObject();
        matchrule.put("tag_id", 102);

        menus.put(menu1).put(menu2).put(menu3);
        String data = new JSONObject()
                .put("button", menus)
                .put("matchrule", matchrule)
                .toString();
        return weChatCoreService.createIndividualityMenu(data);
    }

}
