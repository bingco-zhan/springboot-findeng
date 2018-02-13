package com.findeng.hibernate.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 配灯系统经销商自定义产品
 *
 * @author Alien
 */
@Entity
@Table(name = "custom_product")
public class CustomProduct implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static final int PRODUCT_STATUS_2 = 2; // 产品状态（2待审核，5上架中，6下架，-2审核不通过）

    public static final int PRODUCT_STATUS_5 = 5; // 产品状态（2待审核，5上架中，6下架，-2审核不通过）

    public static final int PRODUCT_STATUS_6 = 6; // 产品状态（2待审核，5上架中，6下架，-2审核不通过）

    private Integer productId;
    private Integer userId;
    private String productName;
    private String productContent;
    private Float unitPrice;
    private Integer productStyle;
    private String productColor;
    private Float productLength;
    private Float productWidth;
    private Float productHeight;
    private Float productDiameter;
    private Float productTrompil;
    private Float productWeight;
    private String productMaterial;
    private String productSpace;
    private String lightType;
    private String lightNumber;
    private Integer productKind;
    private Integer productSales;
    private String cover;
    private String descriptionPic;
    private Timestamp creatTime;
    private Integer isPopular;
    private String productQrCodePic;
    private Timestamp onlineTime;
    private Integer productStatus;
    private Integer productSeriesId;
    private Integer seriesIndex;
    private Integer seriesHead;
    private Integer purchaseQuantity;
    private Integer productHeadType;
    private Integer productVisitCount;
    private String productReportPic;
    private Integer productPlies;
    private Integer productShape;
    private Float costPrice;
    private String productTag;
    private Integer isSpreadProduct;
    private String productPower;
    private String productCode;
    private Integer productType;
    private Integer productClassify;

    @Id
    @GeneratedValue
    @Column(name = "product_id", unique = true, nullable = false)
    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name = "user_id")
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "product_name", length = 128)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "product_content")
    public String getProductContent() {
        return this.productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    @Column(name = "unit_price", precision = 11)
    public Float getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "product_style")
    public Integer getProductStyle() {
        return this.productStyle;
    }

    public void setProductStyle(Integer productStyle) {
        this.productStyle = productStyle;
    }

    @Column(name = "product_color", length = 64)
    public String getProductColor() {
        return this.productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    @Column(name = "product_length", precision = 11)
    public Float getProductLength() {
        return this.productLength;
    }

    public void setProductLength(Float productLength) {
        this.productLength = productLength;
    }

    @Column(name = "product_width", precision = 11)
    public Float getProductWidth() {
        return this.productWidth;
    }

    public void setProductWidth(Float productWidth) {
        this.productWidth = productWidth;
    }

    @Column(name = "product_height", precision = 11)
    public Float getProductHeight() {
        return this.productHeight;
    }

    public void setProductHeight(Float productHeight) {
        this.productHeight = productHeight;
    }

    @Column(name = "product_diameter", precision = 11)
    public Float getProductDiameter() {
        return this.productDiameter;
    }

    public void setProductDiameter(Float productDiameter) {
        this.productDiameter = productDiameter;
    }

    @Column(name = "product_trompil", precision = 11)
    public Float getProductTrompil() {
        return this.productTrompil;
    }

    public void setProductTrompil(Float productTrompil) {
        this.productTrompil = productTrompil;
    }

    @Column(name = "product_weight", precision = 11)
    public Float getProductWeight() {
        return this.productWeight;
    }

    public void setProductWeight(Float productWeight) {
        this.productWeight = productWeight;
    }

    @Column(name = "product_material", length = 128)
    public String getProductMaterial() {
        return this.productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    @Column(name = "product_space", length = 128)
    public String getProductSpace() {
        return this.productSpace;
    }

    public void setProductSpace(String productSpace) {
        this.productSpace = productSpace;
    }

    @Column(name = "light_type", length = 64)
    public String getLightType() {
        return this.lightType;
    }

    public void setLightType(String lightType) {
        this.lightType = lightType;
    }

    @Column(name = "light_number", length = 64)
    public String getLightNumber() {
        return this.lightNumber;
    }

    public void setLightNumber(String lightNumber) {
        this.lightNumber = lightNumber;
    }

    @Column(name = "product_kind")
    public Integer getProductKind() {
        return this.productKind;
    }

    public void setProductKind(Integer productKind) {
        this.productKind = productKind;
    }

    @Column(name = "product_sales")
    public Integer getProductSales() {
        return this.productSales;
    }

    public void setProductSales(Integer productSales) {
        this.productSales = productSales;
    }

    @Column(name = "cover", length = 256)
    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "description_pic", length = 256)
    public String getDescriptionPic() {
        return this.descriptionPic;
    }

    public void setDescriptionPic(String descriptionPic) {
        this.descriptionPic = descriptionPic;
    }

    @Column(name = "creat_time", length = 19)
    public Timestamp getCreatTime() {
        return this.creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Column(name = "is_popular")
    public Integer getIsPopular() {
        return this.isPopular;
    }

    public void setIsPopular(Integer isPopular) {
        this.isPopular = isPopular;
    }

    @Column(name = "product_qrCode_pic")
    public String getProductQrCodePic() {
        return this.productQrCodePic;
    }

    public void setProductQrCodePic(String productQrCodePic) {
        this.productQrCodePic = productQrCodePic;
    }

    @Column(name = "online_time")
    public Timestamp getOnlineTime() {
        return this.onlineTime;
    }

    public void setOnlineTime(Timestamp onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Column(name = "product_status")
    public Integer getProductStatus() {
        return this.productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    @Column(name = "product_series_id")
    public Integer getProductSeriesId() {
        return this.productSeriesId;
    }

    public void setProductSeriesId(Integer productSeriesId) {
        this.productSeriesId = productSeriesId;
    }

    @Column(name = "series_index")
    public Integer getSeriesIndex() {
        return this.seriesIndex;
    }

    public void setSeriesIndex(Integer seriesIndex) {
        this.seriesIndex = seriesIndex;
    }

    @Column(name = "series_head")
    public Integer getSeriesHead() {
        return this.seriesHead;
    }

    public void setSeriesHead(Integer seriesHead) {
        this.seriesHead = seriesHead;
    }

    @Column(name = "purchase_quantity")
    public Integer getPurchaseQuantity() {
        return this.purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    @Column(name = "product_head_type")
    public Integer getProductHeadType() {
        return this.productHeadType;
    }

    public void setProductHeadType(Integer productHeadType) {
        this.productHeadType = productHeadType;
    }

    @Column(name = "product_visit_count")
    public Integer getProductVisitCount() {
        return this.productVisitCount;
    }

    public void setProductVisitCount(Integer productVisitCount) {
        this.productVisitCount = productVisitCount;
    }

    @Column(name = "product_report_pic")
    public String getProductReportPic() {
        return this.productReportPic;
    }

    public void setProductReportPic(String productReportPic) {
        this.productReportPic = productReportPic;
    }

    @Column(name = "product_plies")
    public Integer getProductPlies() {
        return this.productPlies;
    }

    public void setProductPlies(Integer productPlies) {
        this.productPlies = productPlies;
    }

    @Column(name = "product_shape")
    public Integer getProductShape() {
        return this.productShape;
    }

    public void setProductShape(Integer productShape) {
        this.productShape = productShape;
    }

    @Column(name = "cost_price", precision = 11)
    public Float getCostPrice() {
        return this.costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    @Column(name = "product_tag", length = 64)
    public String getProductTag() {
        return this.productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    @Column(name = "is_spread_product")
    public Integer getIsSpreadProduct() {
        return this.isSpreadProduct;
    }

    public void setIsSpreadProduct(Integer isSpreadProduct) {
        this.isSpreadProduct = isSpreadProduct;
    }

    @Column(name = "product_power", length = 64)
    public String getProductPower() {
        return this.productPower;
    }

    public void setProductPower(String productPower) {
        this.productPower = productPower;
    }

    @Column(name = "product_code", length = 64)
    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Column(name = "product_type")
    public Integer getProductType() {
        return this.productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    @Column(name = "product_classify")
    public Integer getProductClassify() {
        return this.productClassify;
    }

    public void setProductClassify(Integer productClassify) {
        this.productClassify = productClassify;
    }

}