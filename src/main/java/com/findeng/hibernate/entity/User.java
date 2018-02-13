package com.findeng.hibernate.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 用户实体类
 *
 * @author Alien
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "alipay_qr_code")
    private String alipayQrCode;

    @Column(name = "apply_id")
    private Integer applyId;

    @Column(name = "area_id")
    private String areaId;

    @Column(name = "check_status")
    private Integer checkStatus;

    @Column(name = "city_id")
    private String cityId;

    @Column(name = "company_address_detail")
    private String companyAddressDetail;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "email")
    private String email;

    @Column(name = "flow_money")
    private Float flowMoney;

    @Column(name = "follow_time")
    private Timestamp followTime;

    @Column(name = "information_phone")
    private String informationPhone;

    @Column(name = "is_concern")
    private Integer isConcern;

    @Column(name = "lamp_selection_login")
    private Integer lampSelectionLogin;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "legal_person_name")
    private String legalPersonName;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "manage_role")
    private Integer manageRole;

    @Column(name = "new_qr_code")
    private String newQrCode;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "password")
    private String password;

    @Column(name = "pending_money")
    private Float pendingMoney;

    @Column(name = "person_qr_code")
    private String personQrCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "province_id")
    private String provinceId;

    @Column(name = "purchase_money")
    private Float purchaseMoney;

    @Column(name = "qq_number")
    private String qqNumber;

    @Column(name = "qr_code_pic")
    private String qrCodePic;

    @Column(name = "rent_visit_time")
    private Timestamp rentVisitTime;

    @ManyToOne
    @JoinColumn(name = "role")
    private UserRole role;

    @Column(name = "salesman_id")
    private Integer salesmanId;

    @Column(name = "salesman_work_certify")
    private String salesmanWorkCertify;

    @Column(name = "short_company_name")
    private String shortCompanyName;

    @Column(name = "spread_code_generate_time")
    private Timestamp spreadCodeGenerateTime;

    @Column(name = "spread_qr_code_pic")
    private String spreadQrCodePic;

    @Column(name = "union_id")
    private String unionId;

    @Column(name = "upper_user_id")
    private Integer upperUserId;

    @Column(name = "user_identical_code")
    private String userIdenticalCode;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_protrait_pic")
    private String userProtraitPic;

    @Column(name = "user_status")
    private Integer userStatus;

    @Column(name = "we_app_open_id")
    private String weAppOpenId;

    @Column(name = "wechat_number")
    private String wechatNumber;

    @Column(name = "wechat_pay_qr_code")
    private String wechatPayQrCode;

    @Column(name = "welcome_pic")
    private String welcomePic;

    @Column(name = "welcome_title")
    private String welcomeTitle;

    @Column(name = "withdraw_money")
    private Float withdrawMoney;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "wechat_scene")
    private Integer wechatScene;

    @Column(name = "lampPermission_authro_pic")
    private String lampPermissionAuthroPic;

    @Column(name = "lower_count")
    private Integer lowerCount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAlipayQrCode() {
        return alipayQrCode;
    }

    public void setAlipayQrCode(String alipayQrCode) {
        this.alipayQrCode = alipayQrCode;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCompanyAddressDetail() {
        return companyAddressDetail;
    }

    public void setCompanyAddressDetail(String companyAddressDetail) {
        this.companyAddressDetail = companyAddressDetail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getFlowMoney() {
        return flowMoney;
    }

    public void setFlowMoney(Float flowMoney) {
        this.flowMoney = flowMoney;
    }

    public Timestamp getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Timestamp followTime) {
        this.followTime = followTime;
    }

    public String getInformationPhone() {
        return informationPhone;
    }

    public void setInformationPhone(String informationPhone) {
        this.informationPhone = informationPhone;
    }

    public Integer getIsConcern() {
        return isConcern;
    }

    public void setIsConcern(Integer isConcern) {
        this.isConcern = isConcern;
    }

    public Integer getLampSelectionLogin() {
        return lampSelectionLogin;
    }

    public void setLampSelectionLogin(Integer lampSelectionLogin) {
        this.lampSelectionLogin = lampSelectionLogin;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getManageRole() {
        return manageRole;
    }

    public void setManageRole(Integer manageRole) {
        this.manageRole = manageRole;
    }

    public String getNewQrCode() {
        return newQrCode;
    }

    public void setNewQrCode(String newQrCode) {
        this.newQrCode = newQrCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getPendingMoney() {
        return pendingMoney;
    }

    public void setPendingMoney(Float pendingMoney) {
        this.pendingMoney = pendingMoney;
    }

    public String getPersonQrCode() {
        return personQrCode;
    }

    public void setPersonQrCode(String personQrCode) {
        this.personQrCode = personQrCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public Float getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(Float purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getQrCodePic() {
        return qrCodePic;
    }

    public void setQrCodePic(String qrCodePic) {
        this.qrCodePic = qrCodePic;
    }

    public Timestamp getRentVisitTime() {
        return rentVisitTime;
    }

    public void setRentVisitTime(Timestamp rentVisitTime) {
        this.rentVisitTime = rentVisitTime;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Integer getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Integer salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSalesmanWorkCertify() {
        return salesmanWorkCertify;
    }

    public void setSalesmanWorkCertify(String salesmanWorkCertify) {
        this.salesmanWorkCertify = salesmanWorkCertify;
    }

    public String getShortCompanyName() {
        return shortCompanyName;
    }

    public void setShortCompanyName(String shortCompanyName) {
        this.shortCompanyName = shortCompanyName;
    }

    public Timestamp getSpreadCodeGenerateTime() {
        return spreadCodeGenerateTime;
    }

    public void setSpreadCodeGenerateTime(Timestamp spreadCodeGenerateTime) {
        this.spreadCodeGenerateTime = spreadCodeGenerateTime;
    }

    public String getSpreadQrCodePic() {
        return spreadQrCodePic;
    }

    public void setSpreadQrCodePic(String spreadQrCodePic) {
        this.spreadQrCodePic = spreadQrCodePic;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getUpperUserId() {
        return upperUserId;
    }

    public void setUpperUserId(Integer upperUserId) {
        this.upperUserId = upperUserId;
    }

    public String getUserIdenticalCode() {
        return userIdenticalCode;
    }

    public void setUserIdenticalCode(String userIdenticalCode) {
        this.userIdenticalCode = userIdenticalCode;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserProtraitPic() {
        return userProtraitPic;
    }

    public void setUserProtraitPic(String userProtraitPic) {
        this.userProtraitPic = userProtraitPic;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getWeAppOpenId() {
        return weAppOpenId;
    }

    public void setWeAppOpenId(String weAppOpenId) {
        this.weAppOpenId = weAppOpenId;
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public String getWechatPayQrCode() {
        return wechatPayQrCode;
    }

    public void setWechatPayQrCode(String wechatPayQrCode) {
        this.wechatPayQrCode = wechatPayQrCode;
    }

    public String getWelcomePic() {
        return welcomePic;
    }

    public void setWelcomePic(String welcomePic) {
        this.welcomePic = welcomePic;
    }

    public String getWelcomeTitle() {
        return welcomeTitle;
    }

    public void setWelcomeTitle(String welcomeTitle) {
        this.welcomeTitle = welcomeTitle;
    }

    public Float getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(Float withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getWechatScene() {
        return wechatScene;
    }

    public void setWechatScene(Integer wechatScene) {
        this.wechatScene = wechatScene;
    }

    public String getLampPermissionAuthroPic() {
        return lampPermissionAuthroPic;
    }

    public void setLampPermissionAuthroPic(String lampPermissionAuthroPic) {
        this.lampPermissionAuthroPic = lampPermissionAuthroPic;
    }

    public Integer getLowerCount() {
        return lowerCount;
    }

    public void setLowerCount(Integer lowerCount) {
        this.lowerCount = lowerCount;
    }

}