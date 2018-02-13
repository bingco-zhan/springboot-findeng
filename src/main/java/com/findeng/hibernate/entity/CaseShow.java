package com.findeng.hibernate.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 配灯系统案例展示
 */
@Entity
@Table(name = "case_show")
public class CaseShow implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer caseShowId;
    private String caseShowDescription;
    private String caseShowPic;
    private Integer caseShowStatus;
    private Integer userId;
    private Timestamp createTime;

    @Id
    @GeneratedValue
    @Column(name = "case_show_id", unique = true, nullable = false)
    public Integer getCaseShowId() {
        return this.caseShowId;
    }

    public void setCaseShowId(Integer caseShowId) {
        this.caseShowId = caseShowId;
    }

    @Column(name = "case_show_description")
    public String getCaseShowDescription() {
        return this.caseShowDescription;
    }

    public void setCaseShowDescription(String caseShowDescription) {
        this.caseShowDescription = caseShowDescription;
    }

    @Column(name = "case_show_pic", length = 256)
    public String getCaseShowPic() {
        return this.caseShowPic;
    }

    public void setCaseShowPic(String caseShowPic) {
        this.caseShowPic = caseShowPic;
    }

    @Column(name = "case_show_status")
    public Integer getCaseShowStatus() {
        return this.caseShowStatus;
    }

    public void setCaseShowStatus(Integer caseShowStatus) {
        this.caseShowStatus = caseShowStatus;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}