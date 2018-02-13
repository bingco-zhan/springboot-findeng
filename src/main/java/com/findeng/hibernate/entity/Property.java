package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品属性表
 *
 * @author Alien
 */
@Entity
@Table(name = "property")
public class Property implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer propertyId;
    private String propertyName;
    private Integer isRequired;

    @Id
    @GeneratedValue
    @Column(name = "property_id", unique = true, nullable = false)
    public Integer getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    @Column(name = "property_name", length = 64)
    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Column(name = "is_required")
    public Integer getIsRequired() {
        return this.isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

}