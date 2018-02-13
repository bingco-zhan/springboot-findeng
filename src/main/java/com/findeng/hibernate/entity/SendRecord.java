package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 发货记录
 *
 * @author Alien
 */
@Entity
@Table(name = "send_record")
public class SendRecord implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sendRecordId;
    private String sendLogisticsCompany;
    private String sendLogisticsPic;
    private Timestamp sendTime;
    private String orderNumber;
    private String description;
    private String transportNumber;
    private String sendPhoneNumber;
    private Integer sendUserId;

    @Id
    @GeneratedValue
    @Column(name = "send_record_id", unique = true, nullable = false)
    public Integer getSendRecordId() {
        return this.sendRecordId;
    }

    public void setSendRecordId(Integer sendRecordId) {
        this.sendRecordId = sendRecordId;
    }

    @Column(name = "send_logistics_company", length = 256)
    public String getSendLogisticsCompany() {
        return this.sendLogisticsCompany;
    }

    public void setSendLogisticsCompany(String sendLogisticsCompany) {
        this.sendLogisticsCompany = sendLogisticsCompany;
    }

    @Column(name = "send_logistics_pic", length = 256)
    public String getSendLogisticsPic() {
        return this.sendLogisticsPic;
    }

    public void setSendLogisticsPic(String sendLogisticsPic) {
        this.sendLogisticsPic = sendLogisticsPic;
    }

    @Column(name = "send_time", length = 19)
    public Timestamp getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Column(name = "order_number", length = 128)
    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Column(name = "description", length = 256)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "transport_number", length = 256)
    public String getTransportNumber() {
        return this.transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    @Column(name = "send_phone_number", length = 128)
    public String getSendPhoneNumber() {
        return this.sendPhoneNumber;
    }

    public void setSendPhoneNumber(String sendPhoneNumber) {
        this.sendPhoneNumber = sendPhoneNumber;
    }

    @Column(name = "send_user_id")
    public Integer getSendUserId() {
        return this.sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

}