package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 解绑申请表
 *
 * @author Alien
 */
@Entity
@Table(name = "unbunding")
public class Unbunding implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer unbundingId;
    private Integer unbundingUserId;
    private String unbundingReason;
    private Integer unbundingUpUserId;
    private Timestamp unbundingApplyTime;
    private Timestamp unbundingHandleTime;
    private Integer unbundingStatus;

    @Id
    @GeneratedValue
    @Column(name = "unbunding_id", unique = true, nullable = false)
    public Integer getUnbundingId() {
        return this.unbundingId;
    }

    public void setUnbundingId(Integer unbundingId) {
        this.unbundingId = unbundingId;
    }

    @Column(name = "unbunding_user_id")
    public Integer getUnbundingUserId() {
        return this.unbundingUserId;
    }

    public void setUnbundingUserId(Integer unbundingUserId) {
        this.unbundingUserId = unbundingUserId;
    }

    @Column(name = "unbunding_reason", length = 256)
    public String getUnbundingReason() {
        return this.unbundingReason;
    }

    public void setUnbundingReason(String unbundingReason) {
        this.unbundingReason = unbundingReason;
    }

    @Column(name = "unbunding_up_user_id")
    public Integer getUnbundingUpUserId() {
        return this.unbundingUpUserId;
    }

    public void setUnbundingUpUserId(Integer unbundingUpUserId) {
        this.unbundingUpUserId = unbundingUpUserId;
    }

    @Column(name = "unbunding_apply_time", length = 19)
    public Timestamp getUnbundingApplyTime() {
        return this.unbundingApplyTime;
    }

    public void setUnbundingApplyTime(Timestamp unbundingApplyTime) {
        this.unbundingApplyTime = unbundingApplyTime;
    }

    @Column(name = "unbunding_handle_time", length = 19)
    public Timestamp getUnbundingHandleTime() {
        return this.unbundingHandleTime;
    }

    public void setUnbundingHandleTime(Timestamp unbundingHandleTime) {
        this.unbundingHandleTime = unbundingHandleTime;
    }

    @Column(name = "unbunding_status")
    public Integer getUnbundingStatus() {
        return this.unbundingStatus;
    }

    public void setUnbundingStatus(Integer unbundingStatus) {
        this.unbundingStatus = unbundingStatus;
    }

}