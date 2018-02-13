package com.findeng.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.findeng.hibernate.entity.PropertyValue;

/**
 * 产品属性表dao层
 *
 * @author Alien
 */
@Repository
public interface PropertyValueDao extends JpaRepository<PropertyValue, Integer> {

    /**
     * 根据产品风格查询热销产品
     *
     * @param haveProduct 该属性是否需要有产品
     * @param propertyId  产品属性id
     * @return 产品list
     */
    @Query(value = "select * from property_value where have_product=?1 and is_digital = 0 and property_id=?2 ORDER BY p_index ASC", nativeQuery = true)
    List<PropertyValue> findByPropertyId(int haveProduct, int PropertyId);

    List<PropertyValue> findByPropertyIdInAndHaveProductEqualsOrderByPropertyIdAsc(int[] ids, int haveProduct);

    public List<PropertyValue> findByPropertyId(Integer propertyId);
}
