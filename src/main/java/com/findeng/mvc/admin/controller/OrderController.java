package com.findeng.mvc.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findeng.hibernate.entity.CapitalFlow;
import com.findeng.hibernate.entity.OrderForm;
import com.findeng.hibernate.entity.WithdrawalApplication;
import com.findeng.mvc.service.OrderFormService;
import com.findeng.mvc.serviceimpl.CapitalFlowServiceImpl;
import com.findeng.mvc.serviceimpl.WithdrawalApplicationServiceImpl;
import com.findeng.util.WebUtil;

@RestController
@RequestMapping(value = "/admin/api")
public class OrderController {

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private CapitalFlowServiceImpl capitalFlowServiceImpl;

    @Autowired
    private WithdrawalApplicationServiceImpl withdrawalApplicationServiceImpl;

    /**
     * 读取订单分页
     */
    @GetMapping("/orderForm")
    public String orderFormPagingList(HttpSession session, OrderForm of,
                                      @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                      @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                      @RequestParam(value = "field", required = false) String field,
                                      @RequestParam(value = "sort", required = false) String sort) {
        return orderFormService.findByPaging(of, offset, limit, field, sort).toString();
    }

    /**
     * 获取流水表分页
     */
    @GetMapping("/capitalFlow")
    public String capitalFlowPagingList(HttpSession session, CapitalFlow cf,
                                        @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        @RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort) {
        Page<CapitalFlow> page = capitalFlowServiceImpl.findByPaging(cf, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }

    /**
     * 获取提成申请表分页
     */
    @GetMapping("/withdrawalApplication")
    public String withdrawalApplicationPagingList(HttpSession session, WithdrawalApplication wa,
                                                  @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                  @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                  @RequestParam(value = "field", required = false) String field,
                                                  @RequestParam(value = "sort", required = false) String sort) {
        Page<WithdrawalApplication> page = withdrawalApplicationServiceImpl.findByPaging(wa, offset, limit, field, sort);
        return WebUtil.resposeTableData(page.getTotalElements(), page.getContent()).toString();
    }
}
