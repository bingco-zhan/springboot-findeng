package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 客户反馈表
 *
 * @author Alien
 */
@Entity
@Table(name = "freeback")
public class Freeback implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer freebackId;
    private String contactWay;
    private String opinion;
    private Timestamp submitTime;
    private String userNickname;
    private Integer userId;

    @Id
    @GeneratedValue
    @Column(name = "freeback_id", unique = true, nullable = false)
    public Integer getFreebackId() {
        return this.freebackId;
    }

    public void setFreebackId(Integer freebackId) {
        this.freebackId = freebackId;
    }

    @Column(name = "contact_way", nullable = false, length = 32)
    public String getContactWay() {
        return this.contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    @Column(name = "opinion", nullable = false, length = 256)
    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Column(name = "submit_time", length = 19)
    public Timestamp getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    @Column(name = "user_nickname", length = 256)
    public String getUserNickname() {
        return this.userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}