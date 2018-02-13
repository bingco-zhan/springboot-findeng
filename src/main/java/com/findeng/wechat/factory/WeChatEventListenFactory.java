package com.findeng.wechat.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.findeng.Application;
import com.findeng.util.CommonUtil;
import com.findeng.wechat.service.EventHandle;

/**
 * 微信回调事件监听工厂类
 *
 * @author Alien
 */
@Service
public class WeChatEventListenFactory {
    /**
     * 处理微信事件
     *
     * @param request 请求对象
     * @throws IOException
     * @author Alien
     */
    public void handleEvent(HttpServletRequest request) throws IOException {
        // 读取输入流字符串
        BufferedReader reader = request.getReader();
        StringBuffer inputString = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            inputString.append(line);
        }
        // 关闭输入流，获取输出流
        request.getReader().close();
        // 字符串转Map对象
        Map<String, Object> map = CommonUtil.parseXML(inputString.toString());
        // 获取实体Bean处理消息
        EventHandle event = (EventHandle) Application.applicationContext.getBean((String) map.get("MsgType"));
        event.handle(map);
    }

}
