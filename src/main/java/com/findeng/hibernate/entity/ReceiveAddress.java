package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 收货地址表
 *
 * @author Alien
 */
@Entity
@Table(name = "receive_address")
public class ReceiveAddress implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer receiveAddressId;
    private Integer userId;
    private String provinceId;
    private String cityId;
    private String areaId;
    private String addressDetail;
    private Integer defaultFlag;
    private String receivePerson;
    private String contactNumber;

    @Id
    @GeneratedValue
    @Column(name = "receive_address_id", unique = true, nullable = false)
    public Integer getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public void setReceiveAddressId(Integer receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "province_id", length = 128)
    public String getProvinceId() {
        return this.provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    @Column(name = "city_id", length = 128)
    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Column(name = "area_id", length = 128)
    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Column(name = "address_detail", length = 256)
    public String getAddressDetail() {
        return this.addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Column(name = "default_flag")
    public Integer getDefaultFlag() {
        return this.defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    @Column(name = "receive_person", length = 32)
    public String getReceivePerson() {
        return this.receivePerson;
    }

    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson;
    }

    @Column(name = "contact_number", length = 16)
    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}