package com.findeng.mvc.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.findeng.hibernate.entity.Address;
import com.findeng.hibernate.entity.Carousel;
import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.ProductSeries;
import com.findeng.hibernate.entity.PropertyValue;
import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.entity.UserPermission;
import com.findeng.hibernate.entity.UserRole;
import com.findeng.mvc.serviceimpl.AddressServiceImpl;
import com.findeng.mvc.serviceimpl.CarouselServiceImpl;
import com.findeng.mvc.serviceimpl.ProductSeriesServiceImpl;
import com.findeng.mvc.serviceimpl.ProductServiceImpl;
import com.findeng.mvc.serviceimpl.PropertyValueServiceImpl;
import com.findeng.mvc.serviceimpl.UserPermissionServiceImpl;
import com.findeng.mvc.serviceimpl.UserRoleServiceImpl;
import com.findeng.mvc.serviceimpl.UserServiceImpl;
import com.findeng.mvc.serviceimpl.WelcomePicServiceImpl;

@Controller
@RequestMapping(value = "/admin")
public class Admin {
	@Autowired
	private CarouselServiceImpl carouselServiceImpl;

	@Autowired
	private WelcomePicServiceImpl welcomePicServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired 
	private UserRoleServiceImpl userRoleServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@Autowired
	private ProductSeriesServiceImpl productSeriesServiceImpl;
	
	@Autowired
	private UserPermissionServiceImpl userPermissionServiceImpl;
	
	@Autowired
	private PropertyValueServiceImpl propertyValueServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Value("${httpFile.CarouselImageSrc}")
	private String CarouselImageSrc;

	@Value("${httpFile.WelcomePicSrc}")
	private String WelcomePicSrc;

	/**
	 * 管理系统登录页面
	 */
	@GetMapping(value = "/loginPage")
	public ModelAndView login(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/system/loginPage");
		return model;
	}

	/**
	 * 管理系统主页
	 */
	@GetMapping(value = "/index")
	public ModelAndView index(HttpSession session, ModelAndView model) {
		User user = (User)session.getAttribute("user");
		model.addObject("user",user);
		model.addObject("role",userRoleServiceImpl.findById(user.getRole().getId()));
		model.setViewName("/Admin/system/index");
		return model;
	}
	
	/**
	 * 查看个人资料界面
	 */
	@GetMapping("/userInfo")
	public ModelAndView readUserdetail(HttpSession session, ModelAndView model) {
		User user = (User)session.getAttribute("user");
		model.addObject("user",user);
		model.addObject("role",userRoleServiceImpl.findById(user.getRole().getId()));
		model.addObject("address",addressServiceImpl.findByAddressName(user.getProvinceId(), user.getCityId(), user.getAreaId()));
		model.setViewName("/Admin/system/userInfo");
		return model;
	}

	/**
	 * 系统设置
	 */
	@GetMapping(value = "/systemsetting")
	public ModelAndView systemsetting(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/system/systemsetting");
		return model;
	}

	/**
	 * 修改轮播图界面
	 */
	@GetMapping(value = "/CarouselFigure")
	public ModelAndView carouselfigure(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/mobileMallManagement/CarouselFigure");
		// 设置轮播图
		List<Carousel> carouse = carouselServiceImpl.findAll();
		model.addObject("carouselList", carouse);
		model.addObject("CarouselImageSrc", CarouselImageSrc);
		return model;
	}

	/**
	 * 修改欢迎图界面
	 */
	@GetMapping(value = "/WelcomePic")
	public ModelAndView WelcomePic(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/mobileMallManagement/WelcomePic");
		model.addObject("welcomepic", welcomePicServiceImpl.getCurrentWelcomePic());
		model.addObject("WelcomePicSrc", WelcomePicSrc);
		return model;
	}

	/**
	 * 用户管理界面
	 */
	@GetMapping(value = "/userManagement")
	public ModelAndView UserPermissionManagement(HttpSession session, ModelAndView model) {
		List<UserRole> list = userRoleServiceImpl.findByAll();
		model.addObject("userRoleList",list);
		model.addObject("userRoleJSONArr",new JSONArray(list));
		model.setViewName("/Admin/userManagement/userManagement");
		return model;
	}

	/**
	 * 角色权限管理界面
	 */
	@GetMapping(value = "/roleManagement")
	public ModelAndView UserRoleManagement(HttpSession session, ModelAndView model) {
		List<UserPermission> list = userPermissionServiceImpl.findByAll();
		model.addObject("userPermissionList",new JSONArray(list));
		model.setViewName("/Admin/userManagement/roleManagement");
		return model;
	}
	
	/**
	 * 修改用户权限界面
	 */
	@GetMapping(value = "/roleManagement/modifyPermission")
	public ModelAndView modifyPermission(HttpSession session,ModelAndView model,
			@RequestParam(value="roleId",required = true) int roleId) {
		List<UserPermission> userPermissionList = userPermissionServiceImpl.findByAll();
		UserRole userRole = userRoleServiceImpl.findById(roleId);
		model.addObject("userPermissionList",userPermissionList);
		model.addObject("userRole",userRole);
		model.setViewName("/Admin/popupTemplate/modifyPermission");
		return model;
	}
	
	/**
	 * 添加用户角色界面
	 */
	@GetMapping(value = "/roleManagement/addUserRole")
	public ModelAndView addUserRole(HttpSession session, ModelAndView model) {
		List<UserPermission> list = userPermissionServiceImpl.findByAll();
		model.addObject("userPermissionList",list);
		model.setViewName("/Admin/popupTemplate/addUserRole");
		return model;
	}

	/**
	 * 配灯系统管理页面
	 */
	@RequestMapping("/lampPermission")
	public ModelAndView lampSelectionManagement(ModelAndView model) {
		model.setViewName("/Admin/userManagement/lampPermission");
		return model;
	}
	
	/**
	 * 配灯系统授权弹窗
	 */
	@RequestMapping("/lampPermission/authorize")
	public ModelAndView lampSelectionAuthorize(ModelAndView model) {
		model.setViewName("/Admin/popupTemplate/lampPermissionAuthentication");
		return model;
	}

	/**
	 * 用户认证界面
	 */
	@GetMapping(value = "/userAuthentication")
	public ModelAndView userAuthentication(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/userManagement/userAuthentication");
		return model;
	}
	
	/**
	 * 注册厂家界面
	 */
	@GetMapping(value = "/userAuthentication/registeredFactory")
	public ModelAndView registeredFactory(HttpSession session, ModelAndView model,
			@RequestParam Integer userId) {
		List<Address> provinceList= addressServiceImpl.findeByUpId("0");
		model.addObject("provinceList",provinceList);
		model.setViewName("/Admin/popupTemplate/registeredFactory");
		return model;
	}
	
	/**
	 * 注册经销商界面
	 */
	@GetMapping(value = "/userAuthentication/registeredDealer")
	public ModelAndView registeredDealer(HttpSession session, ModelAndView model,
			@RequestParam Integer userId) {
		List<Address> provinceList= addressServiceImpl.findeByUpId("0");
		model.addObject("provinceList",provinceList);
		model.setViewName("/Admin/popupTemplate/registeredDealer");
		return model;
	}
	
	/**
	 * 注册业务员界面
	 */
	@GetMapping(value = "/userAuthentication/registeredStaff")
	public ModelAndView registeredStaff(HttpSession session, ModelAndView model,
			@RequestParam Integer userId) {
		List<Address> provinceList= addressServiceImpl.findeByUpId("0");
		model.addObject("provinceList",provinceList);
		model.setViewName("/Admin/popupTemplate/registeredStaff");
		return model;
	}

	/**
	 * 审批用户认证界面
	 */
	@GetMapping(value = "/approvalUserAuthentication")
	public ModelAndView approvalUserAuthentication(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/userManagement/approvalUserAuthentication");
		return model;
	}
	
	/**
	 * 客户绑定关系
	 */
	@GetMapping(value = "/customerBinding")
	public ModelAndView changeSuperior(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/userManagement/customerBinding");
		return model;
	}

	/**
	 * 客户绑定关系
	 */
	@GetMapping(value = "/approvalUnbinding")
	public ModelAndView approvalUnbinding(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/userManagement/approvalUnbinding");
		return model;
	}

	/**
	 * 申请申请折扣审批
	 */
	@GetMapping(value = "/discountApproval")
	public ModelAndView discountApproval(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/userManagement/discountApproval");
		return model;
	}

	/**
	 * 查看资金流水详情
	 */
	@GetMapping(value = "/checkCapitalFlow")
	public ModelAndView checkCapitalFlow(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/fundManagement/checkCapitalFlow");
		return model;
	}

	/**
	 * 审批提现申请
	 */
	@GetMapping(value = "/withdrawalsApproval")
	public ModelAndView approvalWithdrawals(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/fundManagement/withdrawalsApproval");
		return model;
	}

	/**
	 * 供应商添加商品界面
	 */
	@GetMapping(value = "/product/factory")
	public ModelAndView factoryAddproduct(HttpSession session, ModelAndView model) {
		User user = (User)session.getAttribute("user");
		model.addObject("user",user);
		//产品系列
		List<ProductSeries> productSeriesList = productSeriesServiceImpl.findSelectData(user.getUserId());
		model.addObject("productSeriesList",productSeriesList);
		//产品类型
		List<PropertyValue> productTypeList = propertyValueServiceImpl.findByPropertyId(37);
		model.addObject("productTypeList",productTypeList);
		//产品风格
		List<PropertyValue> productStyleList = propertyValueServiceImpl.findByPropertyId(39);
		model.addObject("productStyleList",productStyleList);
		//光源类型
		List<PropertyValue> lightTypeList = propertyValueServiceImpl.findByPropertyId(55);
		model.addObject("lightTypeList",lightTypeList);
		//光源类型
		List<PropertyValue> productShapeList = propertyValueServiceImpl.findByPropertyId(54);
		model.addObject("productShapeList",productShapeList);
		//材质
		List<PropertyValue> materialList = propertyValueServiceImpl.findByPropertyId(38);
		model.addObject("materialList",materialList);
		//空间
		List<PropertyValue> spaceList = propertyValueServiceImpl.findByPropertyId(40);
		model.addObject("spaceList",spaceList);
		model.setViewName("/Admin/productManagement/factoryAddProduct");
		return model;
	}
	
	/**
	 * 供应商修改商品界面
	 */
	@GetMapping(value = "/product/modifyFactoryProduct")
	public ModelAndView modifyFactoryProduct(HttpSession session, ModelAndView model,@RequestParam int productId) {
		User user = (User)session.getAttribute("user");
		Product product = productServiceImpl.findById(productId);
		//判断是否产品拥有者
		if(!user.getUserId().equals(product.getUserId())){
			return null;
		}
		model.addObject("user",user);
		//产品系列
		List<ProductSeries> productSeriesList = productSeriesServiceImpl.findSelectData(user.getUserId());
		model.addObject("productSeriesList",productSeriesList);
		//产品类型
		List<PropertyValue> productTypeList = propertyValueServiceImpl.findByPropertyId(37);
		model.addObject("productTypeList",productTypeList);
		//产品风格
		List<PropertyValue> productStyleList = propertyValueServiceImpl.findByPropertyId(39);
		model.addObject("productStyleList",productStyleList);
		//光源类型
		List<PropertyValue> lightTypeList = propertyValueServiceImpl.findByPropertyId(55);
		model.addObject("lightTypeList",lightTypeList);
		//光源类型
		List<PropertyValue> productShapeList = propertyValueServiceImpl.findByPropertyId(54);
		model.addObject("productShapeList",productShapeList);
		//材质
		List<PropertyValue> materialList = propertyValueServiceImpl.findByPropertyId(38);
		model.addObject("materialList",materialList);
		//空间
		List<PropertyValue> spaceList = propertyValueServiceImpl.findByPropertyId(40);
		model.addObject("spaceList",spaceList);
		model.addObject("product",product);
		model.setViewName("/Admin/popupTemplate/modifyFactoryProduct");
		return model;
	}

	/**
	 * 经销商添加商品界面
	 */
	@GetMapping(value = "/product/dealers")
	public ModelAndView dealersAddProduct(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/productManagement/dealersAddProduct");
		return model;
	}

	/**
	 * 平台添加商品界面
	 */
	@GetMapping(value = "/product/platform")
	public ModelAndView platformAddProduct(HttpSession session, ModelAndView model) {
		User user = (User)session.getAttribute("user");
		model.addObject("user",user);
		//产品系列
		List<ProductSeries> productSeriesList = productSeriesServiceImpl.findSelectData(user.getUserId());
		model.addObject("productSeriesList",productSeriesList);
		//产品类型
		List<PropertyValue> productTypeList = propertyValueServiceImpl.findByPropertyId(37);
		model.addObject("productTypeList",productTypeList);
		//产品风格
		List<PropertyValue> productStyleList = propertyValueServiceImpl.findByPropertyId(39);
		model.addObject("productStyleList",productStyleList);
		//光源类型
		List<PropertyValue> lightTypeList = propertyValueServiceImpl.findByPropertyId(55);
		model.addObject("lightTypeList",lightTypeList);
		//光源类型
		List<PropertyValue> productShapeList = propertyValueServiceImpl.findByPropertyId(54);
		model.addObject("productShapeList",productShapeList);
		//材质
		List<PropertyValue> materialList = propertyValueServiceImpl.findByPropertyId(38);
		model.addObject("materialList",materialList);
		//空间
		List<PropertyValue> spaceList = propertyValueServiceImpl.findByPropertyId(40);
		model.addObject("spaceList",spaceList);
		//厂家品牌
		List<String[]> productBrandList = userServiceImpl.findSelectData(1);
		model.addObject("productBrandList",productBrandList);
		model.setViewName("/Admin/productManagement/platformAddProduct");
		return model;
	}

	/**
	 * 平台商品列表界面
	 */
	@GetMapping(value = "/product/platformProductList")
	public ModelAndView platformProductList(HttpSession session, ModelAndView model) {
		model.addObject("factoryList", userServiceImpl.findSelectData(1));
		model.setViewName("/Admin/productManagement/platformProductList");
		return model;
	}
	
	/**
	 * 平台修改商品界面
	 */
	@GetMapping(value = "/product/modifyPlatformProduct")
	public ModelAndView modifyProduct(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/popupTemplate/modifyPlatformProduct");
		return model;
	}

	/**
	 * 供应商商品列表界面
	 */
	@GetMapping(value = "/product/factoryProductList")
	public ModelAndView productManagement(HttpSession session, ModelAndView model) {
		User user = (User)session.getAttribute("user");
		List<ProductSeries>  productSeriesList = productSeriesServiceImpl.findSelectData(user.getUserId());
		model.addObject("productSeriesList",productSeriesList);
		model.addObject("productSeriesListJSON",new JSONArray(productSeriesList));
		model.setViewName("/Admin/productManagement/factoryProductList");
		return model;
	}

	/**
	 * 经销商商品列表界面
	 */
	@GetMapping(value = "product/dealersProductList")
	public ModelAndView dealersProductList(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/productManagement/dealersProductList");
		return model;
	}

	/**
	 * 商品推广界面
	 */
	@GetMapping(value = "/productSpread")
	public ModelAndView productSpread(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/productManagement/productSpread");
		return model;
	}

	/**
	 * 商品系列界面
	 */
	@GetMapping(value = "/productSeries")
	public ModelAndView productSeries(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/productManagement/productSeries");
		return model;
	}

	/**
	 * 售后服务界面
	 */
	@GetMapping(value = "/afterService")
	public ModelAndView afterService(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/orderManagement/afterService");
		return model;
	}

	/**
	 * 订单列表界面
	 */
	@GetMapping(value = "/factoryOrderList")
	public ModelAndView factoryOrderList(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/orderManagement/factoryOrderList");
		return model;
	}

	/**
	 * 订单列表界面
	 */
	@GetMapping(value = "/dealersOrderList")
	public ModelAndView dealersOrderList(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/orderManagement/dealersOrderList");
		return model;
	}

	/**
	 * 订单列表界面
	 */
	@GetMapping(value = "/platformOrderList")
	public ModelAndView platformOrderList(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/orderManagement/platformOrderList");
		return model;
	}

	/**
	 * 库存状况界面
	 */
	@GetMapping(value = "/stockStatus")
	public ModelAndView stockStatus(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/orderManagement/stockStatus");
		return model;
	}

	/**
	 * 资金报表界面
	 */
	@GetMapping(value = "/fundReport")
	public ModelAndView fundReport(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/dataAnalysis/fundReport");
		return model;
	}

	/**
	 * 用户报表界面
	 */
	@GetMapping(value = "/userdReport")
	public ModelAndView userdReport(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/dataAnalysis/userdReport");
		return model;
	}

	/**
	 * 业绩报表界面
	 */
	@GetMapping(value = "/earningReport")
	public ModelAndView earningReport(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/dataAnalysis/earningReport");
		return model;
	}
	
	/**
	 * 公众号数据
	 */
	@GetMapping(value = "/publicNumberData")
	public ModelAndView publicNumberData(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/dataAnalysis/publicNumberData");
		return model;
	}
	
	/**
	 * 用户地图界面
	 */
	@GetMapping(value = "/userMap")
	public ModelAndView userMap(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/dataAnalysis/userMap");
		return model;
	}

	/**
	 * 审批厂家产品商品
	 */
	@GetMapping(value = "/approvalFactoryProduct")
	public ModelAndView approvalFactoryProduct(HttpSession session, ModelAndView model) {
		model.setViewName("/Admin/productManagement/approvalFactoryProduct");
		return model;
	}
}
