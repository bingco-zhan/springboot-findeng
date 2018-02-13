package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 购物车订单项
 *
 * @author Alien
 */
@Entity
@Table(name = "shopcart_item")
public class ShopcartItem implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer itemId;
    private Timestamp addtime;
    private Integer productNumber;
    private Integer productId;
    private Integer shopcartId;
    private Integer deleteFlag;

    @Id
    @GeneratedValue
    @Column(name = "item_id", unique = true, nullable = false)
    public Integer getItemId() {
        return this.itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Column(name = "addtime", nullable = false, length = 19)
    public Timestamp getAddtime() {
        return this.addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    @Column(name = "product_number")
    public Integer getProductNumber() {
        return this.productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    @Column(name = "product_id")
    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name = "shopcart_id")
    public Integer getShopcartId() {
        return this.shopcartId;
    }

    public void setShopcartId(Integer shopcartId) {
        this.shopcartId = shopcartId;
    }

    @Column(name = "delete_flag")
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}