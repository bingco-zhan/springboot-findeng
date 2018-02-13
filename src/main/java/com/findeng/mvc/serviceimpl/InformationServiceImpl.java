package com.findeng.mvc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.InformationDao;
import com.findeng.hibernate.entity.Information;
import com.findeng.mvc.service.InformationService;


/**
 * 消息表Service层实现
 *
 * @author Alien
 */
@Transactional
@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationDao informationDao;

    /**
     * 持久化消息
     *
     * @param
     */
    @Override
    public Information save(Information information) {
        return informationDao.save(information);
    }

}
