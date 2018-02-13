package com.findeng.wechat.service;

import org.json.JSONObject;

/**
 * 微信菜单创建接口
 *
 * @author Alien
 */
public interface CreateMenu {

    /**
     * 创建菜单方法
     *
     * @return 微信返回数据
     */
    public JSONObject Create();
}
