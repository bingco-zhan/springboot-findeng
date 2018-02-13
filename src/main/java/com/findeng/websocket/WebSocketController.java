package com.findeng.websocket;

import java.io.IOException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/**
 * 接受用户WebSocket消息
 *
 * @author Alien
 */
@ServerEndpoint(value = "/message")
@Component
public class WebSocketController {

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
//    	HttpSession httpSession = (HttpSession) config.getUserProperties()
//                .get(HttpSession.class.getName());
//    	System.out.println(httpSession.getId());
//    	System.out.println(httpSession.getValueNames().toString());
        //WebSocketPool.addLineInbound(session);
    }

    @OnClose
    public void onClose(Session session) {
        //WebSocketPool.removeLineInbound(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);
        // 群发消息  
//        for (  item : WebSocketPool.Pool ){  
//                item.sendMessage(message);  
//        }  
    }
}
