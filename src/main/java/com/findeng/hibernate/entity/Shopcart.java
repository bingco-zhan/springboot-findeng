package com.findeng.hibernate.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 购物车表
 *
 * @author Alien
 */
@Entity
@Table(name = "shopcart")
public class Shopcart implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer shopcartId;
    private Integer sellerId;
    private Integer buyerId;
    private Integer buyImmediately;
    private Integer deleteFlag;
    private List<ShopcartItem> shopcartItems;

    @Id
    @GeneratedValue
    @Column(name = "shopcart_id", unique = true, nullable = false)
    public Integer getShopcartId() {
        return this.shopcartId;
    }

    public void setShopcartId(Integer shopcartId) {
        this.shopcartId = shopcartId;
    }

    @Column(name = "seller_id")
    public Integer getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Column(name = "buyer_id")
    public Integer getBuyerId() {
        return this.buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @Column(name = "buy_immediately")
    public Integer getBuyImmediately() {
        return this.buyImmediately;
    }

    public void setBuyImmediately(Integer buyImmediately) {
        this.buyImmediately = buyImmediately;
    }

    @Column(name = "delete_flag")
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @JoinColumn(name = "shopcart_id")
    @Where(clause = "delete_flag = 0")
    @OneToMany(fetch = FetchType.EAGER)
    public List<ShopcartItem> getShopcartItems() {
        return shopcartItems;
    }

    public void setShopcartItems(List<ShopcartItem> shopcartItems) {
        this.shopcartItems = shopcartItems;
    }
}