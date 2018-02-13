package com.findeng.mvc.service;

import java.util.List;

import org.json.JSONObject;

import com.findeng.hibernate.entity.Carousel;

/**
 * 手机商城轮播图Service层接口
 *
 * @author Alien
 */
public interface CarouselService {

    public List<Carousel> findAll();

    public JSONObject save(Carousel carousel);

    public JSONObject delete(int id);

    public Carousel generateCarousel(String imgData, String Link);
}
