package com.findeng.mvc.service;

import java.util.List;
import java.util.Map;

import com.findeng.hibernate.entity.Address;

public interface AddressService {

    public Address findById(String id);

    public Map<String, Address> findByAddressName(String provinceId, String cityId, String areaId);

    public List<Address> findeByUpId(String upId);
}
