package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 退款信息表
 *
 * @author Alien
 */
@Entity
@Table(name = "return_record")
public class ReturnRecord implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer returnInfoId;
    private Integer orderItemId;
    private String returnInfoDescribe;
    private Float returnInfoMoney;
    private Timestamp applyTime;
    private Timestamp handleTime;
    private Timestamp sendTime;
    private Timestamp receiveTime;
    private Timestamp refundTime;
    private Integer buyerId;
    private Integer sellerId;
    private Integer isLatest;
    private String buyerCapitalFlowId;
    private String sellerCapitalFlowId;
    private Integer payMoneyStatus;

    @Id
    @GeneratedValue
    @Column(name = "return_info_id", unique = true, nullable = false)
    public Integer getReturnInfoId() {
        return this.returnInfoId;
    }

    public void setReturnInfoId(Integer returnInfoId) {
        this.returnInfoId = returnInfoId;
    }

    @Column(name = "order_item_id")
    public Integer getOrderItemId() {
        return this.orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Column(name = "return_info_describe", length = 256)
    public String getReturnInfoDescribe() {
        return this.returnInfoDescribe;
    }

    public void setReturnInfoDescribe(String returnInfoDescribe) {
        this.returnInfoDescribe = returnInfoDescribe;
    }

    @Column(name = "return_info_money", precision = 12, scale = 0)
    public Float getReturnInfoMoney() {
        return this.returnInfoMoney;
    }

    public void setReturnInfoMoney(Float returnInfoMoney) {
        this.returnInfoMoney = returnInfoMoney;
    }

    @Column(name = "apply_time", length = 19)
    public Timestamp getApplyTime() {
        return this.applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Column(name = "handle_time", length = 19)
    public Timestamp getHandleTime() {
        return this.handleTime;
    }

    public void setHandleTime(Timestamp handleTime) {
        this.handleTime = handleTime;
    }

    @Column(name = "send_time", length = 19)
    public Timestamp getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Column(name = "receive_time", length = 19)
    public Timestamp getReceiveTime() {
        return this.receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Column(name = "refund_time", length = 19)
    public Timestamp getRefundTime() {
        return this.refundTime;
    }

    public void setRefundTime(Timestamp refundTime) {
        this.refundTime = refundTime;
    }

    @Column(name = "buyer_id")
    public Integer getBuyerId() {
        return this.buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @Column(name = "seller_id")
    public Integer getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Column(name = "is_latest")
    public Integer getIsLatest() {
        return this.isLatest;
    }

    public void setIsLatest(Integer isLatest) {
        this.isLatest = isLatest;
    }

    @Column(name = "buyer_capital_flow_id", length = 32)
    public String getBuyerCapitalFlowId() {
        return this.buyerCapitalFlowId;
    }

    public void setBuyerCapitalFlowId(String buyerCapitalFlowId) {
        this.buyerCapitalFlowId = buyerCapitalFlowId;
    }

    @Column(name = "seller_capital_flow_id", length = 32)
    public String getSellerCapitalFlowId() {
        return this.sellerCapitalFlowId;
    }

    public void setSellerCapitalFlowId(String sellerCapitalFlowId) {
        this.sellerCapitalFlowId = sellerCapitalFlowId;
    }

    @Column(name = "pay_money_status")
    public Integer getPayMoneyStatus() {
        return this.payMoneyStatus;
    }

    public void setPayMoneyStatus(Integer payMoneyStatus) {
        this.payMoneyStatus = payMoneyStatus;
    }

}