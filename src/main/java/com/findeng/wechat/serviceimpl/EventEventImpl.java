package com.findeng.wechat.serviceimpl;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.findeng.hibernate.entity.User;
import com.findeng.mvc.serviceimpl.UserServiceImpl;
import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.service.EventHandle;

/**
 * 微信事件消息处理类
 *
 * @author Alien
 */
@Service(value = "event")
public class EventEventImpl implements EventHandle {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private WeChatCoreService weChatCoreService;

    @Value("${wechat.enableWelcome}")
    private boolean enableWelcome;

    @Value("${wechat.welcomeSpeech}")
    private String welcomeSpeech;

    @Override
    public void handle(Map<String, Object> map) {
        String eventType = (String) map.get("Event");//事件类型
        String FromUserOpenId = (String) map.get("FromUserName");//事件类型
        User FromUser = userServiceImpl.findByOpenId((String) map.get("FromUserName"));

        switch (eventType) {
            case "subscribe"://关注事件
                if (FromUser == null) {//如果关注用户没有注册
                    if (map.containsKey("Ticket")) {//通过二维码关注
                        int Scene = Integer.valueOf(map.get("EventKey").toString().replace("qrscene_", ""));//场景值
                        userServiceImpl.CreatScanUser(FromUserOpenId, Scene);
                    } else {//普通关注
                        userServiceImpl.CreatGeneralUser(FromUserOpenId);
                    }
                } else {//如果用户重新关注过平台
                    userServiceImpl.CreateAgainUser(FromUser);
                }
                //是否启动欢迎语
                if (enableWelcome)
                    weChatCoreService.sendTextMessage(FromUserOpenId, welcomeSpeech);
                break;
            case "unsubscribe"://取消关注
                if (FromUser != null) {
                    FromUser.setRentVisitTime(new Timestamp(System.currentTimeMillis()));
                    FromUser.setIsConcern(0);
                    userServiceImpl.save(FromUser);
                }
                break;
            case "SCAN":
                System.out.println("用户扫描带参数二维码,状态为已关注:" + FromUserOpenId);
                break;
            case "CLICK":
                break;
        }
    }

}
