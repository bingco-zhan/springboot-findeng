package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 认证信息表
 *
 * @author Alien
 */
@Entity
@Table(name = "certification_application")
public class CertificationApplication implements java.io.Serializable {
    /**
     * 待审核
     */
    public static Integer STATE_1 = 1;
    /**
     * 审核失败
     */
    public static Integer STATE_2 = 2;
    /**
     * 审批通过
     */
    public static Integer STATE_3 = 3;

    private static final long serialVersionUID = 1L;
    private Integer applyId;
    private Integer userId;
    private String companyName;
    private String legalPerson;
    private String lpIdcardFrontPic;
    private String lpIdcardBackPic;
    private String lpHandheldIdcardPic;
    private String businessLicenceNumber;
    private String businessLicencePic;
    private String contact;
    private String logoPic;
    private Timestamp submitTime;
    private Timestamp checkTime;
    private Integer checkStatus;
    private String provinceId;
    private String cityId;
    private String areaId;
    private String companyAddressDetail;
    private String salesmanWorkCertify;
    private String jcv;
    private String shortCompanyName;
    private UserRole role;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "apply_id", unique = true, nullable = false)
    public Integer getApplyId() {
        return this.applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "company_name", length = 64)
    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "legal_person", length = 64)
    public String getLegalPerson() {
        return this.legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    @Column(name = "lp_idcard_front_pic", length = 256)
    public String getLpIdcardFrontPic() {
        return this.lpIdcardFrontPic;
    }

    public void setLpIdcardFrontPic(String lpIdcardFrontPic) {
        this.lpIdcardFrontPic = lpIdcardFrontPic;
    }

    @Column(name = "lp_idcard_back_pic", length = 256)
    public String getLpIdcardBackPic() {
        return this.lpIdcardBackPic;
    }

    public void setLpIdcardBackPic(String lpIdcardBackPic) {
        this.lpIdcardBackPic = lpIdcardBackPic;
    }

    @Column(name = "lp_handheld_idcard_pic", length = 256)
    public String getLpHandheldIdcardPic() {
        return this.lpHandheldIdcardPic;
    }

    public void setLpHandheldIdcardPic(String lpHandheldIdcardPic) {
        this.lpHandheldIdcardPic = lpHandheldIdcardPic;
    }

    @Column(name = "business_licence_number", length = 128)
    public String getBusinessLicenceNumber() {
        return this.businessLicenceNumber;
    }

    public void setBusinessLicenceNumber(String businessLicenceNumber) {
        this.businessLicenceNumber = businessLicenceNumber;
    }

    @Column(name = "business_licence_pic", length = 256)
    public String getBusinessLicencePic() {
        return this.businessLicencePic;
    }

    public void setBusinessLicencePic(String businessLicencePic) {
        this.businessLicencePic = businessLicencePic;
    }

    @Column(name = "contact", length = 128)
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "logo_pic", length = 256)
    public String getLogoPic() {
        return this.logoPic;
    }

    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    @Column(name = "submit_time", length = 19)
    public Timestamp getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    @Column(name = "check_time", length = 19)
    public Timestamp getCheckTime() {
        return this.checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Column(name = "check_status")
    public Integer getCheckStatus() {
        return this.checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Column(name = "province_id", length = 32)
    public String getProvinceId() {
        return this.provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    @Column(name = "city_id", length = 32)
    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Column(name = "area_id", length = 32)
    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Column(name = "company_address_detail", length = 256)
    public String getCompanyAddressDetail() {
        return this.companyAddressDetail;
    }

    public void setCompanyAddressDetail(String companyAddressDetail) {
        this.companyAddressDetail = companyAddressDetail;
    }

    @Column(name = "salesman_work_certify", length = 256)
    public String getSalesmanWorkCertify() {
        return this.salesmanWorkCertify;
    }

    public void setSalesmanWorkCertify(String salesmanWorkCertify) {
        this.salesmanWorkCertify = salesmanWorkCertify;
    }

    @Column(name = "jcv", length = 256)
    public String getJcv() {
        return this.jcv;
    }

    public void setJcv(String jcv) {
        this.jcv = jcv;
    }

    @Column(name = "short_company_name", length = 64)
    public String getShortCompanyName() {
        return this.shortCompanyName;
    }

    public void setShortCompanyName(String shortCompanyName) {
        this.shortCompanyName = shortCompanyName;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}