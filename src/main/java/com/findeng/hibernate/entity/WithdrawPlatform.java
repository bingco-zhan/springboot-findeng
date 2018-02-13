package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 平台提现记录
 *
 * @author Alien
 */
@Entity
@Table(name = "withdraw_platform")
public class WithdrawPlatform implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer withdrawPlatformId;
    private Float withdrawMoney;
    private Timestamp withdrawTime;
    private String withdrawPerson;

    @Id
    @GeneratedValue
    @Column(name = "withdraw_platform_id", unique = true, nullable = false)
    public Integer getWithdrawPlatformId() {
        return this.withdrawPlatformId;
    }

    public void setWithdrawPlatformId(Integer withdrawPlatformId) {
        this.withdrawPlatformId = withdrawPlatformId;
    }

    @Column(name = "withdraw_money", precision = 11)
    public Float getWithdrawMoney() {
        return this.withdrawMoney;
    }

    public void setWithdrawMoney(Float withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    @Column(name = "withdraw_time", length = 19)
    public Timestamp getWithdrawTime() {
        return this.withdrawTime;
    }

    public void setWithdrawTime(Timestamp withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    @Column(name = "withdraw_person", length = 128)
    public String getWithdrawPerson() {
        return this.withdrawPerson;
    }

    public void setWithdrawPerson(String withdrawPerson) {
        this.withdrawPerson = withdrawPerson;
    }
}