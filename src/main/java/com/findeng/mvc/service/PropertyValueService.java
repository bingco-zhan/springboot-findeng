package com.findeng.mvc.service;

import java.util.List;

import com.findeng.hibernate.entity.PropertyValue;

public interface PropertyValueService {

    public List<PropertyValue> findByPropertyIdIn(int ids[], int haveProduct);

    public PropertyValue findById(Integer id);

    public String findByIdToNameString(String[] materials);
}
