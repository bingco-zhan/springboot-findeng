package oldmodel;

/**
 * 产品信息表(旧版)
 *
 * @author Alien
 */
//@Entity
//@Table(name = "product")
public class Product_old implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
//	private Integer productId;
//	private Integer userId;
//	private String productName;
//	private String productContent;
//	private Float unitPrice;
//	private Float retailPrice;
//	private Integer productStock = 0;
//	private String productCode;
//	private Integer productType;
//	private Integer productStyle;
//	private String productBrand;
//	private String productColor;
//	private Float productLength = 0f;
//	private Float productWidth = 0f;
//	private Float productHeight = 0f;
//	private Float productDiameter = 0f;
//	private Float productTrompil;
//	private Float productWeight = 0f;
//	private String productMaterial;
//	private String productSpace;
//	private String lightType;
//	private String lightNumber = "0";
//	private Integer productKind = 0;
//	private Integer productSales = 0;
//	private String cover1;
//	private String cover2;
//	private String cover3;
//	private String cover4;
//	private String cover5;
//	private String descriptionPic1;
//	private String descriptionPic2;
//	private String descriptionPic3;
//	private String descriptionPic4;
//	private String descriptionPic5;
//	private String descriptionPic6;
//	private String descriptionPic7;
//	private String descriptionPic8;
//	private String descriptionPic9;
//	private String descriptionPic10;
//	private Timestamp creatTime;
//	private Timestamp publishTime;
//	private Timestamp checkTime;
//	private Integer isPopular;
//	private Float servicePrice;
//	private Float shoperSpreadMoney;
//	private Float originUnitPrice;
//	private Float freight = 0f;
//	private String productQrCodePic;
//	private Float installPrice = 0f;
//	private Timestamp offlineTime;
//	private Timestamp onlineTime;
//	private Integer productStatus;
//	private Integer productSeriesId;
//	private Float packageWeight = 0f;
//	private Float packageHeight = 0f;
//	private Float packageWidth = 0f;
//	private Float packageLength = 0f;
//	private Integer seriesIndex;
//	private Integer seriesHead;
//	private Integer productFictionSales;
//	private Integer purchaseQuantity;
//	private Integer productHeadType;
//	private Float platformPercent;
//	private Float spreadPercent;
//	private Integer receiveAddress;
//	private Integer productVisitCount;
//	private String productReportPic;
//	private Integer deliveryTime;
//	private Integer buyFlag;
//	private Integer productPlies;
//	private Integer productShape;
//	private Float costPrice;
//	private String productTag;
//	private Integer isSpreadProduct;
//	private Integer historySpreadProduct;
//	private Float woodenFee;
//	private Integer suggestWooden;
//	private String productPower;
//	private String productPngPic;
//	private String productSize;
//	private String descriptionPic11;
//	private String descriptionPic12;
//	private String descriptionPic13;
//	private String descriptionPic14;
//	private String descriptionPic15;
//	private String descriptionPic16;
//	private String descriptionPic17;
//	private String descriptionPic18;
//	private String descriptionPic19;
//	private String descriptionPic20;
//	private String threeCCertification;
//	private Integer productBoxNumber;
//	private String productOtherMaterial;
//	private String productOtherSpace;
//	private String productAliasName;
//	private Integer hasLightSource;
//	private String productSpreadPic;
//	private String qualityGuaranteeTime;
//	
//	public Product_old(Integer userId, String productName, String productContent,
//			Float unitPrice, Float retailPrice, Integer productStock,
//			String productCode, Integer productType, Integer productStyle,
//			String productBrand, String productColor, Float productLength,
//			Float productWidth, Float productHeight, Float productDiameter,
//			Float productTrompil, Float productWeight, String productMaterial,
//			String productSpace, String lightType, String lightNumber,
//			Integer productKind, Integer productSales, String cover1,
//			String cover2, String cover3, String cover4, String cover5,
//			String descriptionPic1, String descriptionPic2,
//			String descriptionPic3, String descriptionPic4,
//			String descriptionPic5, String descriptionPic6,
//			String descriptionPic7, String descriptionPic8,
//			String descriptionPic9, String descriptionPic10,
//			Timestamp creatTime, Timestamp publishTime, Timestamp checkTime,
//			Integer isPopular, Float servicePrice, Float shoperSpreadMoney,
//			Float originUnitPrice, Float freight, String productQrCodePic,
//			Float installPrice, Timestamp offlineTime, Timestamp onlineTime,
//			Integer productStatus, Integer productSeriesId,
//			Float packageWeight, Float packageHeight, Float packageWidth,
//			Float packageLength, Integer seriesIndex, Integer seriesHead,
//			Integer productFictionSales, Integer purchaseQuantity,
//			Integer productHeadType, Float platformPercent,
//			Float spreadPercent, Integer receiveAddress,
//			Integer productVisitCount, String productReportPic,
//			Integer deliveryTime, Integer buyFlag, Integer productPlies,
//			Integer productShape, Float costPrice, String productTag,
//			Integer isSpreadProduct, Integer historySpreadProduct,
//			Float woodenFee, Integer suggestWooden, String productPower,
//			String productPngPic, String productSize, String descriptionPic11,
//			String descriptionPic12, String descriptionPic13,
//			String descriptionPic14, String descriptionPic15,
//			String descriptionPic16, String descriptionPic17,
//			String descriptionPic18, String descriptionPic19,
//			String descriptionPic20, String threeCCertification,
//			Integer productBoxNumber, String productOtherMaterial,
//			String productOtherSpace, String productAliasName,
//			Integer hasLightSource, String productSpreadPic,
//			String qualityGuaranteeTime) {
//		this.userId = userId;
//		this.productName = productName;
//		this.productContent = productContent;
//		this.unitPrice = unitPrice;
//		this.retailPrice = retailPrice;
//		this.productStock = productStock;
//		this.productCode = productCode;
//		this.productType = productType;
//		this.productStyle = productStyle;
//		this.productBrand = productBrand;
//		this.productColor = productColor;
//		this.productLength = productLength;
//		this.productWidth = productWidth;
//		this.productHeight = productHeight;
//		this.productDiameter = productDiameter;
//		this.productTrompil = productTrompil;
//		this.productWeight = productWeight;
//		this.productMaterial = productMaterial;
//		this.productSpace = productSpace;
//		this.lightType = lightType;
//		this.lightNumber = lightNumber;
//		this.productKind = productKind;
//		this.productSales = productSales;
//		this.cover1 = cover1;
//		this.cover2 = cover2;
//		this.cover3 = cover3;
//		this.cover4 = cover4;
//		this.cover5 = cover5;
//		this.descriptionPic1 = descriptionPic1;
//		this.descriptionPic2 = descriptionPic2;
//		this.descriptionPic3 = descriptionPic3;
//		this.descriptionPic4 = descriptionPic4;
//		this.descriptionPic5 = descriptionPic5;
//		this.descriptionPic6 = descriptionPic6;
//		this.descriptionPic7 = descriptionPic7;
//		this.descriptionPic8 = descriptionPic8;
//		this.descriptionPic9 = descriptionPic9;
//		this.descriptionPic10 = descriptionPic10;
//		this.creatTime = creatTime;
//		this.publishTime = publishTime;
//		this.checkTime = checkTime;
//		this.isPopular = isPopular;
//		this.servicePrice = servicePrice;
//		this.shoperSpreadMoney = shoperSpreadMoney;
//		this.originUnitPrice = originUnitPrice;
//		this.freight = freight;
//		this.productQrCodePic = productQrCodePic;
//		this.installPrice = installPrice;
//		this.offlineTime = offlineTime;
//		this.onlineTime = onlineTime;
//		this.productStatus = productStatus;
//		this.productSeriesId = productSeriesId;
//		this.packageWeight = packageWeight;
//		this.packageHeight = packageHeight;
//		this.packageWidth = packageWidth;
//		this.packageLength = packageLength;
//		this.seriesIndex = seriesIndex;
//		this.seriesHead = seriesHead;
//		this.productFictionSales = productFictionSales;
//		this.purchaseQuantity = purchaseQuantity;
//		this.productHeadType = productHeadType;
//		this.platformPercent = platformPercent;
//		this.spreadPercent = spreadPercent;
//		this.receiveAddress = receiveAddress;
//		this.productVisitCount = productVisitCount;
//		this.productReportPic = productReportPic;
//		this.deliveryTime = deliveryTime;
//		this.buyFlag = buyFlag;
//		this.productPlies = productPlies;
//		this.productShape = productShape;
//		this.costPrice = costPrice;
//		this.productTag = productTag;
//		this.isSpreadProduct = isSpreadProduct;
//		this.historySpreadProduct = historySpreadProduct;
//		this.woodenFee = woodenFee;
//		this.suggestWooden = suggestWooden;
//		this.productPower = productPower;
//		this.productPngPic = productPngPic;
//		this.productSize = productSize;
//		this.descriptionPic11 = descriptionPic11;
//		this.descriptionPic12 = descriptionPic12;
//		this.descriptionPic13 = descriptionPic13;
//		this.descriptionPic14 = descriptionPic14;
//		this.descriptionPic15 = descriptionPic15;
//		this.descriptionPic16 = descriptionPic16;
//		this.descriptionPic17 = descriptionPic17;
//		this.descriptionPic18 = descriptionPic18;
//		this.descriptionPic19 = descriptionPic19;
//		this.descriptionPic20 = descriptionPic20;
//		this.threeCCertification = threeCCertification;
//		this.productBoxNumber = productBoxNumber;
//		this.productOtherMaterial = productOtherMaterial;
//		this.productOtherSpace = productOtherSpace;
//		this.productAliasName = productAliasName;
//		this.hasLightSource = hasLightSource;
//		this.productSpreadPic = productSpreadPic;
//		this.qualityGuaranteeTime = qualityGuaranteeTime;
//	}
//
//	// Property accessors
//	@Id
//	@GeneratedValue
//	@Column(name = "product_id", unique = true, nullable = false)
//	public Integer getProductId() {
//		return this.productId;
//	}
//
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}
//
//	@Column(name = "user_id")
//	public Integer getUserId() {
//		return this.userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	@Column(name = "product_name", length = 64)
//	public String getProductName() {
//		return this.productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	@Column(name = "product_content", length = 64)
//	public String getProductContent() {
//		return this.productContent;
//	}
//
//	public void setProductContent(String productContent) {
//		this.productContent = productContent;
//	}
//
//	@Column(name = "unit_price", precision = 12, scale = 0)
//	public Float getUnitPrice() {
//		return this.unitPrice;
//	}
//
//	public void setUnitPrice(Float unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//
//	@Column(name = "retail_price", precision = 12, scale = 0)
//	public Float getRetailPrice() {
//		return this.retailPrice;
//	}
//
//	public void setRetailPrice(Float retailPrice) {
//		this.retailPrice = retailPrice;
//	}
//
//	@Column(name = "product_stock")
//	public Integer getProductStock() {
//		return this.productStock;
//	}
//
//	public void setProductStock(Integer productStock) {
//		this.productStock = productStock;
//	}
//
//	@Column(name = "product_code", length = 128)
//	public String getProductCode() {
//		return this.productCode;
//	}
//
//	public void setProductCode(String productCode) {
//		this.productCode = productCode;
//	}
//
//	@Column(name = "product_type")
//	public Integer getProductType() {
//		return this.productType;
//	}
//
//	public void setProductType(Integer productType) {
//		this.productType = productType;
//	}
//
//	@Column(name = "product_style")
//	public Integer getProductStyle() {
//		return this.productStyle;
//	}
//
//	public void setProductStyle(Integer productStyle) {
//		this.productStyle = productStyle;
//	}
//
//	@Column(name = "product_brand", length = 128)
//	public String getProductBrand() {
//		return this.productBrand;
//	}
//
//	public void setProductBrand(String productBrand) {
//		this.productBrand = productBrand;
//	}
//
//	@Column(name = "product_color", length = 128)
//	public String getProductColor() {
//		return this.productColor;
//	}
//
//	public void setProductColor(String productColor) {
//		this.productColor = productColor;
//	}
//
//	@Column(name = "product_length", precision = 11)
//	public Float getProductLength() {
//		return this.productLength;
//	}
//
//	public void setProductLength(Float productLength) {
//		this.productLength = productLength;
//	}
//
//	@Column(name = "product_width", precision = 11)
//	public Float getProductWidth() {
//		return this.productWidth;
//	}
//
//	public void setProductWidth(Float productWidth) {
//		this.productWidth = productWidth;
//	}
//
//	@Column(name = "product_height", precision = 11)
//	public Float getProductHeight() {
//		return this.productHeight;
//	}
//
//	public void setProductHeight(Float productHeight) {
//		this.productHeight = productHeight;
//	}
//
//	@Column(name = "product_diameter", precision = 11)
//	public Float getProductDiameter() {
//		return this.productDiameter;
//	}
//
//	public void setProductDiameter(Float productDiameter) {
//		this.productDiameter = productDiameter;
//	}
//
//	@Column(name = "product_trompil", precision = 11)
//	public Float getProductTrompil() {
//		return this.productTrompil;
//	}
//
//	public void setProductTrompil(Float productTrompil) {
//		this.productTrompil = productTrompil;
//	}
//
//	@Column(name = "product_weight", precision = 11)
//	public Float getProductWeight() {
//		return this.productWeight;
//	}
//
//	public void setProductWeight(Float productWeight) {
//		this.productWeight = productWeight;
//	}
//
//	@Column(name = "product_material", length = 128)
//	public String getProductMaterial() {
//		return this.productMaterial;
//	}
//
//	public void setProductMaterial(String productMaterial) {
//		this.productMaterial = productMaterial;
//	}
//
//	@Column(name = "product_space", length = 128)
//	public String getProductSpace() {
//		return this.productSpace;
//	}
//
//	public void setProductSpace(String productSpace) {
//		this.productSpace = productSpace;
//	}
//
//	@Column(name = "light_type", length = 64)
//	public String getLightType() {
//		return this.lightType;
//	}
//
//	public void setLightType(String lightType) {
//		this.lightType = lightType;
//	}
//
//	@Column(name = "light_number", length = 64)
//	public String getLightNumber() {
//		return this.lightNumber;
//	}
//
//	public void setLightNumber(String lightNumber) {
//		this.lightNumber = lightNumber;
//	}
//
//	@Column(name = "product_kind")
//	public Integer getProductKind() {
//		return this.productKind;
//	}
//
//	public void setProductKind(Integer productKind) {
//		this.productKind = productKind;
//	}
//
//	@Column(name = "product_sales")
//	public Integer getProductSales() {
//		return this.productSales;
//	}
//
//	public void setProductSales(Integer productSales) {
//		this.productSales = productSales;
//	}
//
//	@Column(name = "cover1", length = 256)
//	public String getCover1() {
//		return this.cover1;
//	}
//
//	public void setCover1(String cover1) {
//		this.cover1 = cover1;
//	}
//
//	@Column(name = "cover2", length = 256)
//	public String getCover2() {
//		return this.cover2;
//	}
//
//	public void setCover2(String cover2) {
//		this.cover2 = cover2;
//	}
//
//	@Column(name = "cover3", length = 256)
//	public String getCover3() {
//		return this.cover3;
//	}
//
//	public void setCover3(String cover3) {
//		this.cover3 = cover3;
//	}
//
//	@Column(name = "cover4", length = 256)
//	public String getCover4() {
//		return this.cover4;
//	}
//
//	public void setCover4(String cover4) {
//		this.cover4 = cover4;
//	}
//
//	@Column(name = "cover5", length = 256)
//	public String getCover5() {
//		return this.cover5;
//	}
//
//	public void setCover5(String cover5) {
//		this.cover5 = cover5;
//	}
//
//	@Column(name = "description_pic1", length = 256)
//	public String getDescriptionPic1() {
//		return this.descriptionPic1;
//	}
//
//	public void setDescriptionPic1(String descriptionPic1) {
//		this.descriptionPic1 = descriptionPic1;
//	}
//
//	@Column(name = "description_pic2", length = 256)
//	public String getDescriptionPic2() {
//		return this.descriptionPic2;
//	}
//
//	public void setDescriptionPic2(String descriptionPic2) {
//		this.descriptionPic2 = descriptionPic2;
//	}
//
//	@Column(name = "description_pic3", length = 256)
//	public String getDescriptionPic3() {
//		return this.descriptionPic3;
//	}
//
//	public void setDescriptionPic3(String descriptionPic3) {
//		this.descriptionPic3 = descriptionPic3;
//	}
//
//	@Column(name = "description_pic4", length = 256)
//	public String getDescriptionPic4() {
//		return this.descriptionPic4;
//	}
//
//	public void setDescriptionPic4(String descriptionPic4) {
//		this.descriptionPic4 = descriptionPic4;
//	}
//
//	@Column(name = "description_pic5", length = 256)
//	public String getDescriptionPic5() {
//		return this.descriptionPic5;
//	}
//
//	public void setDescriptionPic5(String descriptionPic5) {
//		this.descriptionPic5 = descriptionPic5;
//	}
//
//	@Column(name = "description_pic6", length = 256)
//	public String getDescriptionPic6() {
//		return this.descriptionPic6;
//	}
//
//	public void setDescriptionPic6(String descriptionPic6) {
//		this.descriptionPic6 = descriptionPic6;
//	}
//
//	@Column(name = "description_pic7", length = 256)
//	public String getDescriptionPic7() {
//		return this.descriptionPic7;
//	}
//
//	public void setDescriptionPic7(String descriptionPic7) {
//		this.descriptionPic7 = descriptionPic7;
//	}
//
//	@Column(name = "description_pic8", length = 256)
//	public String getDescriptionPic8() {
//		return this.descriptionPic8;
//	}
//
//	public void setDescriptionPic8(String descriptionPic8) {
//		this.descriptionPic8 = descriptionPic8;
//	}
//
//	@Column(name = "description_pic9", length = 256)
//	public String getDescriptionPic9() {
//		return this.descriptionPic9;
//	}
//
//	public void setDescriptionPic9(String descriptionPic9) {
//		this.descriptionPic9 = descriptionPic9;
//	}
//
//	@Column(name = "description_pic10", length = 256)
//	public String getDescriptionPic10() {
//		return this.descriptionPic10;
//	}
//
//	public void setDescriptionPic10(String descriptionPic10) {
//		this.descriptionPic10 = descriptionPic10;
//	}
//
//	@Column(name = "creat_time", length = 19)
//	public Timestamp getCreatTime() {
//		return this.creatTime;
//	}
//
//	public void setCreatTime(Timestamp creatTime) {
//		this.creatTime = creatTime;
//	}
//
//	@Column(name = "publish_time", length = 19)
//	public Timestamp getPublishTime() {
//		return this.publishTime;
//	}
//
//	public void setPublishTime(Timestamp publishTime) {
//		this.publishTime = publishTime;
//	}
//
//	@Column(name = "check_time", length = 19)
//	public Timestamp getCheckTime() {
//		return this.checkTime;
//	}
//
//	public void setCheckTime(Timestamp checkTime) {
//		this.checkTime = checkTime;
//	}
//
//	@Column(name = "is_popular")
//	public Integer getIsPopular() {
//		return this.isPopular;
//	}
//
//	public void setIsPopular(Integer isPopular) {
//		this.isPopular = isPopular;
//	}
//
//	@Column(name = "service_price", precision = 12, scale = 0)
//	public Float getServicePrice() {
//		return this.servicePrice;
//	}
//
//	public void setServicePrice(Float servicePrice) {
//		this.servicePrice = servicePrice;
//	}
//
//	@Column(name = "shoper_spread_money", precision = 12, scale = 0)
//	public Float getShoperSpreadMoney() {
//		return this.shoperSpreadMoney;
//	}
//
//	public void setShoperSpreadMoney(Float shoperSpreadMoney) {
//		this.shoperSpreadMoney = shoperSpreadMoney;
//	}
//
//	@Column(name = "origin_unit_price", precision = 10)
//	public Float getOriginUnitPrice() {
//		return this.originUnitPrice;
//	}
//
//	public void setOriginUnitPrice(Float originUnitPrice) {
//		this.originUnitPrice = originUnitPrice;
//	}
//
//	@Column(name = "freight", precision = 10)
//	public Float getFreight() {
//		return this.freight;
//	}
//
//	public void setFreight(Float freight) {
//		this.freight = freight;
//	}
//
//	@Column(name = "product_qrCode_pic", length = 256)
//	public String getProductQrCodePic() {
//		return this.productQrCodePic;
//	}
//
//	public void setProductQrCodePic(String productQrCodePic) {
//		this.productQrCodePic = productQrCodePic;
//	}
//
//	@Column(name = "install_price", precision = 10)
//	public Float getInstallPrice() {
//		return this.installPrice;
//	}
//
//	public void setInstallPrice(Float installPrice) {
//		this.installPrice = installPrice;
//	}
//
//	@Column(name = "offline_time", length = 19)
//	public Timestamp getOfflineTime() {
//		return this.offlineTime;
//	}
//
//	public void setOfflineTime(Timestamp offlineTime) {
//		this.offlineTime = offlineTime;
//	}
//
//	@Column(name = "online_time", length = 19)
//	public Timestamp getOnlineTime() {
//		return this.onlineTime;
//	}
//
//	public void setOnlineTime(Timestamp onlineTime) {
//		this.onlineTime = onlineTime;
//	}
//
//	@Column(name = "product_status")
//	public Integer getProductStatus() {
//		return this.productStatus;
//	}
//
//	public void setProductStatus(Integer productStatus) {
//		this.productStatus = productStatus;
//	}
//
//	@Column(name = "product_series_id")
//	public Integer getProductSeriesId() {
//		return this.productSeriesId;
//	}
//
//	public void setProductSeriesId(Integer productSeriesId) {
//		this.productSeriesId = productSeriesId;
//	}
//
//	@Column(name = "package_weight", precision = 11)
//	public Float getPackageWeight() {
//		return this.packageWeight;
//	}
//
//	public void setPackageWeight(Float packageWeight) {
//		this.packageWeight = packageWeight;
//	}
//
//	@Column(name = "package_height", precision = 11)
//	public Float getPackageHeight() {
//		return this.packageHeight;
//	}
//
//	public void setPackageHeight(Float packageHeight) {
//		this.packageHeight = packageHeight;
//	}
//
//	@Column(name = "package_width", precision = 11)
//	public Float getPackageWidth() {
//		return this.packageWidth;
//	}
//
//	public void setPackageWidth(Float packageWidth) {
//		this.packageWidth = packageWidth;
//	}
//
//	@Column(name = "package_length", precision = 11)
//	public Float getPackageLength() {
//		return this.packageLength;
//	}
//
//	public void setPackageLength(Float packageLength) {
//		this.packageLength = packageLength;
//	}
//
//	@Column(name = "series_index")
//	public Integer getSeriesIndex() {
//		return this.seriesIndex;
//	}
//
//	public void setSeriesIndex(Integer seriesIndex) {
//		this.seriesIndex = seriesIndex;
//	}
//
//	@Column(name = "series_head")
//	public Integer getSeriesHead() {
//		return this.seriesHead;
//	}
//
//	public void setSeriesHead(Integer seriesHead) {
//		this.seriesHead = seriesHead;
//	}
//
//	@Column(name = "product_fiction_sales")
//	public Integer getProductFictionSales() {
//		return this.productFictionSales;
//	}
//
//	public void setProductFictionSales(Integer productFictionSales) {
//		this.productFictionSales = productFictionSales;
//	}
//
//	@Column(name = "purchase_quantity")
//	public Integer getPurchaseQuantity() {
//		return this.purchaseQuantity;
//	}
//
//	public void setPurchaseQuantity(Integer purchaseQuantity) {
//		this.purchaseQuantity = purchaseQuantity;
//	}
//
//	@Column(name = "product_head_type")
//	public Integer getProductHeadType() {
//		return this.productHeadType;
//	}
//
//	public void setProductHeadType(Integer productHeadType) {
//		this.productHeadType = productHeadType;
//	}
//
//	@Column(name = "platform_percent", precision = 11, scale = 4)
//	public Float getPlatformPercent() {
//		return this.platformPercent;
//	}
//
//	public void setPlatformPercent(Float platformPercent) {
//		this.platformPercent = platformPercent;
//	}
//
//	@Column(name = "spread_percent", precision = 11, scale = 4)
//	public Float getSpreadPercent() {
//		return this.spreadPercent;
//	}
//
//	public void setSpreadPercent(Float spreadPercent) {
//		this.spreadPercent = spreadPercent;
//	}
//
//	@Column(name = "receive_address")
//	public Integer getReceiveAddress() {
//		return this.receiveAddress;
//	}
//
//	public void setReceiveAddress(Integer receiveAddress) {
//		this.receiveAddress = receiveAddress;
//	}
//
//	@Column(name = "product_visit_count")
//	public Integer getProductVisitCount() {
//		return this.productVisitCount;
//	}
//
//	public void setProductVisitCount(Integer productVisitCount) {
//		this.productVisitCount = productVisitCount;
//	}
//
//	@Column(name = "product_report_pic", length = 256)
//	public String getProductReportPic() {
//		return this.productReportPic;
//	}
//
//	public void setProductReportPic(String productReportPic) {
//		this.productReportPic = productReportPic;
//	}
//
//	@Column(name = "delivery_time")
//	public Integer getDeliveryTime() {
//		return this.deliveryTime;
//	}
//
//	public void setDeliveryTime(Integer deliveryTime) {
//		this.deliveryTime = deliveryTime;
//	}
//
//	@Column(name = "buy_flag")
//	public Integer getBuyFlag() {
//		return this.buyFlag;
//	}
//
//	public void setBuyFlag(Integer buyFlag) {
//		this.buyFlag = buyFlag;
//	}
//
//	@Column(name = "product_plies")
//	public Integer getProductPlies() {
//		return this.productPlies;
//	}
//
//	public void setProductPlies(Integer productPlies) {
//		this.productPlies = productPlies;
//	}
//
//	@Column(name = "product_shape")
//	public Integer getProductShape() {
//		return this.productShape;
//	}
//
//	public void setProductShape(Integer productShape) {
//		this.productShape = productShape;
//	}
//
//	@Column(name = "cost_price", precision = 11)
//	public Float getCostPrice() {
//		return this.costPrice;
//	}
//
//	public void setCostPrice(Float costPrice) {
//		this.costPrice = costPrice;
//	}
//
//	@Column(name = "product_tag", length = 64)
//	public String getProductTag() {
//		return this.productTag;
//	}
//
//	public void setProductTag(String productTag) {
//		this.productTag = productTag;
//	}
//
//	@Column(name = "is_spread_product")
//	public Integer getIsSpreadProduct() {
//		return this.isSpreadProduct;
//	}
//
//	public void setIsSpreadProduct(Integer isSpreadProduct) {
//		this.isSpreadProduct = isSpreadProduct;
//	}
//
//	@Column(name = "history_spread_product")
//	public Integer getHistorySpreadProduct() {
//		return this.historySpreadProduct;
//	}
//
//	public void setHistorySpreadProduct(Integer historySpreadProduct) {
//		this.historySpreadProduct = historySpreadProduct;
//	}
//
//	@Column(name = "wooden_fee", precision = 11)
//	public Float getWoodenFee() {
//		return this.woodenFee;
//	}
//
//	public void setWoodenFee(Float woodenFee) {
//		this.woodenFee = woodenFee;
//	}
//
//	@Column(name = "suggest_wooden")
//	public Integer getSuggestWooden() {
//		return this.suggestWooden;
//	}
//
//	public void setSuggestWooden(Integer suggestWooden) {
//		this.suggestWooden = suggestWooden;
//	}
//
//	@Column(name = "product_power", length = 64)
//	public String getProductPower() {
//		return this.productPower;
//	}
//
//	public void setProductPower(String productPower) {
//		this.productPower = productPower;
//	}
//
//	@Column(name = "product_png_pic", length = 256)
//	public String getProductPngPic() {
//		return this.productPngPic;
//	}
//
//	public void setProductPngPic(String productPngPic) {
//		this.productPngPic = productPngPic;
//	}
//
//	@Column(name = "product_size", length = 256)
//	public String getProductSize() {
//		return this.productSize;
//	}
//
//	public void setProductSize(String productSize) {
//		this.productSize = productSize;
//	}
//
//	@Column(name = "description_pic11", length = 256)
//	public String getDescriptionPic11() {
//		return this.descriptionPic11;
//	}
//
//	public void setDescriptionPic11(String descriptionPic11) {
//		this.descriptionPic11 = descriptionPic11;
//	}
//
//	@Column(name = "description_pic12", length = 256)
//	public String getDescriptionPic12() {
//		return this.descriptionPic12;
//	}
//
//	public void setDescriptionPic12(String descriptionPic12) {
//		this.descriptionPic12 = descriptionPic12;
//	}
//
//	@Column(name = "description_pic13", length = 256)
//	public String getDescriptionPic13() {
//		return this.descriptionPic13;
//	}
//
//	public void setDescriptionPic13(String descriptionPic13) {
//		this.descriptionPic13 = descriptionPic13;
//	}
//
//	@Column(name = "description_pic14", length = 256)
//	public String getDescriptionPic14() {
//		return this.descriptionPic14;
//	}
//
//	public void setDescriptionPic14(String descriptionPic14) {
//		this.descriptionPic14 = descriptionPic14;
//	}
//
//	@Column(name = "description_pic15", length = 256)
//	public String getDescriptionPic15() {
//		return this.descriptionPic15;
//	}
//
//	public void setDescriptionPic15(String descriptionPic15) {
//		this.descriptionPic15 = descriptionPic15;
//	}
//
//	@Column(name = "description_pic16", length = 256)
//	public String getDescriptionPic16() {
//		return this.descriptionPic16;
//	}
//
//	public void setDescriptionPic16(String descriptionPic16) {
//		this.descriptionPic16 = descriptionPic16;
//	}
//
//	@Column(name = "description_pic17", length = 256)
//	public String getDescriptionPic17() {
//		return this.descriptionPic17;
//	}
//
//	public void setDescriptionPic17(String descriptionPic17) {
//		this.descriptionPic17 = descriptionPic17;
//	}
//
//	@Column(name = "description_pic18", length = 256)
//	public String getDescriptionPic18() {
//		return this.descriptionPic18;
//	}
//
//	public void setDescriptionPic18(String descriptionPic18) {
//		this.descriptionPic18 = descriptionPic18;
//	}
//
//	@Column(name = "description_pic19", length = 256)
//	public String getDescriptionPic19() {
//		return this.descriptionPic19;
//	}
//
//	public void setDescriptionPic19(String descriptionPic19) {
//		this.descriptionPic19 = descriptionPic19;
//	}
//
//	@Column(name = "description_pic20", length = 256)
//	public String getDescriptionPic20() {
//		return this.descriptionPic20;
//	}
//
//	public void setDescriptionPic20(String descriptionPic20) {
//		this.descriptionPic20 = descriptionPic20;
//	}
//
//	@Column(name = "three_c_certification", length = 256)
//	public String getThreeCCertification() {
//		return this.threeCCertification;
//	}
//
//	public void setThreeCCertification(String threeCCertification) {
//		this.threeCCertification = threeCCertification;
//	}
//
//	@Column(name = "product_box_number")
//	public Integer getProductBoxNumber() {
//		return this.productBoxNumber;
//	}
//
//	public void setProductBoxNumber(Integer productBoxNumber) {
//		this.productBoxNumber = productBoxNumber;
//	}
//
//	@Column(name = "product_other_material", length = 256)
//	public String getProductOtherMaterial() {
//		return this.productOtherMaterial;
//	}
//
//	public void setProductOtherMaterial(String productOtherMaterial) {
//		this.productOtherMaterial = productOtherMaterial;
//	}
//
//	@Column(name = "product_other_space", length = 256)
//	public String getProductOtherSpace() {
//		return this.productOtherSpace;
//	}
//
//	public void setProductOtherSpace(String productOtherSpace) {
//		this.productOtherSpace = productOtherSpace;
//	}
//
//	@Column(name = "product_alias_name", length = 256)
//	public String getProductAliasName() {
//		return this.productAliasName;
//	}
//
//	public void setProductAliasName(String productAliasName) {
//		this.productAliasName = productAliasName;
//	}
//
//	@Column(name = "has_light_source")
//	public Integer getHasLightSource() {
//		return this.hasLightSource;
//	}
//
//	public void setHasLightSource(Integer hasLightSource) {
//		this.hasLightSource = hasLightSource;
//	}
//
//	@Column(name = "product_spread_pic", length = 256)
//	public String getProductSpreadPic() {
//		return this.productSpreadPic;
//	}
//
//	public void setProductSpreadPic(String productSpreadPic) {
//		this.productSpreadPic = productSpreadPic;
//	}
//
//	@Column(name = "quality_guarantee_time", length = 64)
//	public String getQualityGuaranteeTime() {
//		return this.qualityGuaranteeTime;
//	}
//
//	public void setQualityGuaranteeTime(String qualityGuaranteeTime) {
//		this.qualityGuaranteeTime = qualityGuaranteeTime;
//	}
//
//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", userId=" + userId + ", productName=" + productName
//				+ ", productContent=" + productContent + ", unitPrice=" + unitPrice + ", retailPrice=" + retailPrice
//				+ ", productStock=" + productStock + ", productCode=" + productCode + ", productType=" + productType
//				+ ", productStyle=" + productStyle + ", productBrand=" + productBrand + ", productColor=" + productColor
//				+ ", productLength=" + productLength + ", productWidth=" + productWidth + ", productHeight="
//				+ productHeight + ", productDiameter=" + productDiameter + ", productTrompil=" + productTrompil
//				+ ", productWeight=" + productWeight + ", productMaterial=" + productMaterial + ", productSpace="
//				+ productSpace + ", lightType=" + lightType + ", lightNumber=" + lightNumber + ", productKind="
//				+ productKind + ", productSales=" + productSales + ", cover1=" + cover1 + ", cover2=" + cover2
//				+ ", cover3=" + cover3 + ", cover4=" + cover4 + ", cover5=" + cover5 + ", descriptionPic1="
//				+ descriptionPic1 + ", descriptionPic2=" + descriptionPic2 + ", descriptionPic3=" + descriptionPic3
//				+ ", descriptionPic4=" + descriptionPic4 + ", descriptionPic5=" + descriptionPic5 + ", descriptionPic6="
//				+ descriptionPic6 + ", descriptionPic7=" + descriptionPic7 + ", descriptionPic8=" + descriptionPic8
//				+ ", descriptionPic9=" + descriptionPic9 + ", descriptionPic10=" + descriptionPic10 + ", creatTime="
//				+ creatTime + ", publishTime=" + publishTime + ", checkTime=" + checkTime + ", isPopular=" + isPopular
//				+ ", servicePrice=" + servicePrice + ", shoperSpreadMoney=" + shoperSpreadMoney + ", originUnitPrice="
//				+ originUnitPrice + ", freight=" + freight + ", productQrCodePic=" + productQrCodePic
//				+ ", installPrice=" + installPrice + ", offlineTime=" + offlineTime + ", onlineTime=" + onlineTime
//				+ ", productStatus=" + productStatus + ", productSeriesId=" + productSeriesId + ", packageWeight="
//				+ packageWeight + ", packageHeight=" + packageHeight + ", packageWidth=" + packageWidth
//				+ ", packageLength=" + packageLength + ", seriesIndex=" + seriesIndex + ", seriesHead=" + seriesHead
//				+ ", productFictionSales=" + productFictionSales + ", purchaseQuantity=" + purchaseQuantity
//				+ ", productHeadType=" + productHeadType + ", platformPercent=" + platformPercent + ", spreadPercent="
//				+ spreadPercent + ", receiveAddress=" + receiveAddress + ", productVisitCount=" + productVisitCount
//				+ ", productReportPic=" + productReportPic + ", deliveryTime=" + deliveryTime + ", buyFlag=" + buyFlag
//				+ ", productPlies=" + productPlies + ", productShape=" + productShape + ", costPrice=" + costPrice
//				+ ", productTag=" + productTag + ", isSpreadProduct=" + isSpreadProduct + ", historySpreadProduct="
//				+ historySpreadProduct + ", woodenFee=" + woodenFee + ", suggestWooden=" + suggestWooden
//				+ ", productPower=" + productPower + ", productPngPic=" + productPngPic + ", productSize=" + productSize
//				+ ", descriptionPic11=" + descriptionPic11 + ", descriptionPic12=" + descriptionPic12
//				+ ", descriptionPic13=" + descriptionPic13 + ", descriptionPic14=" + descriptionPic14
//				+ ", descriptionPic15=" + descriptionPic15 + ", descriptionPic16=" + descriptionPic16
//				+ ", descriptionPic17=" + descriptionPic17 + ", descriptionPic18=" + descriptionPic18
//				+ ", descriptionPic19=" + descriptionPic19 + ", descriptionPic20=" + descriptionPic20
//				+ ", threeCCertification=" + threeCCertification + ", productBoxNumber=" + productBoxNumber
//				+ ", productOtherMaterial=" + productOtherMaterial + ", productOtherSpace=" + productOtherSpace
//				+ ", productAliasName=" + productAliasName + ", hasLightSource=" + hasLightSource
//				+ ", productSpreadPic=" + productSpreadPic + ", qualityGuaranteeTime=" + qualityGuaranteeTime + "]";
//	}
}