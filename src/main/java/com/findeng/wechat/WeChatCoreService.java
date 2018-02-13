package com.findeng.wechat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.findeng.util.CommonUtil;
import com.findeng.util.HttpRequest;
import com.findeng.util.ImageUtil;
import com.findeng.util.WeChatWebSign;

/**
 * 微信核心服务类
 *
 * @author Alien
 */
@Service
public class WeChatCoreService {

    //缩略图路径
    @Value("${systemFile.ImageInfoThumbnailSrc}")
    private String ImageInfoThumbnailSrc;

    //公众号唯一id
    @Value("${wechat.appId}")
    private String appId;

    //公众号密匙
    @Value("${wechat.appSecret}")
    private String appSecret;

    /**
     * 获取微信普通凭证
     *
     * @param appId      公司id
     * @param corpsecret 应用密匙
     * @return 微信返回Json
     */
    public JSONObject getaccess_token() throws Exception {
        String requestUrl = WeChatURL.getAccess_TokenURL
                .replace("Parameter1", appId)
                .replace("Parameter2", appSecret);
        String rep = HttpRequest.httpsRequest(requestUrl, "GET", null);
        return new JSONObject(rep);
    }

    /**
     * 获取微信OAuth2.0验证接口url
     *
     * @param redirect_uri 需要微信重定向的地址
     * @param scope        应用授权作用域，静默授权snsapi_base或用户授权snsapi_userinfo
     * @param state        重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return String 生成的OAuth2url
     */
    public String getOAuth2CodeUrl(String redirect_uri, String scope, String state) {
        String requestUrl = WeChatURL.oAuth2ValidateUrl
                .replace("Parameter1", appId)
                .replace("Parameter2", redirect_uri)
                .replace("Parameter3", scope)
                .replace("Parameter4", state);
        return requestUrl;
    }


    /**
     * 通过code获取微信OpenId
     *
     * @param code 成员授权获取到的code
     * @return JSONObject
     */
    public JSONObject executeOAuth2Validate(String code) {
        String requestUrl = WeChatURL.getBaseUserInfo
                .replace("Parameter1", appId)
                .replace("Parameter2", appSecret)
                .replace("Parameter3", code);
        String rep = HttpRequest.httpsRequest(requestUrl, "GET", "");
        return new JSONObject(rep);
    }

    /**
     * 创建标签
     *
     * @param name 标签名
     * @return JSONObject 微信返回数据
     */
    public JSONObject createTag(String name) {
        String requestUrl = WeChatURL.createTag
                .replace("Parameter1", WeChatToken.Access_Token);
        JSONObject data = new JSONObject();
        data.put("tag", new JSONObject().put("name", name));
        String rep = HttpRequest.httpsRequest(requestUrl, "POST", data.toString());
        return new JSONObject(rep);
    }

    /**
     * 批量为用户打上或取消标签
     *
     * @param tagid      需要打上的标签id
     * @param openidList 用户open列表
     * @param isCancel   是否取消标签true为取消
     * @return JSONObject 微信返回数据
     */
    public JSONObject batchTagging(String tagid, List<String> openidList, boolean isCancel) {
        String requestUrl;
        if (isCancel)
            requestUrl = WeChatURL.batchTagging.replace("Parameter1", WeChatToken.Access_Token);
        else
            requestUrl = WeChatURL.batchCancelTagging.replace("Parameter1", WeChatToken.Access_Token);
        JSONObject data = new JSONObject();
        JSONArray arr = new JSONArray();
        for (String openid : openidList) {
            arr.put(openid);
        }
        data.put("openid_list", arr);
        data.put("tagid", tagid);
        String rep = HttpRequest.httpsRequest(requestUrl, "POST", data.toString());
        return new JSONObject(rep);
    }

    /**
     * 向指定用户发送消息
     *
     * @param OpenId  用户openid
     * @param content 发送的内容
     * @return 微信返回JSON
     */
    public JSONObject sendTextMessage(String OpenId, String content) {
        String requestUrl = WeChatURL.sendTextMessageURL
                .replace("Parameter1", WeChatToken.Access_Token);
        JSONObject msg = new JSONObject();
        msg.put("touser", OpenId);
        msg.put("msgtype", "text");
        msg.put("text", new JSONObject().put("content", content));
        String rep = HttpRequest.httpsRequest(requestUrl, "POST", msg.toString());
        return new JSONObject(rep);
    }

    /**
     * 获取WEB页面注册令牌
     *
     * @param access_token access_token访问令牌
     * @return JSONObject
     * @author Alien
     */
    public JSONObject getjsapi_ticket(String access_token) {
        String requestUrl = WeChatURL.getjsapi_ticketURL
                .replace("Parameter1", access_token);
        JSONObject rep = new JSONObject(HttpRequest.httpsRequest(requestUrl, "GET", null));
        return rep;
    }

    /**
     * 返回WEB页面注册数据
     *
     * @param jsapi_ticket 页面注册令牌
     * @param url          注册的地址
     * @return JSONObject 注册数据
     */
    public Map<String, String> WebSign(String jsapi_ticket, String url) {
        Map<String, String> restl = WeChatWebSign.sign(appId, jsapi_ticket, url);
        return restl;
    }

    /**
     * 下载微信素材
     *
     * @param mediaId  素材id
     * @param savePath 保存路径
     * @param type     素材格式(.jpg或.mp3等)
     * @return String 文件保存的全路径(包含.jpg)
     */
    public String downloadMedia(String mediaId, String savePath, String type) {
        String requestUrl = WeChatURL.downloadMedia
                .replace("Parameter1", WeChatToken.Access_Token)
                .replace("Parameter2", mediaId);
        String fileName = System.currentTimeMillis() + CommonUtil.getRandomNumber(6);
        String filePath = savePath + fileName + type;
        File file = new File(filePath);
        File save = new File(savePath);
        if (!save.exists()) save.mkdirs();

        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            InputStream inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);
            fos.close();
            bis.close();

            if (type.equals(".jpg")) {
                //生成缩略图
                File saveThumbnail = new File(ImageInfoThumbnailSrc);
                if (!saveThumbnail.exists()) saveThumbnail.mkdirs();
                ImageUtil.thumbnailImage(new File(filePath), ImageInfoThumbnailSrc, fileName, "jpg");
            }

            conn.disconnect();
        } catch (Exception e) {
            System.out.println("下载媒体文件失败：" + e);
        }
        return filePath;
    }

    /**
     * 生成带参二维码
     *
     * @param scene_id 场景值
     * @param forever  是否永久true为永久
     * @return 微信返回数据
     */
    public JSONObject getQrCode(int scene_id, Boolean forever) {
        String requestUrl = WeChatURL.createQrCodeURL
                .replace("Parameter1", WeChatToken.Access_Token);
        //二维码类型
        String action_name = forever ? "QR_LIMIT_SCENE" : "QR_SCENE";
        //二维码生效时间
        int expire_seconds = 2592000;
        JSONObject content = new JSONObject();
        content.put("expire_seconds", expire_seconds);
        content.put("action_name", action_name);
        content.put("action_info", new JSONObject("{scene:{scene_str:" + scene_id + "}}"));
        String re = HttpRequest.httpsRequest(requestUrl, "POST", content.toString());
        return new JSONObject(re);
    }

    /**
     * 根据openid获取用户基本信息
     *
     * @param OpenId 用户id
     * @return JSONObject
     */
    public JSONObject getUserInfo(String OpenId) {
        String requestUrl = WeChatURL.getUserInfoURL
                .replace("Parameter1", WeChatToken.Access_Token)
                .replace("Parameter2", OpenId)
                .replace("Parameter3", "zh_CN");
        String re = HttpRequest.httpsRequest(requestUrl, "GET", null);
        return new JSONObject(re);
    }

    /**
     * 创建自定义菜单接口
     *
     * @param menu 创建菜单json数据
     * @return JSONObject
     */
    public JSONObject createCustomMenu(String menu) {
        String requestUrl = WeChatURL.createCustomMenu
                .replace("Parameter1", WeChatToken.Access_Token);
        String re = HttpRequest.httpsRequest(requestUrl, "POST", menu);
        return new JSONObject(re);
    }

    /**
     * 创建个性化菜单接口
     *
     * @param menu 创建菜单json数据
     * @return JSONObject
     */
    public JSONObject createIndividualityMenu(String menu) {
        String requestUrl = WeChatURL.createIndividualityMenu
                .replace("Parameter1", WeChatToken.Access_Token);
        String re = HttpRequest.httpsRequest(requestUrl, "POST", menu);
        return new JSONObject(re);
    }

    /**
     * 删除所有自定义菜单
     *
     * @param access_token 微信令牌
     * @return JSONObject
     */
    public JSONObject deleteAllmenu(String access_token) {
        String requestUrl = WeChatURL.deleteAllMenu
                .replace("Parameter1", WeChatToken.Access_Token);
        String re = HttpRequest.httpsRequest(requestUrl, "POST", null);
        return new JSONObject(re);
    }

    /**
     * 调用统计数据接口
     *
     * @param key       统计接口路径的key
     * @param beginDate
     */
    public JSONObject statistics(String key, String beginDate, String endDate) {
        String requestUrl = WeChatURL.statistics.get(key)
                .replace("Parameter1", WeChatToken.Access_Token);//通过key获取统计接口路径
        //统计时间段
        JSONObject json = new JSONObject();
        json.put("begin_date", beginDate);//开始时间
        json.put("end_date", endDate);//结束时间
        System.out.println(json.toString());
        String re = HttpRequest.httpsRequest(requestUrl, "POST", json.toString());
        return new JSONObject(re);
    }
}
