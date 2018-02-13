package com.findeng.wechat.serviceimpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.service.CreateMenu;

/**
 * 创建默认菜单
 *
 * @author Alien
 */
@Service(value = "defaultmenu")
public class CreateDefaultMenu implements CreateMenu {

    @Value("${ServerPath}")
    private String ServerPath;

    @Autowired
    private WeChatCoreService weChatCoreService;

    @Override
    public JSONObject Create() {
        JSONArray menus = new JSONArray();

        //菜单按键1
        JSONObject menu1 = new JSONObject();
        menu1.put("name", "繁灯商城");
        menu1.put("type", "view");
        menu1.put("url", weChatCoreService.getOAuth2CodeUrl(ServerPath + "wechat/OAuth2Validate",
                "snsapi_base", "/mobilemall/index"));

        //菜单按键2
        JSONObject menu2 = new JSONObject();
        menu2.put("name", "快速找灯");
        menu2.put("type", "view");
        menu2.put("url", "http://www.baidu.com/s?wd=菜单2");

        //菜单按键3
        JSONObject menu3 = new JSONObject();
        menu3.put("name", "个人中心");
        menu3.put("type", "view");
        menu3.put("url", "http://www.baidu.com/s?wd=菜单3");

        menus.put(menu1).put(menu2).put(menu3);
        String data = new JSONObject().put("button", menus).toString();
        return weChatCoreService.createCustomMenu(data);
    }

}
