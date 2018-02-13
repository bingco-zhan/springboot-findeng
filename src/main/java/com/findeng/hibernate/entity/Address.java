package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地址表
 *
 * @author Alien
 */
@Entity
@Table(name = "address")
public class Address implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String addressId;
    private String upAddressId;
    private String addressName;

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    public String getAddressId() {
        return this.addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Column(name = "up_address_id", length = 128)
    public String getUpAddressId() {
        return this.upAddressId;
    }

    public void setUpAddressId(String upAddressId) {
        this.upAddressId = upAddressId;
    }

    @Column(name = "address_name", nullable = false, length = 128)
    public String getAddressName() {
        return this.addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

}