package com.findeng.wechat.serviceimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.findeng.Enum.InformationType;
import com.findeng.hibernate.entity.Information;
import com.findeng.hibernate.entity.User;
import com.findeng.mvc.serviceimpl.InformationServiceImpl;
import com.findeng.mvc.serviceimpl.UserServiceImpl;
import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.service.EventHandle;

/**
 * 语音消息处理类
 *
 * @author Alien
 */
@Service(value = "voice")
public class VoiceImpl implements EventHandle {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private InformationServiceImpl informationServiceImpl;

    //语音保存的路径
    @Value("${systemFile.VoiceInformationSrc}")
    private String VoiceInformationSrc;

    @Autowired
    private WeChatCoreService WeChatCoreService;

    @Override
    public void handle(Map<String, Object> map) {
        User user = userServiceImpl.findByOpenId((String) map.get("FromUserName"));
        //如果用户注册信息不为空
        if (user != null) {
            //获取时间戳
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            //设置最近访问时间
            user.setRentVisitTime(timeStamp);
            //更新用户到数据库
            userServiceImpl.save(user);
            //获取销售员或上级的User实体类
            Integer salesmanId = user.getSalesmanId();
            Integer upperuserid = user.getUpperUserId();
            User toUser = null;
            if (salesmanId != null) {
                toUser = userServiceImpl.findByUserId(salesmanId);
            } else if (upperuserid != null) {
                toUser = userServiceImpl.findByUserId(upperuserid);
            }
            //实例化消息对象
            Information info = new Information();
            //设置媒体文件格式
            info.setInfoType(InformationType.VOICE);
            //设置媒体文件id
            info.setMediaId((String) map.get("MediaId"));
            ///-----------------------
            //下载微信媒体文件
            String filePath = WeChatCoreService.downloadMedia(info.getMediaId(), VoiceInformationSrc, ".mp3");
            //设置文件全路径
            info.setInfoContent(filePath);
            //设置发送时间
            info.setSendTime(new Timestamp(new Date().getTime()));
            //设置读取标志
            info.setReadFlag(0);
            //设置发送者openid
            info.setFromUserId(user.getUserId());
            if (toUser != null) {
                //发送接受者openid
                info.setToUserId(toUser.getUserId());
                //WebSocketMessageInboundPool.sendMessageToUser(toUser.getOpenId(), new JSONObject(info).toString());
                //发送文本消息給接受者
                WeChatCoreService.sendTextMessage(toUser.getOpenId(), "您有新语音消息!");
            }
            //保存消息到数据库
            informationServiceImpl.save(info);
        }
    }

}
