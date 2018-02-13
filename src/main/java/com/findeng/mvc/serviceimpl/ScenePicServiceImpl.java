package com.findeng.mvc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.ScenePicDao;
import com.findeng.hibernate.entity.ScenePic;
import com.findeng.mvc.service.ScenePicService;

/**
 * 配灯系统场景图Service实现
 *
 * @author Alien
 */
@Transactional
@Service
public class ScenePicServiceImpl implements ScenePicService {

    @Autowired
    private ScenePicDao scenePicDao;

    @Override
    public ScenePic save(ScenePic scenePic) {
        return scenePicDao.save(scenePic);
    }
}
