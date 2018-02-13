package com.findeng.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.websocket.Session;

/**
 * websocket连接池
 *
 * @author Alien
 */
public class WebSocketPool {

    /**
     * 连接池链接总数
     */
    public static int LineCount = 0;

    /**
     * 存储链接的map
     */
    public static Map<String, Session> Pool = new HashMap<String, Session>();

    /**
     * 添加链接到连接池
     */
    public static void addLineInbound(Session session) {
        String userName = session.getUserPrincipal().getName();
        Pool.put(userName, session);
        LineCount++;
    }

    /**
     * 从链接池移除连接
     */
    public static void removeLineInbound(Session session) {
        String userName = session.getUserPrincipal().getName();
        Pool.remove(userName);
        LineCount--;
    }

    /**
     * 获取所有的在线用户
     */
    public static Set<String> getLineUser() {
        return Pool.keySet();
    }

    /**
     * 向特定的用户发送数据
     */
    public static void sendMessageToUser(String userName, String content) {
        //获取连接池内对象
        Session session = Pool.get(userName);
        try {
            if (session != null)
                session.getBasicRemote().sendText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向所有的用户发送消息
     */
    public static void sendMessageToAll(String content) {
        //获取所有mapkey
        Set<String> keys = Pool.keySet();
        for (String key : keys) {
            try {
                Session session = Pool.get(key);
                if (session != null)
                    session.getBasicRemote().sendText(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
