package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品属性值表
 *
 * @author Alien
 */
@Entity
@Table(name = "property_value")
public class PropertyValue implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer propertyValueId;
    private Integer propertyId;
    private String propertyValue;
    private Integer isDigital;
    private String propertyDesc;
    private Integer PIndex;
    private Integer haveProduct;

    @Id
    @GeneratedValue
    @Column(name = "property_value_id", unique = true, nullable = false)
    public Integer getPropertyValueId() {
        return this.propertyValueId;
    }

    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    @Column(name = "property_id")
    public Integer getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    @Column(name = "property_value", length = 128)
    public String getPropertyValue() {
        return this.propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Column(name = "is_digital")
    public Integer getIsDigital() {
        return this.isDigital;
    }

    public void setIsDigital(Integer isDigital) {
        this.isDigital = isDigital;
    }

    @Column(name = "property_desc", length = 128)
    public String getPropertyDesc() {
        return this.propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
    }

    @Column(name = "p_index")
    public Integer getPIndex() {
        return this.PIndex;
    }

    public void setPIndex(Integer PIndex) {
        this.PIndex = PIndex;
    }

    @Column(name = "have_product")
    public Integer getHaveProduct() {
        return this.haveProduct;
    }

    public void setHaveProduct(Integer haveProduct) {
        this.haveProduct = haveProduct;
    }
}