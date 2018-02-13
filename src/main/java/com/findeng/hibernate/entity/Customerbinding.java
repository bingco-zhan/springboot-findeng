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
 * 客戶綁定申請表
 *
 * @author bingco
 */
@Entity
@Table(name = "customer_binding")
public class Customerbinding {

    /**
     * 未审核
     */
    public static final Integer STATUS_0 = 0;

    /**
     * 审核失败
     */
    public static final Integer STATUS_1 = 1;

    /**
     * 审核成功
     */
    public static final Integer STATUS_2 = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; // '主键',

    @ManyToOne
    @JoinColumn(name = "apply_id")
    private User apply; // '申请人ID 对应 user表ID',

    @ManyToOne
    @JoinColumn(name = "unbundling_id")
    private User unbundling; // '解绑ID 对应 user表ID',

    @Column(name = "status")
    private Integer status; // '状态 0未审核 1审核失败 2审核成功',

    @Column(name = "create_time")
    private Timestamp createTime; // '创建时间',

    @Column(name = "end_time")
    private Timestamp endTime; // '结束时间',

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getApply() {
        return apply;
    }

    public void setApply(User apply) {
        this.apply = apply;
    }

    public User getUnbundling() {
        return unbundling;
    }

    public void setUnbundling(User unbundling) {
        this.unbundling = unbundling;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

}
