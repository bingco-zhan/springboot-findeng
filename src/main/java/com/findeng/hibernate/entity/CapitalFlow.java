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
 * 资金流水表
 *
 * @author Alien
 */
@Entity
@Table(name = "capital_flow")
public class CapitalFlow implements java.io.Serializable {

    /**
     * 待结算
     */
    public static final Integer STATUS_0 = 0;

    /**
     * 结算成功
     */
    public static final Integer STATUS_1 = 1;

    /**
     * 结算失败
     */
    public static final Integer STATUS_2 = 2;


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "capital_flow_id", unique = true, nullable = false, length = 32)
    private String capitalFlowId;

    @Column(name = "wechat_pay_id")
    private String wechatPayId;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "capital_flow_type")
    private Integer capitalFlowType;

    @Column(name = "money")
    private Float money;

    @Column(name = "settlement_status")
    private Integer settlementStatus;

    @Column(name = "creat_time")
    private Timestamp creatTime;

    @Column(name = "settle_time")
    private Timestamp settleTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getCapitalFlowId() {
        return this.capitalFlowId;
    }

    public void setCapitalFlowId(String capitalFlowId) {
        this.capitalFlowId = capitalFlowId;
    }

    public String getWechatPayId() {
        return wechatPayId;
    }

    public void setWechatPayId(String wechatPayId) {
        this.wechatPayId = wechatPayId;
    }

    public Integer getCapitalFlowType() {
        return this.capitalFlowType;
    }

    public void setCapitalFlowType(Integer capitalFlowType) {
        this.capitalFlowType = capitalFlowType;
    }

    public Float getMoney() {
        return this.money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getSettlementStatus() {
        return this.settlementStatus;
    }

    public void setSettlementStatus(Integer settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public Timestamp getCreatTime() {
        return this.creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public Timestamp getSettleTime() {
        return this.settleTime;
    }

    public void setSettleTime(Timestamp settleTime) {
        this.settleTime = settleTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

}