package com.findeng.util;

import java.util.HashMap;
import java.util.Map;

import com.findeng.hibernate.model.ReturnModel;

/**
 * 服务器返回返回码和消息工具类
 *
 * @author Alien
 */
public class ReturnUtil {

    private static Map<Integer, String> messageMap = new HashMap<Integer, String>();

    static {
        messageMap.put(1, "[服务器]操作成功");
        messageMap.put(2, "[服务器]上传成功,请等待审核!");
        messageMap.put(3, "[服务器]审核完成!");
        messageMap.put(4, "[服务器]删除成功!");
        messageMap.put(5, "[服务器]修改成功!");
        messageMap.put(6, "[服务器]保存成功!");
        messageMap.put(7, "[服务器]未登录或登录超时!");

        messageMap.put(100, "[登录]登录成功");
        messageMap.put(101, "[登录]注销成功");
        messageMap.put(102, "[登录]无登录权限");
        messageMap.put(103, "[登录]账号错误");
        messageMap.put(104, "[登录]密码错误");

        messageMap.put(150, "[用户认证]认证表审批用户ID为空!");
        messageMap.put(151, "[用户认证]认证表查找不到被审批用户");
        messageMap.put(152, "[用户认证]审批失败:用户认证信息表为空!");
        messageMap.put(153, "[用户认证]审批失败:认证表审批状态异常!");
        messageMap.put(154, "[用户认证]审批失败:用户审批类型未指定!");
        messageMap.put(155, "[用户认证]审批失败:查找不到被审批用户!");
        messageMap.put(156, "[用户认证]保存失败,请登录!");
        messageMap.put(157, "[用户认证]授权失败:查找不到授权用户!");

        messageMap.put(200, "[折扣审批]审批失败:没有该折扣表!");

        messageMap.put(200, "[商品管理]错误:图片编码错误!");
        messageMap.put(201, "[商品管理]参数错误:未指定图片添加类型!");
        messageMap.put(202, "[商品管理]参数错误:未指定产品系列!");
        messageMap.put(203, "[商品管理]没有该商品!");
        messageMap.put(204, "[商品管理]该商品不在待审批状态!");
        messageMap.put(205, "[商品管理]保存错误!");
        messageMap.put(206, "[商品管理]无权修改该商品!");

        messageMap.put(250, "[用户管理]修改失败:没有用户ID!");
        messageMap.put(251, "[用户管理]修改失败:没有该用户!");
        messageMap.put(252, "[用户管理]修改失败:字段覆盖错误!");

        messageMap.put(300, "[角色管理]修改失败:没有查找到该用户角色!");

        messageMap.put(400, "[产品系列]删除失败:该系列下拥有产品!");
        messageMap.put(401, "[产品系列]没有找到该系列,可能已被删除!");

        messageMap.put(1000, "[服务器]错误:图片编码错误!");
        messageMap.put(1001, "[服务器]参数错误:未指定图片添加类型!");
        messageMap.put(1002, "[服务器]参数错误:传入参数类型错误,请校验!");
        messageMap.put(1003, "[服务器]参数错误:传入参数为空,请校验!");
        messageMap.put(1004, "[服务器]未知错误,请联系客服!");
        messageMap.put(1005, "[服务器]参数错误:参数类型转换错误,请联系客服!");
    }

    public static ReturnModel retParam(int returnCode) {
        ReturnModel rm = new ReturnModel();
        rm.setCode(returnCode);
        rm.setMsg(messageMap.get(returnCode));
        return rm;
    }
}
