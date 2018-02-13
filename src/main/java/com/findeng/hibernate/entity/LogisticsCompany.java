package com.findeng.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 物流公司表
 *
 * @author Alien
 */
@Entity
@Table(name = "logistics_company")
public class LogisticsCompany implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String logisticsCompanyCode;
    private String logisticsCompanyName;
    private String logisticsFirstChar;
    private String logisticsPhoneNumber;
    private String logisticsWebsite;

    // Constructors

    /**
     * default constructor
     */
    public LogisticsCompany() {
    }

    /**
     * full constructor
     */
    public LogisticsCompany(String logisticsCompanyName,
                            String logisticsFirstChar, String logisticsPhoneNumber,
                            String logisticsWebsite) {
        this.logisticsCompanyName = logisticsCompanyName;
        this.logisticsFirstChar = logisticsFirstChar;
        this.logisticsPhoneNumber = logisticsPhoneNumber;
        this.logisticsWebsite = logisticsWebsite;
    }

    // Property accessors
    @Id
    @GeneratedValue
    @Column(name = "logistics_company_code", unique = true, nullable = false, length = 64)
    public String getLogisticsCompanyCode() {
        return this.logisticsCompanyCode;
    }

    public void setLogisticsCompanyCode(String logisticsCompanyCode) {
        this.logisticsCompanyCode = logisticsCompanyCode;
    }

    @Column(name = "logistics_company_name", length = 32)
    public String getLogisticsCompanyName() {
        return this.logisticsCompanyName;
    }

    public void setLogisticsCompanyName(String logisticsCompanyName) {
        this.logisticsCompanyName = logisticsCompanyName;
    }

    @Column(name = "logistics_first_char", length = 2)
    public String getLogisticsFirstChar() {
        return this.logisticsFirstChar;
    }

    public void setLogisticsFirstChar(String logisticsFirstChar) {
        this.logisticsFirstChar = logisticsFirstChar;
    }

    @Column(name = "logistics_phone_number", length = 64)
    public String getLogisticsPhoneNumber() {
        return this.logisticsPhoneNumber;
    }

    public void setLogisticsPhoneNumber(String logisticsPhoneNumber) {
        this.logisticsPhoneNumber = logisticsPhoneNumber;
    }

    @Column(name = "logistics_website", length = 256)
    public String getLogisticsWebsite() {
        return this.logisticsWebsite;
    }

    public void setLogisticsWebsite(String logisticsWebsite) {
        this.logisticsWebsite = logisticsWebsite;
    }

}