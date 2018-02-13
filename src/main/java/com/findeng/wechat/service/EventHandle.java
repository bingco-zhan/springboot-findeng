package com.findeng.wechat.service;

import java.util.Map;

/**
 * 微信事件处理接口
 *
 * @author Alien
 */
public interface EventHandle {
    /**
     * 处理方法接口
     *
     * @param map  事件消息体
     * @param user 产生事件的用户
     * @return void
     * @author Alien
     */
    void handle(Map<String, Object> map);
}
