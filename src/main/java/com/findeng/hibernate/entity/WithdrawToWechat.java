package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 提现到微信记录
 *
 * @author Alien
 */
@Entity
@Table(name = "withdraw_to_wechat")
public class WithdrawToWechat implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String withdrawToWechatId;
    private String withdrawDescription;
    private Float withdrawMoney;

    @Id
    @Column(name = "withdraw_to_wechat_id", unique = true, nullable = false, length = 32)
    public String getWithdrawToWechatId() {
        return this.withdrawToWechatId;
    }

    public void setWithdrawToWechatId(String withdrawToWechatId) {
        this.withdrawToWechatId = withdrawToWechatId;
    }

    @Column(name = "withdraw_description", length = 128)
    public String getWithdrawDescription() {
        return this.withdrawDescription;
    }

    public void setWithdrawDescription(String withdrawDescription) {
        this.withdrawDescription = withdrawDescription;
    }

    @Column(name = "withdraw_money", precision = 11)
    public Float getWithdrawMoney() {
        return this.withdrawMoney;
    }

    public void setWithdrawMoney(Float withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

}