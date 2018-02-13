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
import javax.persistence.Transient;

/**
 * 产品信息表，所有产品属性保存在这里
 *
 * @author Alien
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    /**
     * 待审核
     */
    public static Integer STATE_2 = 2;
    /**
     * 上线中
     */
    public static Integer STATE_5 = 5;
    /**
     * 已下架
     */
    public static Integer STATE_6 = 6;
    /**
     * 已删除
     */
    public static Integer STATE_7 = 7;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "check_time")
    private Timestamp checkTime;

    @Column(name = "cost_price")
    private Float costPrice;

    @Column(name = "cover")
    private String cover;

    @Column(name = "creat_time")
    private Timestamp creatTime;

    @Column(name = "delivery_time")
    private Integer deliveryTime;

    @Column(name = "description_pic")
    private String descriptionPic;

    @Column(name = "freight")
    private Float freight;

    @Column(name = "has_light_source")
    private Integer hasLightSource;

    @Column(name = "is_popular")
    private Integer isPopular;

    @Column(name = "is_spread_product")
    private Integer isSpreadProduct;

    @Column(name = "light_number")
    private String lightNumber;

    @Column(name = "light_type")
    private Integer lightType;

    @Transient
    private String light_Type;

    @Column(name = "offline_time")
    private Timestamp offlineTime;

    @Column(name = "online_time")
    private Timestamp onlineTime;

    @Column(name = "origin_unit_price")
    private Float originUnitPrice;

    @Column(name = "package_height")
    private Float packageHeight;

    @Column(name = "package_length")
    private Float packageLength;

    @Column(name = "package_weight")
    private Float packageWeight;

    @Column(name = "package_width")
    private Float packageWidth;

    @Column(name = "platform_percent")
    private Float platformPercent;

    @Column(name = "product_alias_name")
    private String productAliasName;

    @Column(name = "product_box_number")
    private Integer productBoxNumber;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_color")
    private String productColor;

    @Column(name = "product_diameter")
    private Float productDiameter;

    @Column(name = "product_head_type")
    private Integer productHeadType;

    @Column(name = "product_height")
    private Float productHeight;

    @Column(name = "product_fromthewall")
    private Float productFromthewall;

    @Column(name = "product_index")
    private Integer productIndex;

    @Column(name = "product_kind")
    private Integer productKind;

    @Column(name = "product_length")
    private Float productLength;

    @Column(name = "product_material")
    private String productMaterial;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_plies")
    private Integer productPlies;

    @Column(name = "product_png_pic")
    private String productPngPic;

    @Column(name = "product_power")
    private String productPower;

    @Column(name = "product_qr_code_pic")
    private String productQrCodePic;

    @Column(name = "product_report_pic")
    private String productReportPic;

    @Column(name = "product_sales")
    private Integer productSales;

    @ManyToOne
    @JoinColumn(name = "product_series_id")
    private ProductSeries productSeries;

    @Column(name = "product_shape")
    private Integer productShape;

    @Column(name = "product_space")
    private String productSpace;

    @Column(name = "product_spread_pic")
    private String productSpreadPic;

    @Column(name = "product_status")
    private Integer productStatus;

    @Column(name = "product_stock")
    private Integer productStock;

    @Column(name = "product_style")
    private String productStyle;

    @Column(name = "product_tag")
    private String productTag;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "product_visit_count")
    private Integer productVisitCount;

    @Column(name = "product_weight")
    private Float productWeight;

    @Column(name = "product_width")
    private Float productWidth;

    @Column(name = "quality_guarantee_time")
    private String qualityGuaranteeTime;

    @Column(name = "retail_price")
    private Float retailPrice;

    @Column(name = "series_head")
    private Integer seriesHead;

    @Column(name = "series_index")
    private Integer seriesIndex;

    @Column(name = "spread_percent")
    private Float spreadPercent;

    @Column(name = "suggest_wooden")
    private Integer suggestWooden;

    @Column(name = "three_c_certification")
    private String threeCCertification;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "wooden_fee")
    private Float woodenFee;

    @Column(name = "light_color")
    private String lightColor;

    public Product() {
    }

    public Product(Integer productId, String productColor, String lightColor, String productName) {
        this.productId = productId;
        this.productColor = productColor;
        this.productName = productName;
        this.lightColor = lightColor;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Timestamp getCheckTime() {
        return this.checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public Float getCostPrice() {
        return this.costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Timestamp getCreatTime() {
        return this.creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDescriptionPic() {
        return this.descriptionPic;
    }

    public void setDescriptionPic(String descriptionPic) {
        this.descriptionPic = descriptionPic;
    }

    public Float getFreight() {
        return this.freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public Integer getHasLightSource() {
        return this.hasLightSource;
    }

    public void setHasLightSource(Integer hasLightSource) {
        this.hasLightSource = hasLightSource;
    }

    public Integer getIsPopular() {
        return this.isPopular;
    }

    public void setIsPopular(Integer isPopular) {
        this.isPopular = isPopular;
    }

    public Integer getIsSpreadProduct() {
        return this.isSpreadProduct;
    }

    public void setIsSpreadProduct(Integer isSpreadProduct) {
        this.isSpreadProduct = isSpreadProduct;
    }

    public String getLightNumber() {
        return this.lightNumber;
    }

    public void setLightNumber(String lightNumber) {
        this.lightNumber = lightNumber;
    }

    public Integer getLightType() {
        return this.lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public String getLight_Type() {
        return light_Type;
    }

    public void setLight_Type(String light_Type) {
        this.light_Type = light_Type;
    }

    public Timestamp getOfflineTime() {
        return this.offlineTime;
    }

    public void setOfflineTime(Timestamp offlineTime) {
        this.offlineTime = offlineTime;
    }

    public Timestamp getOnlineTime() {
        return this.onlineTime;
    }

    public void setOnlineTime(Timestamp onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Float getOriginUnitPrice() {
        return this.originUnitPrice;
    }

    public void setOriginUnitPrice(Float originUnitPrice) {
        this.originUnitPrice = originUnitPrice;
    }

    public Float getPackageHeight() {
        return this.packageHeight;
    }

    public void setPackageHeight(Float packageHeight) {
        this.packageHeight = packageHeight;
    }

    public Float getPackageLength() {
        return this.packageLength;
    }

    public void setPackageLength(Float packageLength) {
        this.packageLength = packageLength;
    }

    public Float getPackageWeight() {
        return this.packageWeight;
    }

    public void setPackageWeight(Float packageWeight) {
        this.packageWeight = packageWeight;
    }

    public Float getPackageWidth() {
        return this.packageWidth;
    }

    public void setPackageWidth(Float packageWidth) {
        this.packageWidth = packageWidth;
    }

    public Float getPlatformPercent() {
        return this.platformPercent;
    }

    public void setPlatformPercent(Float platformPercent) {
        this.platformPercent = platformPercent;
    }

    public String getProductAliasName() {
        return this.productAliasName;
    }

    public void setProductAliasName(String productAliasName) {
        this.productAliasName = productAliasName;
    }

    public Integer getProductBoxNumber() {
        return this.productBoxNumber;
    }

    public void setProductBoxNumber(Integer productBoxNumber) {
        this.productBoxNumber = productBoxNumber;
    }

    public String getProductBrand() {
        return this.productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductColor() {
        return this.productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Float getProductDiameter() {
        return this.productDiameter;
    }

    public void setProductDiameter(Float productDiameter) {
        this.productDiameter = productDiameter;
    }

    public Integer getProductHeadType() {
        return this.productHeadType;
    }

    public void setProductHeadType(Integer productHeadType) {
        this.productHeadType = productHeadType;
    }

    public Float getProductHeight() {
        return this.productHeight;
    }

    public void setProductHeight(Float productHeight) {
        this.productHeight = productHeight;
    }

    public Integer getProductIndex() {
        return this.productIndex;
    }

    public void setProductIndex(Integer productIndex) {
        this.productIndex = productIndex;
    }

    public Integer getProductKind() {
        return this.productKind;
    }

    public void setProductKind(Integer productKind) {
        this.productKind = productKind;
    }

    public Float getProductLength() {
        return this.productLength;
    }

    public void setProductLength(Float productLength) {
        this.productLength = productLength;
    }

    public String getProductMaterial() {
        return this.productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPlies() {
        return this.productPlies;
    }

    public void setProductPlies(Integer productPlies) {
        this.productPlies = productPlies;
    }

    public String getProductPngPic() {
        return this.productPngPic;
    }

    public void setProductPngPic(String productPngPic) {
        this.productPngPic = productPngPic;
    }

    public String getProductPower() {
        return this.productPower;
    }

    public void setProductPower(String productPower) {
        this.productPower = productPower;
    }

    public String getProductQrCodePic() {
        return this.productQrCodePic;
    }

    public void setProductQrCodePic(String productQrCodePic) {
        this.productQrCodePic = productQrCodePic;
    }

    public String getProductReportPic() {
        return this.productReportPic;
    }

    public void setProductReportPic(String productReportPic) {
        this.productReportPic = productReportPic;
    }

    public Integer getProductSales() {
        return this.productSales;
    }

    public void setProductSales(Integer productSales) {
        this.productSales = productSales;
    }

    public ProductSeries getProductSeries() {
        return this.productSeries;
    }

    public void setProductSeries(ProductSeries productSeries) {
        this.productSeries = productSeries;
    }

    public Integer getProductShape() {
        return this.productShape;
    }

    public void setProductShape(Integer productShape) {
        this.productShape = productShape;
    }

    public String getProductSpace() {
        return this.productSpace;
    }

    public void setProductSpace(String productSpace) {
        this.productSpace = productSpace;
    }

    public String getProductSpreadPic() {
        return this.productSpreadPic;
    }

    public void setProductSpreadPic(String productSpreadPic) {
        this.productSpreadPic = productSpreadPic;
    }

    public Integer getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductStock() {
        return this.productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductStyle() {
        return this.productStyle;
    }

    public void setProductStyle(String productStyle) {
        this.productStyle = productStyle;
    }

    public String getProductTag() {
        return this.productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductVisitCount() {
        return this.productVisitCount;
    }

    public void setProductVisitCount(Integer productVisitCount) {
        this.productVisitCount = productVisitCount;
    }

    public Float getProductWeight() {
        return this.productWeight;
    }

    public void setProductWeight(Float productWeight) {
        this.productWeight = productWeight;
    }

    public Float getProductWidth() {
        return this.productWidth;
    }

    public void setProductWidth(Float productWidth) {
        this.productWidth = productWidth;
    }

    public String getQualityGuaranteeTime() {
        return this.qualityGuaranteeTime;
    }

    public void setQualityGuaranteeTime(String qualityGuaranteeTime) {
        this.qualityGuaranteeTime = qualityGuaranteeTime;
    }

    public Float getRetailPrice() {
        return this.retailPrice;
    }

    public void setRetailPrice(Float retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getSeriesHead() {
        return this.seriesHead;
    }

    public void setSeriesHead(Integer seriesHead) {
        this.seriesHead = seriesHead;
    }

    public Integer getSeriesIndex() {
        return this.seriesIndex;
    }

    public void setSeriesIndex(Integer seriesIndex) {
        this.seriesIndex = seriesIndex;
    }

    public Float getSpreadPercent() {
        return this.spreadPercent;
    }

    public void setSpreadPercent(Float spreadPercent) {
        this.spreadPercent = spreadPercent;
    }

    public Integer getSuggestWooden() {
        return this.suggestWooden;
    }

    public void setSuggestWooden(Integer suggestWooden) {
        this.suggestWooden = suggestWooden;
    }

    public String getThreeCCertification() {
        return this.threeCCertification;
    }

    public void setThreeCCertification(String threeCCertification) {
        this.threeCCertification = threeCCertification;
    }

    public Float getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getWoodenFee() {
        return this.woodenFee;
    }

    public void setWoodenFee(Float woodenFee) {
        this.woodenFee = woodenFee;
    }

    public Float getProductFromthewall() {
        return productFromthewall;
    }

    public void setProductFromthewall(Float productFromthewall) {
        this.productFromthewall = productFromthewall;
    }

    public String getLightColor() {
        return lightColor;
    }

    public void setLightColor(String lightColor) {
        this.lightColor = lightColor;
    }

}