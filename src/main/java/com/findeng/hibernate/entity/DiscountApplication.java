package com.findeng.hibernate.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 折扣申请表
 *
 * @author Alien
 */
@Entity
@Table(name = "discount_application")
public class DiscountApplication implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private User user;
    private String title;
    private Timestamp creatTime;
    private Integer status;
    private Timestamp checkTime;
    private String welcomeTitle;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "creat_time")
    public Timestamp getCreatTime() {
        return this.creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "check_time")
    public Timestamp getCheckTime() {
        return this.checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Column(name = "welcome_title")
    public String getWelcomeTitle() {
        return this.welcomeTitle;
    }

    public void setWelcomeTitle(String welcomeTitle) {
        this.welcomeTitle = welcomeTitle;
    }

}