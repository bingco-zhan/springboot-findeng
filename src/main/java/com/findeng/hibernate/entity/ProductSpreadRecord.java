package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品推广记录
 *
 * @author Alien
 */
@Entity
@Table(name = "product_spread_record")
public class ProductSpreadRecord implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer productSpreadRecordId;
    private Timestamp productSpreadRecordTime;
    private String productSpreadIdList;
    private String productSpreadPic;
    private String productSpreadText;
    private String productSpreadText1;
    private String productSpreadTitle;

    @Id
    @GeneratedValue
    @Column(name = "product_spread_record_id", unique = true, nullable = false)
    public Integer getProductSpreadRecordId() {
        return this.productSpreadRecordId;
    }

    public void setProductSpreadRecordId(Integer productSpreadRecordId) {
        this.productSpreadRecordId = productSpreadRecordId;
    }

    @Column(name = "product_spread_record_time", length = 19)
    public Timestamp getProductSpreadRecordTime() {
        return this.productSpreadRecordTime;
    }

    public void setProductSpreadRecordTime(Timestamp productSpreadRecordTime) {
        this.productSpreadRecordTime = productSpreadRecordTime;
    }

    @Column(name = "product_spread_id_list", length = 256)
    public String getProductSpreadIdList() {
        return this.productSpreadIdList;
    }

    public void setProductSpreadIdList(String productSpreadIdList) {
        this.productSpreadIdList = productSpreadIdList;
    }

    @Column(name = "product_spread_pic", length = 256)
    public String getProductSpreadPic() {
        return this.productSpreadPic;
    }

    public void setProductSpreadPic(String productSpreadPic) {
        this.productSpreadPic = productSpreadPic;
    }

    @Column(name = "product_spread_text", length = 128)
    public String getProductSpreadText() {
        return this.productSpreadText;
    }

    public void setProductSpreadText(String productSpreadText) {
        this.productSpreadText = productSpreadText;
    }

    @Column(name = "product_spread_text1", length = 128)
    public String getProductSpreadText1() {
        return this.productSpreadText1;
    }

    public void setProductSpreadText1(String productSpreadText1) {
        this.productSpreadText1 = productSpreadText1;
    }

    @Column(name = "product_spread_title", length = 256)
    public String getProductSpreadTitle() {
        return this.productSpreadTitle;
    }

    public void setProductSpreadTitle(String productSpreadTitle) {
        this.productSpreadTitle = productSpreadTitle;
    }

}