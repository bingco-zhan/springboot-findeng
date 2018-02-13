package com.findeng.wechat.serviceimpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.service.CreateMenu;

/**
 * 创建销售人员菜单
 *
 * @author Administrator
 */
@Service(value = "salesmanmenu")
public class CreateSalesManMenu implements CreateMenu {

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
        submenu.put("name", "快速找灯");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键2");
        submenus.put(submenu);
        //子按键3
        submenu = new JSONObject();
        submenu.put("name", "供需匹配");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键3");
        submenus.put(submenu);
        menu1.put("sub_button", submenus);

//------------------------------------------------------------

        //菜单按键2
        JSONObject menu2 = new JSONObject();
        menu2.put("name", "客户管理");
        submenus = new JSONArray();
        //子按键1
        submenu = new JSONObject();
        submenu.put("name", "客户消息");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键1");
        submenus.put(submenu);
        //子按键2
        submenu = new JSONObject();
        submenu.put("name", "客户列表");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键2");
        submenus.put(submenu);
        menu2.put("sub_button", submenus);

//------------------------------------------------------------

        //菜单按键3
        JSONObject menu3 = new JSONObject();
        menu3.put("name", "我的信息");
        submenus = new JSONArray();
        //子按键1
        submenu = new JSONObject();
        submenu.put("name", "个人中心");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键1");
        submenus.put(submenu);
        //子按键2
        submenu = new JSONObject();
        submenu.put("name", "每日推广");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键2");
        submenus.put(submenu);
        //子按键3
        submenu = new JSONObject();
        submenu.put("name", "购物车");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键3");
        submenus.put(submenu);
        //子按键4
        submenu = new JSONObject();
        submenu.put("name", "微课堂");
        submenu.put("type", "view");
        submenu.put("url", "http://www.baidu.com/s?wd=子按键4");
        submenus.put(submenu);
        menu3.put("sub_button", submenus);

        //匹配规则
        JSONObject matchrule = new JSONObject();
        matchrule.put("tag_id", 103);

        menus.put(menu1).put(menu2).put(menu3);
        String data = new JSONObject()
                .put("button", menus)
                .put("matchrule", matchrule)
                .toString();
        return weChatCoreService.createIndividualityMenu(data);
    }

}
