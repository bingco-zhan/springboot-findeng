package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品栏目表
 *
 * @author Alien
 */
@Entity
@Table(name = "product_column")
public class ProductColumn implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer productColumnId;
    private String productColumnName;
    private Integer productColumnIndex;
    private Integer productColumnDeleteFlag;
    private Integer productColumnType;
    private String productColumnProperty;
    private String productColumnPropertyValue;
    private String productColumnPic;
    private Integer productStyleType;
    private String productColumnUrl;
    private String productColumnTitle;

    @Id
    @GeneratedValue
    @Column(name = "product_column_id", unique = true, nullable = false)
    public Integer getProductColumnId() {
        return this.productColumnId;
    }

    public void setProductColumnId(Integer productColumnId) {
        this.productColumnId = productColumnId;
    }

    @Column(name = "product_column_name", length = 256)
    public String getProductColumnName() {
        return this.productColumnName;
    }

    public void setProductColumnName(String productColumnName) {
        this.productColumnName = productColumnName;
    }

    @Column(name = "product_column_index")
    public Integer getProductColumnIndex() {
        return this.productColumnIndex;
    }

    public void setProductColumnIndex(Integer productColumnIndex) {
        this.productColumnIndex = productColumnIndex;
    }

    @Column(name = "product_column_delete_flag")
    public Integer getProductColumnDeleteFlag() {
        return this.productColumnDeleteFlag;
    }

    public void setProductColumnDeleteFlag(Integer productColumnDeleteFlag) {
        this.productColumnDeleteFlag = productColumnDeleteFlag;
    }

    @Column(name = "product_column_type")
    public Integer getProductColumnType() {
        return this.productColumnType;
    }

    public void setProductColumnType(Integer productColumnType) {
        this.productColumnType = productColumnType;
    }

    @Column(name = "product_column_property", length = 128)
    public String getProductColumnProperty() {
        return this.productColumnProperty;
    }

    public void setProductColumnProperty(String productColumnProperty) {
        this.productColumnProperty = productColumnProperty;
    }

    @Column(name = "product_column_property_value")
    public String getProductColumnPropertyValue() {
        return this.productColumnPropertyValue;
    }

    public void setProductColumnPropertyValue(String productColumnPropertyValue) {
        this.productColumnPropertyValue = productColumnPropertyValue;
    }

    @Column(name = "product_column_pic")
    public String getProductColumnPic() {
        return this.productColumnPic;
    }

    public void setProductColumnPic(String productColumnPic) {
        this.productColumnPic = productColumnPic;
    }

    @Column(name = "product_style_type")
    public Integer getProductStyleType() {
        return this.productStyleType;
    }

    public void setProductStyleType(Integer productStyleType) {
        this.productStyleType = productStyleType;
    }

    @Column(name = "product_column_url")
    public String getProductColumnUrl() {
        return this.productColumnUrl;
    }

    public void setProductColumnUrl(String productColumnUrl) {
        this.productColumnUrl = productColumnUrl;
    }

    @Column(name = "product_column_title", length = 256)
    public String getProductColumnTitle() {
        return this.productColumnTitle;
    }

    public void setProductColumnTitle(String productColumnTitle) {
        this.productColumnTitle = productColumnTitle;
    }

}