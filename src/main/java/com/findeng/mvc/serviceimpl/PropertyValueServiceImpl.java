package com.findeng.mvc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeng.hibernate.dao.PropertyValueDao;
import com.findeng.hibernate.entity.PropertyValue;
import com.findeng.mvc.service.PropertyValueService;

/**
 * 产品属性表Service层
 *
 * @author Alien
 */
@Service
public class PropertyValueServiceImpl implements PropertyValueService {

    @Autowired
    PropertyValueDao propertyValueDao;

    /**
     * 批量通过产品属性id获取实体
     *
     * @param ids[]       产品属性id数组
     * @param haveProduct 该属性是否拥有产品字段
     * @return JSONObject
     */
    public List<PropertyValue> findByPropertyIdIn(int ids[], int haveProduct) {
        return propertyValueDao.findByPropertyIdInAndHaveProductEqualsOrderByPropertyIdAsc(ids, haveProduct);
    }

    public List<PropertyValue> findByPropertyId(Integer propertyId) {
        return propertyValueDao.findByPropertyId(propertyId);
    }

    /**
     * 通过id获取实体
     *
     * @param id
     * @return PropertyValue
     */
    public PropertyValue findById(Integer id) {
        return propertyValueDao.findOne(id);
    }

    /**
     * 将属性id数组转化为属性名
     *
     * @param String[] ids数组
     * @return String 属性名
     */
    public String findByIdToNameString(String[] ids) {
        String PropertyNames = "";
        for (String id : ids) {
            if (!id.equals(""))
                PropertyNames += propertyValueDao.findOne(
                        Integer.valueOf(id)).getPropertyValue() + " ";
        }
        return PropertyNames;
    }
}
