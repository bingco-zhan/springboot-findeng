package com.findeng.mvc.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.hibernate.entity.CustomProduct;
import com.findeng.mvc.serviceimpl.CustomProductServiceImpl;
import com.findeng.util.WebUtil;

/**
 * 经销商商品管理
 *
 * @author Alien
 */
@RestController
@RequestMapping(value = "/admin/api")
public class DealersProductController {

    @Autowired
    private CustomProductServiceImpl customProductServiceImpl;

    /**
     * 读取系列分页
     */
    @GetMapping("/customProduct")
    public String productSeriesPagingList(HttpSession session, CustomProduct customProduct,
                                          @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                          @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                          @RequestParam(value = "field", required = false) String field,
                                          @RequestParam(value = "sort", required = false) String sort) {
        //User user = (User)session.getAttribute("user");
        //customProduct.setUserId(user.getUserId());//设置产品拥有者
        Page<CustomProduct> page = customProductServiceImpl.findByPaging(customProduct, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }
}
