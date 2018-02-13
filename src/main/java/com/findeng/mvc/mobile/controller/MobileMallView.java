package com.findeng.mvc.mobile.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.findeng.hibernate.model.MobileProductModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.findeng.hibernate.entity.Carousel;
import com.findeng.hibernate.entity.CustomProduct;
import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.PropertyValue;
import com.findeng.hibernate.entity.User;
import com.findeng.mvc.service.CarouselService;
import com.findeng.mvc.service.CustomProductService;
import com.findeng.mvc.service.ProductService;
import com.findeng.mvc.service.PropertyValueService;
import com.findeng.mvc.service.UserService;

/**
 * 手机商城页面请求控制器
 *
 * @author Alien
 */
@Controller
@RequestMapping(value = "/mobilemall")
public class MobileMallView {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CustomProductService customProductService;

    @Autowired
    private PropertyValueService propertyValueService;

    /**
     * 进入手机商城页面
     */
    @GetMapping(value = "/index")
    public ModelAndView index(HttpSession session, ModelAndView model) {

        /*
         * 风格分类
         */
        List<PropertyValue> styles = propertyValueService.findByPropertyIdIn(new int[]{39}, 1);
        model.addObject("styles", styles);

        /*
         * 轮播图
         */
        List<Carousel> carousels = carouselService.findAll();
        model.addObject("carousels", carousels);

        Product product = new Product();
        product.setProductStatus(Product.STATE_5);

        String openId = (String) session.getAttribute("openId");
        User user = userService.findByOpenId(openId);

        /*
         * 店铺信息
         */
        if (user != null && user.getRole().getId() == 5) {
            User upuser = userService.findByUserId(user.getUpperUserId());
            if (upuser != null && upuser.getRole().getId() == 4) {
                model.addObject("DPXX", upuser);
            } else {
                User upupuser = new User();
                upupuser.setCompanyName("繁灯网线下体验馆");
                upupuser.setPhoneNumber("076089839230");
                upupuser.setCompanyAddressDetail("中山市古镇鹰皇国际灯饰五楼繁灯网");
                model.addObject("DPXX", upupuser);
            }
        } else if (user != null && user.getRole().getId() == 4) {
            model.addObject("DPXX", user);
        } else {
            User upupuser = new User();
            upupuser.setCompanyName("繁灯网线下体验馆");
            upupuser.setPhoneNumber("076089839230");
            upupuser.setCompanyAddressDetail("中山市古镇鹰皇国际灯饰五楼繁灯网");
            model.addObject("DPXX", upupuser);
        }

        /*
         * 活动商品
         */
        product.setProductTag("活动");
        Page<Product> hotProducts = productService.findByPaging(product, 0, 3, null, null);
        model.addObject("HDs", hotProducts.getContent());
        product.setProductTag(null);

        /*
         * 吸顶灯,吊灯,壁灯,台灯,落地灯
         */
        Object types[][] = {{"DDs", 180, 3}, {"SDDs", 185, 1}, {"BDs", 181, 1}, {"TDs", 182, 1}, {"LDDs", 184, 1}};
        for (Object[] obje : types) {
            product.setProductType(obje[1].toString());
            Page<Product> page = productService.findByPaging(product, 0, Integer.parseInt(obje[2].toString()), null, null);
            model.addObject(obje[0].toString(), page.getContent());
        }
        product.setProductType(null);

        /*
         * 新中式,现代简约,美式,欧式,后现代风格,古典中式,北欧,儿童灯
         */
        Object _styles[][] = {{"SZSs", 526, 2}, {"XDJYs", 210, 2}, {"MSs", 209, 2}, {"OSs", 208, 2}, {"HXDFGs", 649, 1}, {"GDZSs", 604, 1}, {"BOs", 671, 1}, {"ETDs", 212, 1}};
        for (Object[] obje : _styles) {
            product.setProductStyle(obje[1].toString());
            Page<Product> page = productService.findByPaging(product, 0, Integer.parseInt(obje[2].toString()), null, null);
            model.addObject(obje[0].toString(), page.getContent());
        }
        product.setProductStyle(null);

        /*
         * 今日推荐
         */
        product.setProductTag("推荐");
        Page<Product> toDays = productService.findByPaging(product, 0, 10, null, null);
        model.addObject("toDays", toDays.getContent());
        product.setProductTag(null);

        /*
         * 同城  adadsdsdds 其实就是用户的上级经销商,套路啊
         */
        List<CustomProduct> tongChengs = new LinkedList<>();
        if (user != null && user.getRole().getId() == 5) {
            User upperUser = userService.findByUserId(user.getUpperUserId());
            if (upperUser != null && upperUser.getRole().getId() == 4) {
                CustomProduct customProduct = new CustomProduct();
                customProduct.setProductStatus(CustomProduct.PRODUCT_STATUS_5);
                customProduct.setUserId(upperUser.getUserId());
                Page<CustomProduct> paging = customProductService.findByPaging(customProduct, 0, 10, null, null);
                tongChengs.addAll(paging.getContent());
            }
        }
        model.addObject("TCs", tongChengs);

        model.setViewName("/MobileMall/index");
        return model;
    }

    /**
     * 商城主页分类按钮
     */
    @GetMapping(value = "/classification")
    public ModelAndView classification(HttpSession session, ModelAndView model) {

        Object classify[][] = {{"styles", 39}, {"types", 37}, {"rooms", 40}, {"materials", 38}, {"forms", 54},
                {"gradations", 56}, {"diameters", 57}, {"lengths", 58}, {"heigths", 59}, {"prices", 42}, {"ligths", 55}};
        for (Object[] obje : classify) {
            List<PropertyValue> array = propertyValueService.findByPropertyIdIn(new int[]{Integer.parseInt(obje[1].toString())}, 1);
            model.addObject(obje[0].toString(), array);
        }

        model.setViewName("/MobileMall/classification");
        return model;
    }

    /**
     * 购物车页面
     */
    @GetMapping(value = "/shopcart")
    public ModelAndView shopcart(HttpSession session, ModelAndView model) {
        model.setViewName("/MobileMall/shopcart");
        return model;
    }

    /**
     * 个人中心页面
     */
    @GetMapping(value = "/personal")
    public ModelAndView personal(HttpSession session, ModelAndView model) {
        model.setViewName("/MobileMall/personal");
        return model;
    }

    /**
     * 产品列表页面
     */
    @GetMapping(value = "/productlist")
    public ModelAndView productList(HttpSession session, MobileProductModel pmodel, ModelAndView model) {
        String str = new JSONObject(pmodel).toString();
        System.out.println(str);
        model.addObject("pmodel", str);
        model.setViewName("/MobileMall/product/productlist");
        return model;
    }

    /**
     * 产品详情页
     */
    @GetMapping(value = "/productdetails/{productId}")
    public ModelAndView productDetails(@PathVariable int productId, HttpSession session, ModelAndView model) {
        Product product = productService.findById(productId);
        product.setProductType(propertyValueService.findById(Integer.parseInt(product.getProductType())).getPropertyValue());
        product.setProductMaterial(propertyValueService.findByIdToNameString(product.getProductMaterial().split(";")));
        product.setProductStyle(propertyValueService.findById(Integer.parseInt(product.getProductStyle())).getPropertyValue());
        product.setLight_Type(propertyValueService.findById(product.getLightType()).getPropertyValue());
        product.setProductSpace(propertyValueService.findByIdToNameString(product.getProductSpace().split(";")));
        model.addObject("product", product);
		/*
			猜你喜欢
		 */
        Product p = new Product();
        p.setProductBrand(product.getProductBrand());
        p.setProductStatus(5);
        Page<Product> mylove = productService.findByPaging(p, 0, 6, null, null);
        List<Product> content = new ArrayList<>();
        content.addAll(mylove.getContent());
        if (content.size() < 6) {
            p.setProductBrand(null);
            mylove = productService.findByPaging(p, 0, 6, null, null);
            content.addAll(mylove.getContent());
        }
        model.addObject("mylove", content);

		/*
			系列产品
		 */
        List<Product> seriesList = productService.findSeriesProduct(product.getProductSeries());
        model.addObject("seriesList", new JSONArray(seriesList).toString());
        model.setViewName("/MobileMall/product/productdetails");
        return model;
    }
}
