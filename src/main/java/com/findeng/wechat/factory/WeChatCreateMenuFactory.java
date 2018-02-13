package com.findeng.wechat.factory;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.findeng.Application;
import com.findeng.wechat.service.CreateMenu;

/**
 * 微信菜单创建工厂类
 *
 * @author Alien
 */
@Service
public class WeChatCreateMenuFactory {
    /**
     * 创建菜单方法
     *
     * @param MenuType 菜单类型
     */
    public JSONObject CreateMenu(String MenuType) {
        CreateMenu menu = (CreateMenu) Application.applicationContext.getBean(MenuType);
        return menu.Create();
    }
}
