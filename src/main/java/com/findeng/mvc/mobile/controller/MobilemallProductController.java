package com.findeng.mvc.mobile.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.model.MobileProductModel;
import com.findeng.mvc.service.MobileProductService;
import com.findeng.mvc.service.PropertyValueService;
import com.findeng.util.WebUtil;

@RestController
@RequestMapping("/mobilemall")
public class MobilemallProductController {

    @Autowired
    MobileProductService productService;

    @Autowired
    PropertyValueService propertyValueService;

    /**
     * 产品分页接口
     */
    @GetMapping("/productListAjax")
    public String productPagingList(HttpSession session, MobileProductModel pmodel) {
        Page<Product> paging = productService.findByPaging(pmodel);
        System.out.println(new JSONObject(pmodel));
        return WebUtil.resposeTableData(paging.getTotalElements(), paging.getContent()).toString();
    }

    /**
     * AJAX异步获取商品信息
     *
     * @param id
     */
    @GetMapping("/productAjax/{id}")
    public String findProductById(@PathVariable("id") Integer id) {
        Product product = productService.findByProductId(id);
        product.setProductType(propertyValueService.findById(Integer.parseInt(product.getProductType())).getPropertyValue());
        product.setProductMaterial(propertyValueService.findByIdToNameString(product.getProductMaterial().split(";")));
        product.setProductStyle(propertyValueService.findById(Integer.parseInt(product.getProductStyle())).getPropertyValue());
        product.setLight_Type(propertyValueService.findById(product.getLightType()).getPropertyValue());
        product.setProductSpace(propertyValueService.findByIdToNameString(product.getProductSpace().split(";")));
        return new JSONObject(product).toString();
    }
}
