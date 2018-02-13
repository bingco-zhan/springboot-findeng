package com.findeng.mvc.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.findeng.hibernate.entity.Customerbinding;
import com.findeng.hibernate.entity.User;

public interface CustomerbindingService {

    public Map<String, Object> save(User apply, User unbundling);

    public Page<Customerbinding> findCustomerBindingList(Customerbinding customerbinding, Integer offset, Integer limit, String field, String sort);

    public Map<String, Object> update(Integer id, Integer status);

}
