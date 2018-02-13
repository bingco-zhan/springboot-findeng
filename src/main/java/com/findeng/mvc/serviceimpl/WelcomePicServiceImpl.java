package com.findeng.mvc.serviceimpl;

import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.findeng.hibernate.dao.WelcomePicDao;
import com.findeng.hibernate.entity.WelcomePic;
import com.findeng.mvc.service.WelcomePicService;
import com.findeng.util.CommonUtil;
import com.findeng.util.ImageUtil;

/**
 * 欢迎图Service层
 */
@Transactional
@Service
public class WelcomePicServiceImpl implements WelcomePicService {

    @Autowired
    private WelcomePicDao welcomePicDao;

    @Value("${systemFile.WelcomePicSrc}")
    private String system_WelcomePicSrc;

    /**
     * 保存或更新欢迎图
     */
    @Override
    public WelcomePic save(WelcomePic wp) {
        //现在逻辑是上传的欢迎图直接成为欢迎图
        WelcomePic welcomePic = welcomePicDao.save(wp);
        setCurrentWelcomePic(welcomePic.getWelcomePicId());
        return welcomePic;
    }

    /**
     * 通过id查询欢迎图
     */
    @Override
    public WelcomePic findById(int id) {
        return welcomePicDao.findOne(id);
    }

    /**
     * 通过id删除欢迎图
     */
    @Override
    public void delete(int id) {
        welcomePicDao.delete(id);
    }

    /**
     * 生成欢迎图对象
     *
     * @param imgData base64数据
     * @param link    链接
     * @return WelcomePic 轮播图实体类
     */
    @Override
    public WelcomePic generateWelcomePic(String imgData, String link) {
        WelcomePic welcomePic = new WelcomePic();
        if (link != null) {
            welcomePic.setWelcomePicLink(link);
        }
        //如果数据为base64编码就生成图片并设置图片名
        if (imgData != null && imgData.indexOf("data:image") > -1) {
            File file = ImageUtil.saveBase64(imgData, system_WelcomePicSrc, CommonUtil.getUUID(), "jpg");
            welcomePic.setWelcomePicUrl(file.getName());
        }
        return welcomePic;
    }

    /**
     * 设置当前欢迎图
     */
    @Override
    public void setCurrentWelcomePic(int id) {
        List<WelcomePic> lists = welcomePicDao.findAll();
        for (WelcomePic wp : lists) {
            if (wp.getWelcomePicId() != id) {
                wp.setDeleteFlag(1);
            } else {
                wp.setDeleteFlag(0);
            }
            welcomePicDao.save(wp);
        }
    }

    /**
     * 获取当前欢迎图
     */
    @Override
    public WelcomePic getCurrentWelcomePic() {
        List<WelcomePic> wp = welcomePicDao.findByDeleteFlag(0);
        if (wp.size() == 0)
            return null;
        else
            return wp.get(0);
    }
}
