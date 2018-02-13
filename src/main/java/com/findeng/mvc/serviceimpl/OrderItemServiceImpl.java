package com.findeng.mvc.serviceimpl;

import java.util.ArrayList;
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

import com.findeng.hibernate.dao.OrderItemDao;
import com.findeng.hibernate.entity.OrderItem;
import com.findeng.mvc.service.OrderItemService;
import com.findeng.util.WebUtil;

/**
 * 订单项Service实现类
 *
 * @author Alien
 */
@Transactional
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public OrderItem save(OrderItem oi) {
        return orderItemDao.save(oi);
    }

    @Override
    public List<OrderItem> findByOrderNumber(String orderNumber) {
        return orderItemDao.findByOrderNumber(orderNumber);
    }

    @Override
    public JSONObject findByPaging(OrderItem oi, Integer offset, Integer limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "orderItemId";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<OrderItem> oiList = orderItemDao.findAll(createSpecification(oi), pageReq);
        return WebUtil.resposeTableData(oiList.getTotalElements(), oiList.getContent());
    }

    /**
     * 创建订单项分页查询规范
     *
     * @param oi 查询的实体类
     * @return Specification<OrderItem>
     */
    public Specification<OrderItem> createSpecification(final OrderItem oi) {
        return new Specification<OrderItem>() {
            @Override
            public Predicate toPredicate(Root<OrderItem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (oi != null) {
                    if (oi.getOrderNumber() != null && !oi.getOrderNumber().isEmpty()) {
                        Expression<String> eps = root.get("orderNumber").as(String.class);
                        Predicate term = cb.like(eps, "%" + oi.getOrderNumber() + "%");
                        arr.add(term);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }
}
