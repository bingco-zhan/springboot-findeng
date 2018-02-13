package com.findeng.Enum;

/**
 * 用户的认证状态
 */
public class UserCheckStatus {

    //未认证
    public final static int UNAUTHORIZED = 0;

    //认证处理中
    public final static int AUTHORIZING = 1;

    //认证失败
    public final static int AUTHENTICATION_FAILURE = 2;

    //认证成功
    public final static int AUTHENTICATION_SUCCESS = 3;

    //信息更新中
    public final static int UPDATE_AUTHORIZING = 4;
}

