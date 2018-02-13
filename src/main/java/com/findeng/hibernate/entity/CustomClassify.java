package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 配灯系统产品自定义分类
 *
 * @author Alien
 */
@Entity
@Table(name = "custom_classify")
public class CustomClassify implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer customClassifyId;
    private String customClassifyName;
    private Integer userId;
    private Integer deleteFlag;
    private Integer haveProduct;

    @Id
    @GeneratedValue
    @Column(name = "custom_classify_id", unique = true, nullable = false)
    public Integer getCustomClassifyId() {
        return this.customClassifyId;
    }

    public void setCustomClassifyId(Integer customClassifyId) {
        this.customClassifyId = customClassifyId;
    }

    @Column(name = "custom_classify_name", length = 256)
    public String getCustomClassifyName() {
        return this.customClassifyName;
    }

    public void setCustomClassifyName(String customClassifyName) {
        this.customClassifyName = customClassifyName;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "delete_flag")
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Column(name = "have_product")
    public Integer getHaveProduct() {
        return this.haveProduct;
    }

    public void setHaveProduct(Integer haveProduct) {
        this.haveProduct = haveProduct;
    }

}