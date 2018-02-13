package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 提现到银行卡记录
 *
 * @author Alien
 */
@Entity
@Table(name = "withdraw_to_credit_card")
public class WithdrawToCreditCard implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String withdrawToCreditCardId;
    private String accountPerson;
    private String account;
    private String accountBank;
    private String contactPerson;
    private String contactWay;
    private Float withdrawMoney;
    private String accountProvince;
    private String accountCity;
    private Integer toWechat;
    private String accountBankSubName;

    @Id
    @Column(name = "withdraw_to_credit_card_id", unique = true, nullable = false, length = 32)
    public String getWithdrawToCreditCardId() {
        return this.withdrawToCreditCardId;
    }

    public void setWithdrawToCreditCardId(String withdrawToCreditCardId) {
        this.withdrawToCreditCardId = withdrawToCreditCardId;
    }

    @Column(name = "account_person", length = 128)
    public String getAccountPerson() {
        return this.accountPerson;
    }

    public void setAccountPerson(String accountPerson) {
        this.accountPerson = accountPerson;
    }

    @Column(name = "account", length = 128)
    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "account_bank", length = 128)
    public String getAccountBank() {
        return this.accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    @Column(name = "contact_person", length = 128)
    public String getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Column(name = "contact_way", length = 128)
    public String getContactWay() {
        return this.contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    @Column(name = "withdraw_money", precision = 11)
    public Float getWithdrawMoney() {
        return this.withdrawMoney;
    }

    public void setWithdrawMoney(Float withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    @Column(name = "account_province", length = 64)
    public String getAccountProvince() {
        return this.accountProvince;
    }

    public void setAccountProvince(String accountProvince) {
        this.accountProvince = accountProvince;
    }

    @Column(name = "account_city", length = 64)
    public String getAccountCity() {
        return this.accountCity;
    }

    public void setAccountCity(String accountCity) {
        this.accountCity = accountCity;
    }

    @Column(name = "to_wechat")
    public Integer getToWechat() {
        return this.toWechat;
    }

    public void setToWechat(Integer toWechat) {
        this.toWechat = toWechat;
    }

    @Column(name = "account_bank_sub_name", length = 128)
    public String getAccountBankSubName() {
        return this.accountBankSubName;
    }

    public void setAccountBankSubName(String accountBankSubName) {
        this.accountBankSubName = accountBankSubName;
    }

}