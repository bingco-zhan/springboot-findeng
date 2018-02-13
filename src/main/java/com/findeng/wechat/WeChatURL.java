package com.findeng.wechat;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信api路径
 *
 * @author Alien
 */
public class WeChatURL {
    //微信访问令牌路径
    public static String getAccess_TokenURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=Parameter1&secret=Parameter2";
    //微信网页令牌
    public static String getjsapi_ticketURL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=Parameter1&type=jsapi";
    //发送客服消息
    public static String sendTextMessageURL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=Parameter1";
    //下载微信媒体素材
    public static String downloadMedia = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=Parameter1&media_id=Parameter2";
    //生成带参数二维码链接
    public static String createQrCodeURL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=Parameter1";
    //获取用户基本信息链接
    public static String getUserInfoURL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=Parameter1&openid=Parameter2&lang=Parameter3";
    //创建默认菜单接口
    public static String createCustomMenu = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=Parameter1";
    //创建个性化菜单接口
    public static String createIndividualityMenu = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=Parameter1";
    //OAuth2验证url
    public static String oAuth2ValidateUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=Parameter1&redirect_uri=Parameter2&response_type=code&scope=Parameter3&state=Parameter4#wechat_redirect";
    //获取用户基本信息链接
    public static String getBaseUserInfo = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=Parameter1&secret=Parameter2&code=Parameter3&grant_type=authorization_code";
    //创建标签url
    public static String createTag = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=Parameter1";
    //批量为用户打标签
    public static String batchTagging = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=Parameter1";
    //批量未用户取消标签
    public static String batchCancelTagging = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=Parameter1";
    //删除所有微信自定义菜单
    public static String deleteAllMenu = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=Parameter1";

    /**
     * 统计接口
     */
    public static Map<String, String> statistics = new HashMap<String, String>();

    static {
        //获取用户增减数据(7)
        statistics.put("getusersummary", "https://api.weixin.qq.com/datacube/getusersummary?access_token=Parameter1");
        //获取累计用户数据(7)
        statistics.put("getusercumulate", "https://api.weixin.qq.com/datacube/getusercumulate?access_token=Parameter1");

        //获取图文群发每日数据(1)
        statistics.put("getarticlesummary", "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=Parameter1");
        //获取图文群发总数据(1)
        statistics.put("getarticlesummary", "https://api.weixin.qq.com/datacube/getarticletotal?access_token=Parameter1");
        //获取图文统计数据(3)
        statistics.put("getarticletotal", "https://api.weixin.qq.com/datacube/getuserread?access_token=Parameter1");
        //获取图文统计分时数据(1)
        statistics.put("getuserread", "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=Parameter1");
        //获取图文分享转发数据(7)
        statistics.put("getuserreadhour", "https://api.weixin.qq.com/datacube/getusershare?access_token=Parameter1");
        //获取图文分享转发分时数据(1)
        statistics.put("getusersharehour", "https://api.weixin.qq.com/datacube/getusersharehour?access_token=Parameter1");

        //获取消息发送概况数据(7)
        statistics.put("getupstreammsg", "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=Parameter1");
        //获取消息分送分时数据(1)
        statistics.put("getupstreammsghour", "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=Parameter1");
        //获取消息发送周数据(30)
        statistics.put("getupstreammsgweek", "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=Parameter1");
        //获取消息发送月数据(30)
        statistics.put("getupstreammsgmonth", "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=Parameter1");
        //获取消息发送分布数据(15)
        statistics.put("getupstreammsgdist", "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=Parameter1");
        //获取消息发送分布周数据(30)
        statistics.put("getupstreammsgdistweek", "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=Parameter1");
        //获取消息发送分布月数据(30)
        statistics.put("getupstreammsgdistmonth", "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=Parameter1");

        //获取接口分析数据(30)
        statistics.put("getinterfacesummary", "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=Parameter1");
        //获取接口分析分时数据(1)
        statistics.put("getinterfacesummaryhour", "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=Parameter1");
    }
}
