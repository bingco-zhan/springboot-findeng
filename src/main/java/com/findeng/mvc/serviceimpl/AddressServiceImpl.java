package com.findeng.mvc.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.AddressDao;
import com.findeng.hibernate.entity.Address;
import com.findeng.mvc.service.AddressService;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    /**
     * 根据主键查询地址实体
     *
     * @param 主键id
     * @return null或者地址实体
     */
    @Override
    public Address findById(String id) {
        return (id == null || id.isEmpty()) ? null : addressDao.findByAddressId(id);
    }

    /**
     * 根据省、市、区/镇、具体地址 查询
     *
     * @param provinceId 省ID
     * @param cityId     市ID
     * @param areaId     区/镇ID
     */
    @Override
    public Map<String, Address> findByAddressName(String provinceId, String cityId, String areaId) {
        Map<String, Address> address = new HashMap<>();
        Address province = provinceId == null ? null : addressDao.findByAddressId(provinceId);
        Address city = cityId == null ? null : addressDao.findByAddressId(cityId);
        Address area = areaId == null ? null : addressDao.findByAddressId(areaId);
        address.put("province", province);
        address.put("city", city);
        address.put("area", area);
        return address;
    }

    /**
     * 根据地址表上级ID查询地址集合
     */
    @Override
    public List<Address> findeByUpId(String upId) {
        List<Address> list = addressDao.findByupAddressId(upId);
        return list;
    }
}
