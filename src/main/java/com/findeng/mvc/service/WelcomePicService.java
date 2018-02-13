package com.findeng.mvc.service;

import com.findeng.hibernate.entity.WelcomePic;

/**
 * 欢迎图接口类
 */
public interface WelcomePicService {

    public WelcomePic save(WelcomePic wp);

    public WelcomePic findById(int id);

    public void delete(int id);

    public WelcomePic generateWelcomePic(String imgData, String link);

    public void setCurrentWelcomePic(int id);

    public WelcomePic getCurrentWelcomePic();
}
