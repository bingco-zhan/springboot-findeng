package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户物流记录表
 *
 * @author Alien
 */
@Entity
@Table(name = "user_logistics")
public class UserLogistics implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userLogisticsId;
    private String logisticsCompanyName;
    private String logisticsPhoneNumber;
    private Integer userId;
    private String logisticsPark;

    @Id
    @GeneratedValue
    @Column(name = "user_logistics_id", unique = true, nullable = false)
    public Integer getUserLogisticsId() {
        return this.userLogisticsId;
    }

    public void setUserLogisticsId(Integer userLogisticsId) {
        this.userLogisticsId = userLogisticsId;
    }

    @Column(name = "logistics_company_name", length = 256)
    public String getLogisticsCompanyName() {
        return this.logisticsCompanyName;
    }

    public void setLogisticsCompanyName(String logisticsCompanyName) {
        this.logisticsCompanyName = logisticsCompanyName;
    }

    @Column(name = "logistics_phone_number", length = 64)
    public String getLogisticsPhoneNumber() {
        return this.logisticsPhoneNumber;
    }

    public void setLogisticsPhoneNumber(String logisticsPhoneNumber) {
        this.logisticsPhoneNumber = logisticsPhoneNumber;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "logistics_park", length = 256)
    public String getLogisticsPark() {
        return this.logisticsPark;
    }

    public void setLogisticsPark(String logisticsPark) {
        this.logisticsPark = logisticsPark;
    }

}