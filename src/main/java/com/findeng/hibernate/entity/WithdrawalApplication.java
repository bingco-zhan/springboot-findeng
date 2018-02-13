package com.findeng.hibernate.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 提现申请表
 *
 * @author Alien
 */
@Entity
@Table(name = "withdrawal_application")
public class WithdrawalApplication implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "launch_user_id")
    private User launchUser;

    @ManyToOne
    @JoinColumn(name = "application_user_id")
    private User applicationUser;

    @Column(name = "withdrawal_type")
    private Integer withdrawalType;

    @Column(name = "money")
    private Float money;

    @Column(name = "remark")
    private String remark;

    @Column(name = "creat_time")
    private Timestamp creatTime;

    @Column(name = "settle_time")
    private Timestamp settleTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getLaunchUser() {
        return launchUser;
    }

    public void setLaunchUser(User launchUser) {
        this.launchUser = launchUser;
    }

    public User getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(User applicationUser) {
        this.applicationUser = applicationUser;
    }

    public Integer getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(Integer withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public Timestamp getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Timestamp settleTime) {
        this.settleTime = settleTime;
    }


}