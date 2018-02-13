package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 店铺地址
 *
 * @author Alien
 */
@Entity
@Table(name = "store_address")
public class StoreAddress implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer storeAddressId;
    private Integer userId;
    private String provinceId;
    private String cityId;
    private String areaId;
    private String addressDetail;

    @Id
    @GeneratedValue
    @Column(name = "store_address_id", unique = true, nullable = false)
    public Integer getStoreAddressId() {
        return this.storeAddressId;
    }

    public void setStoreAddressId(Integer storeAddressId) {
        this.storeAddressId = storeAddressId;
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

}