package com.findeng.mvc.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.hibernate.entity.Carousel;
import com.findeng.hibernate.entity.DiscountApplication;
import com.findeng.hibernate.entity.WelcomePic;
import com.findeng.mvc.serviceimpl.CarouselServiceImpl;
import com.findeng.mvc.serviceimpl.DiscountApplicationServiceImpl;
import com.findeng.mvc.serviceimpl.WelcomePicServiceImpl;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;

@RestController
@RequestMapping(value = "/admin/api")
public class BuyerController {

    @Autowired
    private CarouselServiceImpl carouselServiceImpl;

    @Autowired
    private WelcomePicServiceImpl welcomePicServiceImpl;

    @Autowired
    private DiscountApplicationServiceImpl discountApplicationServiceImpl;

    /**
     * 添加轮播图
     */
    @PostMapping("/carousel")
    public String saveCarousel(HttpSession session, HttpServletRequest req, HttpServletResponse rep) {
        Carousel ca = carouselServiceImpl.generateCarousel(req.getParameter("imgData"), req.getParameter("link"));
        return carouselServiceImpl.save(ca).toString();
    }

    /**
     * 修改轮播图
     */
    @PutMapping("/carousel")
    public String updataCarousel(HttpSession session, HttpServletRequest req, HttpServletResponse rep) {
        int id = Integer.valueOf(req.getParameter("id"));
        String link = req.getParameter("link");
        return carouselServiceImpl.updata(id, req.getParameter("imgData"), link).toString();
    }

    /**
     * 删除轮播图
     *
     * @return
     */
    @DeleteMapping(value = "/carousel/{id}")
    public String deleteCarousel(HttpSession session, @PathVariable int id) {
        return carouselServiceImpl.delete(id).toString();
    }

    /**
     * 获取欢迎图
     *
     * @return
     */
    @GetMapping(value = "/welcomepic")
    public String getWelcomePic(HttpSession session) {
        WelcomePic wc = welcomePicServiceImpl.getCurrentWelcomePic();
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", new JSONObject(wc), null).toString();
    }

    /**
     * 删除欢迎图
     *
     * @return
     */
    @DeleteMapping(value = "/welcomepic/{id}")
    public String deleteWelcomePic(HttpSession session, @PathVariable int id) {
        welcomePicServiceImpl.delete(id);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null).toString();
    }

    /**
     * 添加欢迎图
     */
    @PostMapping("/welcomepic")
    public String saveWelcomePic(HttpSession session, HttpServletRequest req, HttpServletResponse rep) {
        WelcomePic wp = welcomePicServiceImpl.generateWelcomePic(req.getParameter("imgData"), req.getParameter("link"));
        welcomePicServiceImpl.save(wp);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", new JSONObject(wp), null).toString();
    }

    /**
     * 获取折扣申请列表
     */
    @GetMapping(value = "/discountApplication")
    public String discountApplicationPagingList(HttpSession session, DiscountApplication da,
                                                @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                @RequestParam(value = "field", required = false) String field,
                                                @RequestParam(value = "sort", required = false) String sort) {
        Page<DiscountApplication> page = discountApplicationServiceImpl.findByPaging(da, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }

    /**
     * 审批折扣申请列表
     */
    @PutMapping(value = "/discountApplication/approval")
    public String discountApplication(HttpSession session,
                                      @RequestParam(value = "id", required = true) int id,
                                      @RequestParam(value = "status", required = true) int status) {
        return discountApplicationServiceImpl.applicationDiscount(id, status).toString();
    }
}
