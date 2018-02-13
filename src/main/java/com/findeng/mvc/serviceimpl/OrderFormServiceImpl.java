package com.findeng.mvc.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.OrderFormDao;
import com.findeng.hibernate.entity.OrderForm;
import com.findeng.hibernate.model.OrderModel;
import com.findeng.mvc.service.OrderFormService;
import com.findeng.mvc.service.OrderItemService;
import com.findeng.util.WebUtil;

/**
 * 订单头Service实现类
 *
 * @author Alien
 */
@Transactional
@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    private OrderFormDao orderFormDao;

    @Autowired
    private OrderItemService orderItemService;

    @Override
    public OrderForm save(OrderForm of) {
        return orderFormDao.save(of);
    }

    @Override
    public JSONObject findByPaging(OrderForm of, Integer offset, Integer limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "orderTime";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<OrderForm> ofList = orderFormDao.findAll(createSpecification(of), pageReq);
        List<OrderModel> omList = new ArrayList<>();
        for (Iterator<OrderForm> iter = ofList.iterator(); iter.hasNext(); ) {
            OrderForm ofTemp = (OrderForm) iter.next();
            OrderModel om = new OrderModel();
            om.setOrderForm(ofTemp);
            om.setOrderItemList(orderItemService.findByOrderNumber(ofTemp.getOrderNumber()));
            omList.add(om);
        }
        return WebUtil.resposeTableData(ofList.getTotalElements(), omList);
    }

    /**
     * 创建订单头分页查询规范
     *
     * @param OrderForm 查询的实体类
     * @return Specification<OrderForm>
     */
    public Specification<OrderForm> createSpecification(final OrderForm of) {
        return new Specification<OrderForm>() {
            @Override
            public Predicate toPredicate(Root<OrderForm> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (of != null) {
                    //订单号
                    if (of.getOrderNumber() != null && !of.getOrderNumber().isEmpty()) {
                        Expression<String> eps = root.get("orderNumber").as(String.class);
                        Predicate term = cb.like(eps, "%" + of.getOrderNumber() + "%");
                        arr.add(term);
                    }

                    //买家
                    if (of.getBuyer() != null && of.getBuyer().getUserId() != null) {
                        Expression<Integer> eps = root.get("buyer").get("userId").as(Integer.class);
                        Predicate term = cb.equal(eps, of.getBuyer().getUserId());
                        arr.add(term);
                    }

                    //销售厂家
                    if (of.getSeller() != null && of.getSeller().getUserId() != null) {
                        Expression<Integer> eps = root.get("seller").get("userId").as(Integer.class);
                        Predicate term = cb.equal(eps, of.getSeller().getUserId());
                        arr.add(term);
                    }

                    //销售厂家简称
                    if (of.getSeller() != null && of.getSeller().getShortCompanyName() != null && !of.getSeller().getShortCompanyName().isEmpty()) {
                        Expression<String> eps = root.get("seller").get("shortCompanyName").as(String.class);
                        Predicate term = cb.like(eps, "%" + of.getSeller().getShortCompanyName() + "%");
                        arr.add(term);
                    }

                    //上级用户
                    if (of.getUpUser() != null && of.getUpUser().getUserId() != null) {
                        Expression<Integer> eps = root.get("upUser").get("userId").as(Integer.class);
                        Predicate term = cb.equal(eps, of.getUpUser().getUserId());
                        arr.add(term);
                    }

                    //订单状态
                    if (of.getOrderStatus() != null) {
                        Expression<Integer> eps = root.get("orderStatus").as(Integer.class);
                        Predicate term = cb.equal(eps, of.getOrderStatus());
                        arr.add(term);
                    }

                    //物流单号
                    if (of.getTransportNumber() != null && !of.getTransportNumber().isEmpty()) {
                        Expression<String> eps = root.get("transportNumber").as(String.class);
                        Predicate term = cb.like(eps, "%" + of.getTransportNumber() + "%");
                        arr.add(term);
                    }

                    if (of.getIfHappenRefund() != null && of.getIfHappenReturn() != null) {//是否发生退款或退货
                        Expression<Integer> eps = root.get("ifHappenRefund").as(Integer.class);
                        Expression<Integer> eps1 = root.get("ifHappenReturn").as(Integer.class);
                        Predicate term = cb.equal(eps, of.getIfHappenRefund());
                        Predicate term1 = cb.equal(eps1, of.getIfHappenReturn());
                        arr.add(cb.or(term, term1));
                    } else if (of.getIfHappenReturn() != null) {//是否发生退货
                        Expression<Integer> eps = root.get("ifHappenReturn").as(Integer.class);
                        Predicate term = cb.equal(eps, of.getIfHappenReturn());
                        arr.add(term);
                    } else if (of.getIfHappenRefund() != null) {//是否发生退款
                        Expression<Integer> eps = root.get("ifHappenRefund").as(Integer.class);
                        Predicate term = cb.equal(eps, of.getIfHappenRefund());
                        arr.add(term);
                    }

                    //加入待发货标识 0未发货 1部分发货 2全部发货 3不等于未发货 4不等于全部发货
                    if (of.getStockedFlag() != null) {
                        Expression<Integer> eps = root.get("stockedFlag").as(Integer.class);
                        Predicate term = null, term1 = null;
                        if (of.getStockedFlag() == 3) {
                            term = cb.notEqual(eps, 0);
                            term1 = cb.isNotNull(eps);
                        }
                        if (of.getStockedFlag() == 4) {
                            term = cb.notEqual(eps, 2);
                        } else {
                            term = cb.equal(eps, of.getStockedFlag());
                        }
                        arr.add(term);
                        if (term1 != null) arr.add(term);
                    }

                    //今日待发标识
                    if (of.getPrepareSendFlag() != null) {
                        Expression<Integer> eps = root.get("prepareSendFlag").as(Integer.class);
                        Predicate term = null, term1 = null;
                        if (of.getPrepareSendFlag() == 3) {
                            term = cb.notEqual(eps, 0);
                            term1 = cb.isNotNull(eps);
                        } else {
                            term = cb.equal(eps, of.getPrepareSendFlag());
                        }
                        arr.add(term);
                        if (term1 != null) arr.add(term);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }
}
