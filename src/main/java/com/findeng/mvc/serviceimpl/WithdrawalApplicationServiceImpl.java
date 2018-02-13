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

import com.findeng.hibernate.dao.WithdrawalApplicationDao;
import com.findeng.hibernate.entity.WithdrawalApplication;
import com.findeng.mvc.service.WithdrawalApplicationService;

/**
 * 提现申请表Service实现类
 *
 * @author Alien
 */
@Service
@Transactional
public class WithdrawalApplicationServiceImpl implements WithdrawalApplicationService {

    @Autowired
    private WithdrawalApplicationDao withdrawalApplicationDao;

    @Override
    public Page<WithdrawalApplication> findByPaging(WithdrawalApplication wa, int offset, int limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "id";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<WithdrawalApplication> page = withdrawalApplicationDao.findAll(createSpecification(wa), pageReq);
        return page;
    }

    /**
     * 创建用户分页查询规范
     *
     * @param user 查询的实体类
     * @return Specification<User>
     */
    public Specification<WithdrawalApplication> createSpecification(final WithdrawalApplication wa) {
        return new Specification<WithdrawalApplication>() {
            @Override
            public Predicate toPredicate(Root<WithdrawalApplication> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (wa != null) {
                    if (wa.getId() > 0) {
                        Expression<Integer> eps = root.get("id").as(Integer.class);
                        Predicate term = cb.equal(eps, wa.getId());
                        arr.add(term);
                    }

                    //提现申请人ID
                    if (wa.getLaunchUser() != null && wa.getLaunchUser().getUserId() != null) {
                        Expression<Integer> eps = root.get("launchUser").get("userId").as(Integer.class);
                        Predicate term = cb.equal(eps, wa.getLaunchUser().getUserId());
                        arr.add(term);
                    }

                    //提现申请人昵称
                    if (wa.getLaunchUser() != null && wa.getLaunchUser().getUserNickname() != null && !wa.getLaunchUser().getUserNickname().isEmpty()) {
                        Expression<String> eps = root.get("launchUser").get("userNickname").as(String.class);
                        Predicate term = cb.like(eps, "%" + wa.getLaunchUser().getUserNickname() + "%");
                        arr.add(term);
                    }

                    if (wa.getWithdrawalType() != null && wa.getWithdrawalType() > 0) {
                        Expression<Integer> eps = root.get("withdrawalType").as(Integer.class);
                        Predicate term = cb.equal(eps, wa.getWithdrawalType());
                        arr.add(term);
                    }

                    if (wa.getWithdrawalType() != null && wa.getMoney() > 0) {
                        Expression<Float> eps = root.get("money").as(Float.class);
                        Predicate term = cb.equal(eps, wa.getMoney());
                        arr.add(term);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }
}
