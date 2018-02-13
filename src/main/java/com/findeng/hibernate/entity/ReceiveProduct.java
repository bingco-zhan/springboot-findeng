package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品收货记录
 *
 * @author Alien
 */
@Entity
@Table(name = "receive_product")
public class ReceiveProduct implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer receiveProductId;
    private Integer receiveOrderItemId;
    private Timestamp receiveTime;
    private Integer receiveUserId;
    private Integer receiveNumber;

    @Id
    @GeneratedValue
    @Column(name = "receive_product_id", unique = true, nullable = false)
    public Integer getReceiveProductId() {
        return this.receiveProductId;
    }

    public void setReceiveProductId(Integer receiveProductId) {
        this.receiveProductId = receiveProductId;
    }

    @Column(name = "receive_orderItem_id")
    public Integer getReceiveOrderItemId() {
        return this.receiveOrderItemId;
    }

    public void setReceiveOrderItemId(Integer receiveOrderItemId) {
        this.receiveOrderItemId = receiveOrderItemId;
    }

    @Column(name = "receive_time", length = 19)
    public Timestamp getReceiveTime() {
        return this.receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Column(name = "receive_user_id")
    public Integer getReceiveUserId() {
        return this.receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    @Column(name = "receive_number")
    public Integer getReceiveNumber() {
        return this.receiveNumber;
    }

    public void setReceiveNumber(Integer receiveNumber) {
        this.receiveNumber = receiveNumber;
    }

}