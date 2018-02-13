package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 售后信息表
 *
 * @author Alien
 */
@Entity
@Table(name = "after_sale")
public class AfterSale implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer afterSaleId;
    private Integer afterSaleStatus;
    private Integer afterSaleUserId;
    private Timestamp applyTime;
    private Timestamp checkTime;
    private Timestamp handleTime;
    private String afterSalePic1;
    private String afterSalePic2;
    private String afterSalePic3;
    private String afterSaleDescription;
    private Integer afterSaleOrderItemId;
    private Integer afterSaleOrderItemNumber;
    private String afterSaleHandlePic1;
    private String afterSaleHandleDescription;
    private Integer afterSaleHandleUserId;
    private String afterSaleOrderNumber;
    private Float afterSaleMoney;
    private Integer suggestWooden;
    private Integer sellerId;
    private Integer isRepair;
    private Integer afterSaleNumber;
    private String afterSaleRepairName;
    private Timestamp repairReceiveTime;
    private Integer repairReceiveUserId;
    private String afterSaleRemark;

    @Id
    @GeneratedValue
    @Column(name = "after_sale_id", unique = true, nullable = false)
    public Integer getAfterSaleId() {
        return this.afterSaleId;
    }

    public void setAfterSaleId(Integer afterSaleId) {
        this.afterSaleId = afterSaleId;
    }

    @Column(name = "after_sale_status")
    public Integer getAfterSaleStatus() {
        return this.afterSaleStatus;
    }

    public void setAfterSaleStatus(Integer afterSaleStatus) {
        this.afterSaleStatus = afterSaleStatus;
    }

    @Column(name = "after_sale_user_id")
    public Integer getAfterSaleUserId() {
        return this.afterSaleUserId;
    }

    public void setAfterSaleUserId(Integer afterSaleUserId) {
        this.afterSaleUserId = afterSaleUserId;
    }

    @Column(name = "apply_time", length = 19)
    public Timestamp getApplyTime() {
        return this.applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Column(name = "check_time", length = 19)
    public Timestamp getCheckTime() {
        return this.checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Column(name = "handle_time", length = 19)
    public Timestamp getHandleTime() {
        return this.handleTime;
    }

    public void setHandleTime(Timestamp handleTime) {
        this.handleTime = handleTime;
    }

    @Column(name = "after_sale_pic1", length = 128)
    public String getAfterSalePic1() {
        return this.afterSalePic1;
    }

    public void setAfterSalePic1(String afterSalePic1) {
        this.afterSalePic1 = afterSalePic1;
    }

    @Column(name = "after_sale_pic2", length = 128)
    public String getAfterSalePic2() {
        return this.afterSalePic2;
    }

    public void setAfterSalePic2(String afterSalePic2) {
        this.afterSalePic2 = afterSalePic2;
    }

    @Column(name = "after_sale_pic3", length = 128)
    public String getAfterSalePic3() {
        return this.afterSalePic3;
    }

    public void setAfterSalePic3(String afterSalePic3) {
        this.afterSalePic3 = afterSalePic3;
    }

    @Column(name = "after_sale_description", length = 256)
    public String getAfterSaleDescription() {
        return this.afterSaleDescription;
    }

    public void setAfterSaleDescription(String afterSaleDescription) {
        this.afterSaleDescription = afterSaleDescription;
    }

    @Column(name = "after_sale_order_item_id")
    public Integer getAfterSaleOrderItemId() {
        return this.afterSaleOrderItemId;
    }

    public void setAfterSaleOrderItemId(Integer afterSaleOrderItemId) {
        this.afterSaleOrderItemId = afterSaleOrderItemId;
    }

    @Column(name = "after_sale_order_item_number")
    public Integer getAfterSaleOrderItemNumber() {
        return this.afterSaleOrderItemNumber;
    }

    public void setAfterSaleOrderItemNumber(Integer afterSaleOrderItemNumber) {
        this.afterSaleOrderItemNumber = afterSaleOrderItemNumber;
    }

    @Column(name = "after_sale_handle_pic1", length = 256)
    public String getAfterSaleHandlePic1() {
        return this.afterSaleHandlePic1;
    }

    public void setAfterSaleHandlePic1(String afterSaleHandlePic1) {
        this.afterSaleHandlePic1 = afterSaleHandlePic1;
    }

    @Column(name = "after_sale_handle_description")
    public String getAfterSaleHandleDescription() {
        return this.afterSaleHandleDescription;
    }

    public void setAfterSaleHandleDescription(String afterSaleHandleDescription) {
        this.afterSaleHandleDescription = afterSaleHandleDescription;
    }

    @Column(name = "after_sale_handle_user_id")
    public Integer getAfterSaleHandleUserId() {
        return this.afterSaleHandleUserId;
    }

    public void setAfterSaleHandleUserId(Integer afterSaleHandleUserId) {
        this.afterSaleHandleUserId = afterSaleHandleUserId;
    }

    @Column(name = "after_sale_order_number", length = 64)
    public String getAfterSaleOrderNumber() {
        return this.afterSaleOrderNumber;
    }

    public void setAfterSaleOrderNumber(String afterSaleOrderNumber) {
        this.afterSaleOrderNumber = afterSaleOrderNumber;
    }

    @Column(name = "after_sale_money", precision = 11)
    public Float getAfterSaleMoney() {
        return this.afterSaleMoney;
    }

    public void setAfterSaleMoney(Float afterSaleMoney) {
        this.afterSaleMoney = afterSaleMoney;
    }

    @Column(name = "suggest_wooden")
    public Integer getSuggestWooden() {
        return this.suggestWooden;
    }

    public void setSuggestWooden(Integer suggestWooden) {
        this.suggestWooden = suggestWooden;
    }

    @Column(name = "seller_id")
    public Integer getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Column(name = "is_repair")
    public Integer getIsRepair() {
        return this.isRepair;
    }

    public void setIsRepair(Integer isRepair) {
        this.isRepair = isRepair;
    }

    @Column(name = "after_sale_number")
    public Integer getAfterSaleNumber() {
        return this.afterSaleNumber;
    }

    public void setAfterSaleNumber(Integer afterSaleNumber) {
        this.afterSaleNumber = afterSaleNumber;
    }

    @Column(name = "after_sale_repair_name", length = 128)
    public String getAfterSaleRepairName() {
        return this.afterSaleRepairName;
    }

    public void setAfterSaleRepairName(String afterSaleRepairName) {
        this.afterSaleRepairName = afterSaleRepairName;
    }

    @Column(name = "repair_receive_time", length = 19)
    public Timestamp getRepairReceiveTime() {
        return this.repairReceiveTime;
    }

    public void setRepairReceiveTime(Timestamp repairReceiveTime) {
        this.repairReceiveTime = repairReceiveTime;
    }

    @Column(name = "repair_receive_user_id")
    public Integer getRepairReceiveUserId() {
        return this.repairReceiveUserId;
    }

    public void setRepairReceiveUserId(Integer repairReceiveUserId) {
        this.repairReceiveUserId = repairReceiveUserId;
    }

    @Column(name = "after_sale_remark", length = 256)
    public String getAfterSaleRemark() {
        return this.afterSaleRemark;
    }

    public void setAfterSaleRemark(String afterSaleRemark) {
        this.afterSaleRemark = afterSaleRemark;
    }

}