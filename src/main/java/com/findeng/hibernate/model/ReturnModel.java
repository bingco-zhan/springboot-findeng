package com.findeng.hibernate.model;

/**
 * 服务器返回码和返回消息模型
 *
 * @author Alien
 */
public class ReturnModel {

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "[code=" + code + ", msg=" + msg + "]";
    }
}
