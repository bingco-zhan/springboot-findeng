package com.findeng.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.findeng.hibernate.model.ReturnModel;

public class WebUtil {

    /**
     * ajax通用响应数据封装方法
     *
     * @param success 操作是否成功
     * @param message 携带信息
     * @return
     */
    public static Map<String, Object> resposeAjax(boolean success, String message) {
        Map<String, Object> rlt = new HashMap<>();
        rlt.put("success", success);
        rlt.put("message", message);
        return rlt;
    }

    /**
     * ajax通用返回JSONObject数据方法
     *
     * @param code   服务器操作结果code
     * @param msg    服务器返回消息
     * @param url    需要重定向时返回的字段
     * @param entity 需要回传的实体类
     * @param arr    需要回传的数组
     */
    public static JSONObject resposeJSONObject(ReturnModel rm, String url, Object entity, List<?> arr) {
        JSONObject re = new JSONObject();
        re.put("code", rm.getCode());
        re.put("msg", rm.getMsg());
        re.put("url", url);
        re.put("entity", entity);
        re.put("arr", arr);
        return re;
    }

    /**
     * 返回bootstrap-table数据格式
     *
     * @param total 数据统计条数
     * @param rows  JSONArray数据
     * @return JSONObject
     */
    public static <T> JSONObject resposeTableData(long total, List<T> rows) {
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "读取成功");
        obj.put("total", total);
        obj.put("rows", rows);
        return obj;
    }

    public static <T> JSONObject resposeTableData(long total, List<T> rows, int code, String msg) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("msg", msg);
        obj.put("total", total);
        obj.put("rows", rows);
        return obj;
    }

}
