package com.findeng.mvc.serviceimpl;

import java.io.File;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.CarouselDao;
import com.findeng.hibernate.entity.Carousel;
import com.findeng.mvc.service.CarouselService;
import com.findeng.util.CommonUtil;
import com.findeng.util.ImageUtil;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;

/**
 * 手机商城轮播图Service层实现
 *
 * @author Alien
 */
@Transactional
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDao carouselDao;

    @Value("${systemFile.CarouselImageSrc}")
    private String system_CarouselImageSrc;

    /**
     * 获取所有轮播图
     *
     * @return List 轮播图实体类list
     */
    @Override
    public List<Carousel> findAll() {
        List<Carousel> Result = carouselDao.findAll();
        return Result;
    }

    /**
     * 通过id查找轮播图对象
     *
     * @param id 轮播图id
     * @return Carousel轮播图对象
     */
    public Carousel findById(int id) {
        return carouselDao.findOne(id);
    }

    /**
     * 保存轮播图
     */
    public JSONObject save(Carousel carousel) {
        carouselDao.save(carousel);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", new JSONObject(carousel), null);
    }

    /**
     * 生成轮播图对象
     *
     * @param imgData 轮播图base64字符串
     * @param Link    图片链接的url
     * @return 轮播图实体类
     */
    public Carousel generateCarousel(String imgData, String Link) {
        Carousel carousel = new Carousel();
        if (Link != null) {
            carousel.setCarouselLink(Link);
        }
        //如果数据为base64编码就生成图片并设置图片名
        if (imgData != null && imgData.indexOf("data:image") > -1) {
            File file = ImageUtil.saveBase64(imgData, system_CarouselImageSrc, CommonUtil.getUUID(), "jpg");
            carousel.setCarouselPic(file.getName());
        }
        return carousel;
    }

    /**
     * 通过id删除对象
     */
    public JSONObject delete(int id) {
        carouselDao.delete(id);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    /**
     * 更新轮播图
     *
     * @param id      轮播图id
     * @param imgData base64编码的图片
     * @param link    链接地址
     */
    public JSONObject updata(int id, String imgData, String Link) {
        Carousel carousel = findById(id);
        if (Link != null) {
            carousel.setCarouselLink(Link);
        }
        //如果数据为base64编码就生成图片并设置图片名
        if (imgData != null && imgData.indexOf("data:image") > -1) {
            File file = ImageUtil.saveBase64(imgData, system_CarouselImageSrc, CommonUtil.getUUID(), "jpg");
            carousel.setCarouselPic(file.getName());
        }
        carouselDao.save(carousel);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", new JSONObject(carousel), null);
    }
}
