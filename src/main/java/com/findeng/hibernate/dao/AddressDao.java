package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

    /**
     * 通过主键查询实体
     *
     * @param addressId 主键
     * @return Address
     */
    public Address findByAddressId(String addressId);

    /**
     * 根据地址表上级ID查询地址集合
     *
     * @param upId 上级主键
     * @return List<Address>
     */
    public List<Address> findByupAddressId(String upId);
}
