package com.findeng.hibernate.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 订单项表，一个订单包含多个订单项，每个订单项对应一种产品
 *
 * @author Alien
 */
@Entity
@Table(name = "order_item")
public class OrderItem implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", unique = true, nullable = false)
    private Integer orderItemId;

    @Column(name = "order_number")
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "order_item_price")
    private Float orderItemPrice;

    @Column(name = "order_item_number")
    private Integer orderItemNumber;

    @Column(name = "refund_status")
    private Integer refundStatus;

    @Column(name = "return_status")
    private Integer returnStatus;

    @OneToOne
    @JoinColumn(name = "refund_id")
    private ReturnRecord returnRecord;

    @Column(name = "return_id")
    private Integer returnId;

    @Column(name = "order_item_commision")
    private Float orderItemCommision;

    @Column(name = "order_item_freight")
    private Float orderItemFreight;

    @Column(name = "order_item_service_fee")
    private Float orderItemServiceFee;

    @Column(name = "order_item_install_fee")
    private Float orderItemInstallFee;

    @Column(name = "platform_percent")
    private Float platformPercent;

    @Column(name = "spread_percent")
    private Float spreadPercent;

    @Column(name = "order_item_origin_price")
    private Float orderItemOriginPrice;

    @Column(name = "receive_address")
    private Integer receiveAddress;

    @Column(name = "have_goods_num")
    private Integer haveGoodsNum;

    @Column(name = "consignment_time")
    private Integer consignmentTime;

    @Column(name = "is_rush_order")
    private Integer isRushOrder;

    @Column(name = "remark")
    private String remark;

    @Column(name = "send_flag")
    private Integer sendFlag;

    @Column(name = "factory_send_flag")
    private Integer factorySendFlag;

    @Column(name = "send_number")
    private Integer sendNumber;

    @Column(name = "factory_send_number")
    private Integer factorySendNumber;

    @Column(name = "perpare_send_flag")
    private Integer perpareSendFlag;

    @Column(name = "perpare_send_number")
    private Integer perpareSendNumber;

    @Column(name = "stocked_flag")
    private Integer stockedFlag;

    @Column(name = "stocked_number")
    private Integer stockedNumber;

    @Column(name = "order_item_remark")
    private String orderItemRemark;

    @Column(name = "receive_flag")
    private Integer receiveFlag;

    @Column(name = "receive_number")
    private Integer receiveNumber;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "wooden_fee")
    private Float woodenFee;

    @Column(name = "pendding_after_sale")
    private Integer penddingAfterSale;

    @Column(name = "spot_goods_num")
    private Integer spotGoodsNum;

    @Column(name = "stock_reason")
    private String stockReason;

    @Column(name = "expect_total_delivery_time")
    private Timestamp expecttotaldeliverytime;

    @Column(name = "actual_total_delivery_time")
    private Timestamp actualtotaldeliverytime;

    @Column(name = "delay_remarks")
    private String delayremarks;

    public Integer getOrderItemId() {
        return this.orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Float getOrderItemPrice() {
        return this.orderItemPrice;
    }

    public void setOrderItemPrice(Float orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public Integer getOrderItemNumber() {
        return this.orderItemNumber;
    }

    public void setOrderItemNumber(Integer orderItemNumber) {
        this.orderItemNumber = orderItemNumber;
    }

    public Integer getRefundStatus() {
        return this.refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getReturnStatus() {
        return this.returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    public ReturnRecord getReturnRecord() {
        return this.returnRecord;
    }

    public void setReturnRecord(ReturnRecord returnRecord) {
        this.returnRecord = returnRecord;
    }

    public Integer getReturnId() {
        return this.returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Float getOrderItemCommision() {
        return this.orderItemCommision;
    }

    public void setOrderItemCommision(Float orderItemCommision) {
        this.orderItemCommision = orderItemCommision;
    }

    public Float getOrderItemFreight() {
        return this.orderItemFreight;
    }

    public void setOrderItemFreight(Float orderItemFreight) {
        this.orderItemFreight = orderItemFreight;
    }

    public Float getOrderItemServiceFee() {
        return this.orderItemServiceFee;
    }

    public void setOrderItemServiceFee(Float orderItemServiceFee) {
        this.orderItemServiceFee = orderItemServiceFee;
    }

    public Float getOrderItemInstallFee() {
        return this.orderItemInstallFee;
    }

    public void setOrderItemInstallFee(Float orderItemInstallFee) {
        this.orderItemInstallFee = orderItemInstallFee;
    }

    public Float getPlatformPercent() {
        return this.platformPercent;
    }

    public void setPlatformPercent(Float platformPercent) {
        this.platformPercent = platformPercent;
    }

    public Float getSpreadPercent() {
        return this.spreadPercent;
    }

    public void setSpreadPercent(Float spreadPercent) {
        this.spreadPercent = spreadPercent;
    }

    public Float getOrderItemOriginPrice() {
        return this.orderItemOriginPrice;
    }

    public void setOrderItemOriginPrice(Float orderItemOriginPrice) {
        this.orderItemOriginPrice = orderItemOriginPrice;
    }

    public Integer getReceiveAddress() {
        return this.receiveAddress;
    }

    public void setReceiveAddress(Integer receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public Integer getHaveGoodsNum() {
        return this.haveGoodsNum;
    }

    public void setHaveGoodsNum(Integer haveGoodsNum) {
        this.haveGoodsNum = haveGoodsNum;
    }

    public Integer getConsignmentTime() {
        return this.consignmentTime;
    }

    public void setConsignmentTime(Integer consignmentTime) {
        this.consignmentTime = consignmentTime;
    }

    public Integer getIsRushOrder() {
        return this.isRushOrder;
    }

    public void setIsRushOrder(Integer isRushOrder) {
        this.isRushOrder = isRushOrder;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSendFlag() {
        return this.sendFlag;
    }

    public void setSendFlag(Integer sendFlag) {
        this.sendFlag = sendFlag;
    }

    public Integer getFactorySendFlag() {
        return this.factorySendFlag;
    }

    public void setFactorySendFlag(Integer factorySendFlag) {
        this.factorySendFlag = factorySendFlag;
    }

    public Integer getSendNumber() {
        return this.sendNumber;
    }

    public void setSendNumber(Integer sendNumber) {
        this.sendNumber = sendNumber;
    }

    public Integer getFactorySendNumber() {
        return this.factorySendNumber;
    }

    public void setFactorySendNumber(Integer factorySendNumber) {
        this.factorySendNumber = factorySendNumber;
    }

    public Integer getPerpareSendFlag() {
        return this.perpareSendFlag;
    }

    public void setPerpareSendFlag(Integer perpareSendFlag) {
        this.perpareSendFlag = perpareSendFlag;
    }

    public Integer getPerpareSendNumber() {
        return this.perpareSendNumber;
    }

    public void setPerpareSendNumber(Integer perpareSendNumber) {
        this.perpareSendNumber = perpareSendNumber;
    }

    public Integer getStockedFlag() {
        return this.stockedFlag;
    }

    public void setStockedFlag(Integer stockedFlag) {
        this.stockedFlag = stockedFlag;
    }

    public Integer getStockedNumber() {
        return this.stockedNumber;
    }

    public void setStockedNumber(Integer stockedNumber) {
        this.stockedNumber = stockedNumber;
    }

    public String getOrderItemRemark() {
        return this.orderItemRemark;
    }

    public void setOrderItemRemark(String orderItemRemark) {
        this.orderItemRemark = orderItemRemark;
    }

    public Integer getReceiveFlag() {
        return this.receiveFlag;
    }

    public void setReceiveFlag(Integer receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public Integer getReceiveNumber() {
        return this.receiveNumber;
    }

    public void setReceiveNumber(Integer receiveNumber) {
        this.receiveNumber = receiveNumber;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getWoodenFee() {
        return this.woodenFee;
    }

    public void setWoodenFee(Float woodenFee) {
        this.woodenFee = woodenFee;
    }

    public Integer getPenddingAfterSale() {
        return this.penddingAfterSale;
    }

    public void setPenddingAfterSale(Integer penddingAfterSale) {
        this.penddingAfterSale = penddingAfterSale;
    }

    public Integer getSpotGoodsNum() {
        return this.spotGoodsNum;
    }

    public void setSpotGoodsNum(Integer spotGoodsNum) {
        this.spotGoodsNum = spotGoodsNum;
    }

    public String getStockReason() {
        return this.stockReason;
    }

    public void setStockReason(String stockReason) {
        this.stockReason = stockReason;
    }

    public Timestamp getExpecttotaldeliverytime() {
        return expecttotaldeliverytime;
    }

    public void setExpecttotaldeliverytime(Timestamp expecttotaldeliverytime) {
        this.expecttotaldeliverytime = expecttotaldeliverytime;
    }

    public Timestamp getActualtotaldeliverytime() {
        return actualtotaldeliverytime;
    }

    public void setActualtotaldeliverytime(Timestamp actualtotaldeliverytime) {
        this.actualtotaldeliverytime = actualtotaldeliverytime;
    }

    public String getDelayremarks() {
        return delayremarks;
    }

    public void setDelayremarks(String delayremarks) {
        this.delayremarks = delayremarks;
    }

}