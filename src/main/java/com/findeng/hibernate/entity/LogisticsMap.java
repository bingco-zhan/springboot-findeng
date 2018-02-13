package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 物流园映射表，记录物流公司对应物流园
 *
 * @author Alien
 */
@Entity
@Table(name = "logistics_map")
public class LogisticsMap implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Fields

    private Integer logisticsMapId;
    private String logisticsCompany;
    private String logisticsPark;

    // Constructors

    /**
     * default constructor
     */
    public LogisticsMap() {
    }

    /**
     * full constructor
     */
    public LogisticsMap(String logisticsCompany, String logisticsPark) {
        this.logisticsCompany = logisticsCompany;
        this.logisticsPark = logisticsPark;
    }

    // Property accessors
    @Id
    @GeneratedValue
    @Column(name = "logistics_map_id", unique = true, nullable = false)
    public Integer getLogisticsMapId() {
        return this.logisticsMapId;
    }

    public void setLogisticsMapId(Integer logisticsMapId) {
        this.logisticsMapId = logisticsMapId;
    }

    @Column(name = "logistics_company", length = 256)
    public String getLogisticsCompany() {
        return this.logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    @Column(name = "logistics_park", length = 256)
    public String getLogisticsPark() {
        return this.logisticsPark;
    }

    public void setLogisticsPark(String logisticsPark) {
        this.logisticsPark = logisticsPark;
    }

}