package com.findeng.mvc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.CapitalFlowDao;
import com.findeng.hibernate.entity.CapitalFlow;
import com.findeng.mvc.service.CapitalFlowService;

/**
 * 订单流水表Service层接口实现
 *
 * @author Alien
 */
@Service
@Transactional
public class CapitalFlowServiceImpl implements CapitalFlowService {

    @Autowired
    private CapitalFlowDao capitalFlowDao;

    @Override
    public Page<CapitalFlow> findByPaging(CapitalFlow cf, int offset, int limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "capitalFlowId";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        return capitalFlowDao.findAll(createSpecification(cf), pageReq);
    }

    /**
     * 创建流水表分页查询规范
     *
     * @param cf 查询的实体类
     * @return Specification<CapitalFlow>
     */
    public Specification<CapitalFlow> createSpecification(final CapitalFlow cf) {
        return new Specification<CapitalFlow>() {
            @Override
            public Predicate toPredicate(Root<CapitalFlow> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (cf != null) {
                    //流水金额
                    if (cf.getMoney() != null) {
                        Expression<Float> eps = root.get("money").as(Float.class);
                        Predicate term = cb.equal(eps, cf.getMoney());
                        arr.add(term);
                    }
                    //流水号
                    if (cf.getCapitalFlowId() != null && !cf.getCapitalFlowId().isEmpty()) {
                        Expression<String> eps = root.get("capitalFlowId").as(String.class);
                        Predicate term = cb.like(eps, "%" + cf.getCapitalFlowId() + "%");
                        arr.add(term);
                    }
                    //支付单号(微信支付单号)
                    if (cf.getWechatPayId() != null && !cf.getWechatPayId().isEmpty()) {
                        Expression<String> eps = root.get("wechatPayId").as(String.class);
                        Predicate term = cb.like(eps, "%" + cf.getWechatPayId() + "%");
                        arr.add(term);
                    }
                    //订单号(流水关联的订单号码)
                    if (cf.getOrderNumber() != null && !cf.getOrderNumber().isEmpty()) {
                        Expression<String> eps = root.get("orderNumber").as(String.class);
                        Predicate term = cb.like(eps, "%" + cf.getOrderNumber() + "%");
                        arr.add(term);
                    }
                    //用户昵称(流水关联人昵称)
                    if (cf.getUser() != null && cf.getUser().getUserNickname() != null && !cf.getUser().getUserNickname().isEmpty()) {
                        Expression<String> eps = root.get("user").get("userNickname").as(String.class);
                        Predicate term = cb.like(eps, "%" + cf.getUser().getUserNickname() + "%");
                        arr.add(term);
                    }
                    //流水类型
                    if (cf.getCapitalFlowType() != null) {
                        Expression<Integer> eps = root.get("capitalFlowType").as(Integer.class);
                        Predicate term = cb.equal(eps, cf.getCapitalFlowType());
                        arr.add(term);
                    }
                    //流水状态(流水是否结算完成0待结算，1结算成功，2结算失败)
                    if (cf.getSettlementStatus() != null) {
                        Expression<Integer> eps = root.get("settlementStatus").as(Integer.class);
                        Predicate term = cb.equal(eps, cf.getSettlementStatus());
                        arr.add(term);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }
}
