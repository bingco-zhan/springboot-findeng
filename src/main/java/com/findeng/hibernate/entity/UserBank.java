package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 保存用户填写过的银行卡信息
 *
 * @author Alien
 */
@Entity
@Table(name = "user_bank")
public class UserBank implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userBankId;
    private String userBankPerson;
    private String userBankAccount;
    private String userBankProvinceId;
    private String userBankCityId;
    private String userBankName;
    private String userBankSubName;
    private String userContactPerson;
    private String userContact;
    private Integer userId;

    @Id
    @GeneratedValue
    @Column(name = "user_bank_id", unique = true, nullable = false)
    public Integer getUserBankId() {
        return this.userBankId;
    }

    public void setUserBankId(Integer userBankId) {
        this.userBankId = userBankId;
    }

    @Column(name = "user_bank_person", length = 128)
    public String getUserBankPerson() {
        return this.userBankPerson;
    }

    public void setUserBankPerson(String userBankPerson) {
        this.userBankPerson = userBankPerson;
    }

    @Column(name = "user_bank_account", length = 256)
    public String getUserBankAccount() {
        return this.userBankAccount;
    }

    public void setUserBankAccount(String userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    @Column(name = "user_bank_province_id", length = 128)
    public String getUserBankProvinceId() {
        return this.userBankProvinceId;
    }

    public void setUserBankProvinceId(String userBankProvinceId) {
        this.userBankProvinceId = userBankProvinceId;
    }

    @Column(name = "user_bank_city_id", length = 128)
    public String getUserBankCityId() {
        return this.userBankCityId;
    }

    public void setUserBankCityId(String userBankCityId) {
        this.userBankCityId = userBankCityId;
    }

    @Column(name = "user_bank_name", length = 256)
    public String getUserBankName() {
        return this.userBankName;
    }

    public void setUserBankName(String userBankName) {
        this.userBankName = userBankName;
    }

    @Column(name = "user_bank_sub_name", length = 256)
    public String getUserBankSubName() {
        return this.userBankSubName;
    }

    public void setUserBankSubName(String userBankSubName) {
        this.userBankSubName = userBankSubName;
    }

    @Column(name = "user_contact_person", length = 256)
    public String getUserContactPerson() {
        return this.userContactPerson;
    }

    public void setUserContactPerson(String userContactPerson) {
        this.userContactPerson = userContactPerson;
    }

    @Column(name = "user_contact", length = 256)
    public String getUserContact() {
        return this.userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}