package com.findeng.hibernate.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "favorite", catalog = "findeng")
public class Favorite implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 未回复状态
     */
    public static int STATUS_0 = 0;

    /**
     * 已回复状态
     */
    public static int STATUS_1 = 1;

    /**
     * 无货
     */
    public static int HAS_FLAG_0 = 0;

    /**
     * 有货
     */
    public static int HAS_FLAG_1 = 1;

    /**
     * 线程未发送消息
     */
    public static int TASK_SEND_MSG_FLAG_0 = 0;

    /**
     * 线程已发送消息
     */
    public static int TASK_SEND_MSG_FLAG_1 = 1;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Integer Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "status")
    private Integer status;

    @Column(name = "has_flag")
    private Integer hasFlag;

    @Column(name = "user_demand")
    private Integer useDemand;

    @Column(name = "delivery_day")
    private Integer deliveryDay;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "task_send_msg_flag")
    private Integer taskSendMsgFlag;

    // Constructors

    /**
     * default constructor
     */
    public Favorite() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHasFlag() {
        return hasFlag;
    }

    public void setHasFlag(Integer hasFlag) {
        this.hasFlag = hasFlag;
    }

    public Integer getUseDemand() {
        return useDemand;
    }

    public void setUseDemand(Integer useDemand) {
        this.useDemand = useDemand;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(Integer deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public Integer getTaskSendMsgFlag() {
        return taskSendMsgFlag;
    }

    public void setTaskSendMsgFlag(Integer taskSendMsgFlag) {
        this.taskSendMsgFlag = taskSendMsgFlag;
    }

}