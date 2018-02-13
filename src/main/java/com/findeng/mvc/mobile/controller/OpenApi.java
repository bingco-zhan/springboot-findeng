package com.findeng.mvc.mobile.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.PropertyValue;
import com.findeng.mvc.serviceimpl.ProductServiceImpl;
import com.findeng.mvc.serviceimpl.PropertyValueServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class OpenApi {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private PropertyValueServiceImpl propertyValueServiceImpl;

    // 服务器地址
    @Value("${ServerPath}")
    private String ServerPath;
    // 网络环境普通产品缩略图路径
    @Value("${httpFile.ProductThumbnailSrc}")
    private String ProductThumbnailSrc;
    // 网络环境配灯系统产品缩略图路径
    @Value("${httpFile.CustomProductThumbnailSrc}")
    private String CustomProductThumbnailSrc;
    @Value("${httpFile.ProductImageSrc}")
    private String ProductImageSrc;

    /**
     * 获取系统图片路径
     */
    @GetMapping("/urlConfig")
    public String getUrlConfig() {
        JSONObject urlConfig = new JSONObject();
        urlConfig.put("ServerPath", ServerPath);
        urlConfig.put("ProductThumbnailSrc", ProductThumbnailSrc);
        urlConfig.put("CustomProductThumbnailSrc", CustomProductThumbnailSrc);
        urlConfig.put("ProductImageSrc", ProductImageSrc);
        return urlConfig.toString();
    }

    /**
     * 根据产品id获取产品信息
     *
     * @param productId 产品id
     */
    @GetMapping(value = "/product/{productid}")
    public String findProductById(@PathVariable int productid) {
        Product re = productServiceImpl.findById(productid);
        return new JSONObject(re).toString();
    }

    /**
     * 通过传入id获取产品属性
     */
    @GetMapping("/propertyValue")
    public List<PropertyValue> propertyValue(HttpSession session, @RequestParam("ids[]") int[] ids, @RequestParam int haveProduct) {
        return propertyValueServiceImpl.findByPropertyIdIn(ids, haveProduct);
    }
}
