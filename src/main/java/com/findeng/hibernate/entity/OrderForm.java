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
 * 订单表，保存订单相关数据
 *
 * @author Alien
 */
@Entity
@Table(name = "order_form")
public class OrderForm implements java.io.Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_number", unique = true, nullable = false, length = 32)
    private String orderNumber;

    @Column(name = "wechat_pay_id")
    private String wechatPayId;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "order_money")
    private Float orderMoney;

    @Column(name = "order_service_money", precision = 11)
    private Float orderServiceMoney;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "receive_person")
    private String receivePerson;

    @Column(name = "receive_phone")
    private String receivePhone;

    @Column(name = "receive_province")
    private String receiveProvince;

    @Column(name = "receive_city")
    private String receiveCity;

    @Column(name = "receive_area")
    private String receiveArea;

    @Column(name = "receive_address")
    private String receiveAddress;

    @Column(name = "logistics_company_code")
    private String logisticsCompanyCode;

    @Column(name = "transport_number")
    private String transportNumber;

    @Column(name = "order_time")
    private Timestamp orderTime;

    @Column(name = "pay_time")
    private Timestamp payTime;

    @Column(name = "send_time")
    private Timestamp sendTime;

    @Column(name = "receive_time")
    private Timestamp receiveTime;

    @Column(name = "service_time")
    private Timestamp serviceTime;

    @Column(name = "complete_time")
    private Timestamp completeTime;

    @Column(name = "if_happen_return")
    private Integer ifHappenReturn;

    @Column(name = "if_happen_refund")
    private Integer ifHappenRefund;

    @Column(name = "refund_return_pending_num")
    private Integer refundReturnPendingNum;

    @Column(name = "facilitator_id")
    private Integer facilitatorId;

    @Column(name = "is_install")
    private Integer isInstall;

    @Column(name = "order_install_money")
    private Float orderInstallMoney;

    @Column(name = "order_service_status")
    private Integer orderServiceStatus;

    @Column(name = "order_install_person")
    private String orderInstallPerson;

    @Column(name = "order_install_person_contact")
    private String orderInstallPersonContact;

    @Column(name = "order_real_money")
    private Float orderRealMoney;

    @Column(name = "transport_type")
    private Integer transportType;

    @Column(name = "recommend_logistics")
    private String recommendLogistics;

    @ManyToOne
    @JoinColumn(name = "up_user_id")
    private User upUser;

    @Column(name = "up_up_user_id")
    private Integer upUpUserId;

    @Column(name = "transport_phone_number")
    private String transportPhoneNumber;

    @Column(name = "to_platform")
    private Integer toPlatform;

    @Column(name = "order_freight")
    private Float orderFreight;

    @Column(name = "factory_send_flag")
    private Integer factorySendFlag;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Column(name = "prepare_send_flag")
    private Integer prepareSendFlag;

    @Column(name = "order_logistics_pic")
    private String orderLogisticsPic;

    @Column(name = "send_flag")
    private Integer sendFlag;

    @Column(name = "stocked_flag")
    private Integer stockedFlag;

    @Column(name = "stocked_complete")
    private Integer stockedComplete;

    @Column(name = "order_remark")
    private String orderRemark;

    @Column(name = "logistics_park")
    private String logisticsPark;

    @Column(name = "factory_send_time")
    private Timestamp factorySendTime;

    @Column(name = "really_receive_flag")
    private Integer reallyReceiveFlag;

    @Column(name = "order_wooden_fee")
    private Float orderWoodenFee;

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getWechatPayId() {
        return this.wechatPayId;
    }

    public void setWechatPayId(String wechatPayId) {
        this.wechatPayId = wechatPayId;
    }

    public User getSeller() {
        return this.seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return this.buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Float getOrderMoney() {
        return this.orderMoney;
    }

    public void setOrderMoney(Float orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Float getOrderServiceMoney() {
        return this.orderServiceMoney;
    }

    public void setOrderServiceMoney(Float orderServiceMoney) {
        this.orderServiceMoney = orderServiceMoney;
    }

    public Integer getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getReceivePerson() {
        return this.receivePerson;
    }

    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson;
    }

    public String getReceivePhone() {
        return this.receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveProvince() {
        return this.receiveProvince;
    }

    public void setReceiveProvince(String receiveProvince) {
        this.receiveProvince = receiveProvince;
    }

    public String getReceiveCity() {
        return this.receiveCity;
    }

    public void setReceiveCity(String receiveCity) {
        this.receiveCity = receiveCity;
    }

    public String getReceiveArea() {
        return this.receiveArea;
    }

    public void setReceiveArea(String receiveArea) {
        this.receiveArea = receiveArea;
    }

    public String getReceiveAddress() {
        return this.receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getLogisticsCompanyCode() {
        return this.logisticsCompanyCode;
    }

    public void setLogisticsCompanyCode(String logisticsCompanyCode) {
        this.logisticsCompanyCode = logisticsCompanyCode;
    }

    public String getTransportNumber() {
        return this.transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public Timestamp getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getPayTime() {
        return this.payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Timestamp getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Timestamp getReceiveTime() {
        return this.receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Timestamp getServiceTime() {
        return this.serviceTime;
    }

    public void setServiceTime(Timestamp serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Timestamp getCompleteTime() {
        return this.completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getIfHappenReturn() {
        return this.ifHappenReturn;
    }

    public void setIfHappenReturn(Integer ifHappenReturn) {
        this.ifHappenReturn = ifHappenReturn;
    }

    public Integer getIfHappenRefund() {
        return this.ifHappenRefund;
    }

    public void setIfHappenRefund(Integer ifHappenRefund) {
        this.ifHappenRefund = ifHappenRefund;
    }

    public Integer getRefundReturnPendingNum() {
        return this.refundReturnPendingNum;
    }

    public void setRefundReturnPendingNum(Integer refundReturnPendingNum) {
        this.refundReturnPendingNum = refundReturnPendingNum;
    }

    public Integer getFacilitatorId() {
        return this.facilitatorId;
    }

    public void setFacilitatorId(Integer facilitatorId) {
        this.facilitatorId = facilitatorId;
    }

    public Integer getIsInstall() {
        return this.isInstall;
    }

    public void setIsInstall(Integer isInstall) {
        this.isInstall = isInstall;
    }

    public Float getOrderInstallMoney() {
        return this.orderInstallMoney;
    }

    public void setOrderInstallMoney(Float orderInstallMoney) {
        this.orderInstallMoney = orderInstallMoney;
    }

    public Integer getOrderServiceStatus() {
        return this.orderServiceStatus;
    }

    public void setOrderServiceStatus(Integer orderServiceStatus) {
        this.orderServiceStatus = orderServiceStatus;
    }

    public String getOrderInstallPerson() {
        return this.orderInstallPerson;
    }

    public void setOrderInstallPerson(String orderInstallPerson) {
        this.orderInstallPerson = orderInstallPerson;
    }

    public String getOrderInstallPersonContact() {
        return this.orderInstallPersonContact;
    }

    public void setOrderInstallPersonContact(String orderInstallPersonContact) {
        this.orderInstallPersonContact = orderInstallPersonContact;
    }

    public Float getOrderRealMoney() {
        return this.orderRealMoney;
    }

    public void setOrderRealMoney(Float orderRealMoney) {
        this.orderRealMoney = orderRealMoney;
    }

    public Integer getTransportType() {
        return this.transportType;
    }

    public void setTransportType(Integer transportType) {
        this.transportType = transportType;
    }

    public String getRecommendLogistics() {
        return this.recommendLogistics;
    }

    public void setRecommendLogistics(String recommendLogistics) {
        this.recommendLogistics = recommendLogistics;
    }

    public User getUpUser() {
        return this.upUser;
    }

    public void setUpUser(User upUser) {
        this.upUser = upUser;
    }

    public Integer getUpUpUserId() {
        return this.upUpUserId;
    }

    public void setUpUpUserId(Integer upUpUserId) {
        this.upUpUserId = upUpUserId;
    }

    public String getTransportPhoneNumber() {
        return this.transportPhoneNumber;
    }

    public void setTransportPhoneNumber(String transportPhoneNumber) {
        this.transportPhoneNumber = transportPhoneNumber;
    }

    public Integer getToPlatform() {
        return this.toPlatform;
    }

    public void setToPlatform(Integer toPlatform) {
        this.toPlatform = toPlatform;
    }

    public Float getOrderFreight() {
        return this.orderFreight;
    }

    public void setOrderFreight(Float orderFreight) {
        this.orderFreight = orderFreight;
    }

    public Integer getFactorySendFlag() {
        return this.factorySendFlag;
    }

    public void setFactorySendFlag(Integer factorySendFlag) {
        this.factorySendFlag = factorySendFlag;
    }

    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getPrepareSendFlag() {
        return this.prepareSendFlag;
    }

    public void setPrepareSendFlag(Integer prepareSendFlag) {
        this.prepareSendFlag = prepareSendFlag;
    }

    public String getOrderLogisticsPic() {
        return this.orderLogisticsPic;
    }

    public void setOrderLogisticsPic(String orderLogisticsPic) {
        this.orderLogisticsPic = orderLogisticsPic;
    }

    public Integer getSendFlag() {
        return this.sendFlag;
    }

    public void setSendFlag(Integer sendFlag) {
        this.sendFlag = sendFlag;
    }

    public Integer getStockedFlag() {
        return this.stockedFlag;
    }

    public void setStockedFlag(Integer stockedFlag) {
        this.stockedFlag = stockedFlag;
    }

    public Integer getStockedComplete() {
        return this.stockedComplete;
    }

    public void setStockedComplete(Integer stockedComplete) {
        this.stockedComplete = stockedComplete;
    }

    public String getOrderRemark() {
        return this.orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getLogisticsPark() {
        return this.logisticsPark;
    }

    public void setLogisticsPark(String logisticsPark) {
        this.logisticsPark = logisticsPark;
    }

    public Timestamp getFactorySendTime() {
        return this.factorySendTime;
    }

    public void setFactorySendTime(Timestamp factorySendTime) {
        this.factorySendTime = factorySendTime;
    }

    public Integer getReallyReceiveFlag() {
        return this.reallyReceiveFlag;
    }

    public void setReallyReceiveFlag(Integer reallyReceiveFlag) {
        this.reallyReceiveFlag = reallyReceiveFlag;
    }

    public Float getOrderWoodenFee() {
        return this.orderWoodenFee;
    }

    public void setOrderWoodenFee(Float orderWoodenFee) {
        this.orderWoodenFee = orderWoodenFee;
    }

}