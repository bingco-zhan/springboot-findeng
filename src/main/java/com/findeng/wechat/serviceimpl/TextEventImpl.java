package com.findeng.wechat.serviceimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.findeng.Enum.InformationType;
import com.findeng.Enum.UserType;
import com.findeng.hibernate.entity.Information;
import com.findeng.hibernate.entity.User;
import com.findeng.mvc.serviceimpl.InformationServiceImpl;
import com.findeng.mvc.serviceimpl.UserServiceImpl;
import com.findeng.wechat.WeChatCoreService;
import com.findeng.wechat.service.EventHandle;

/**
 * 文本消息事件处理类
 *
 * @author Alien
 */
@Service(value = "text")
public class TextEventImpl implements EventHandle {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Value("${wechat.customerServiceOpenId}")
    private String customerServiceOpenId;

    @Autowired
    WeChatCoreService WeChatCoreService;

    @Autowired
    private InformationServiceImpl informationServiceImpl;

    @Override
    public void handle(Map<String, Object> map) {
        User user = userServiceImpl.findByOpenId((String) map.get("FromUserName"));
        //如果用户注册信息不为空
        if (user != null) {
            String UserNickname = user.getUserNickname();
            //消息内容
            String MsgContent = (String) map.get("Content");
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

            //根据用户类型发送消息给客服
            Integer toUserRole = null;
            if (toUser == null) {
                WeChatCoreService.sendTextMessage(
                        customerServiceOpenId,
                        "用户[" + UserNickname + "]留言:\n" + MsgContent);
            } else {
                toUserRole = toUser.getRole().getId();
                if (toUserRole == UserType.AGENCY || toUserRole == UserType.RETAIL_SALES) {
                    WeChatCoreService.sendTextMessage(
                            customerServiceOpenId,
                            "用户[" + UserNickname + "]给经销商发消息:\n" + MsgContent);

                }
            }

            //需要发送的用户角色是平台的话数据存到数据库
            if (toUserRole != null && toUserRole == UserType.PLATFORM) {
                Information info = new Information();
                info.setInfoType(InformationType.TEXT);
                info.setInfoContent(MsgContent);
                info.setSendTime(new Timestamp(new Date().getTime()));
                info.setReadFlag(0);
                info.setFromUserId(user.getUserId());
                info.setToUserId(toUser.getUserId());
                informationServiceImpl.save(info);
                //WebSocketMessageInboundPool.sendMessageToUser(toUser.getOpenId(), new JSONObject(info).toString());
                WeChatCoreService.sendTextMessage(toUser.getOpenId(),
                        "来自用户[" + UserNickname + "]的新消息:\n" + MsgContent);
            }
        }
    }

}
