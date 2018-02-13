package com.findeng.mvc.serviceimpl;

import java.sql.Timestamp;
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

import com.findeng.hibernate.dao.DiscountApplicationDao;
import com.findeng.hibernate.entity.DiscountApplication;
import com.findeng.mvc.service.DiscountApplicationService;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;

/**
 * 折扣申请表Service层实现类
 *
 * @author Alien
 */
@Transactional
@Service
public class DiscountApplicationServiceImpl implements DiscountApplicationService {

    @Autowired
    private DiscountApplicationDao discountApplicationDao;

    /**
     * 通过id查找折扣申请
     *
     * @param id 折扣申请id
     */
    @Override
    public DiscountApplication findById(int id) {
        return discountApplicationDao.findOne(id);
    }

    /**
     * 保存折扣申请
     *
     * @param da 折扣申请实体类
     */
    @Override
    public DiscountApplication save(DiscountApplication da) {
        return discountApplicationDao.save(da);
    }

    /**
     * 删除折扣申请
     *
     * @param id 需要删除的折扣申请id
     */
    public JSONObject delete(int id) {
        discountApplicationDao.delete(id);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(4), "", null, null);
    }

    /**
     * 创建折扣申请分页查询规范
     *
     * @param da 查询的实体类
     * @return Specification<DiscountApplication>
     */
    public Specification<DiscountApplication> createSpecification(final DiscountApplication da) {
        return new Specification<DiscountApplication>() {
            @Override
            public Predicate toPredicate(Root<DiscountApplication> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (da != null) {
                    if (da.getId() != null && da.getId() != 0) {
                        Expression<Integer> eps = root.get("id").as(Integer.class);
                        Predicate term = cb.equal(eps, da.getId());
                        arr.add(term);
                    }

                    //折扣申请人ID
                    if (da.getUser() != null && da.getUser().getUserId() != null) {
                        Expression<Integer> eps = root.get("user").get("userId").as(Integer.class);
                        Predicate term = cb.equal(eps, da.getUser().getUserId());
                        arr.add(term);
                    }

                    //折扣申请人微信昵称
                    if (da.getUser() != null && da.getUser().getUserNickname() != null && !da.getUser().getUserNickname().isEmpty()) {
                        Expression<String> eps = root.get("user").get("userNickname").as(String.class);
                        Predicate term = cb.like(eps, "%" + da.getUser().getUserNickname() + "%");
                        arr.add(term);
                    }

                    if (da.getStatus() != null) {
                        Expression<Integer> eps = root.get("status").as(Integer.class);
                        Predicate term = cb.equal(eps, da.getStatus());
                        arr.add(term);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }

    /**
     * 查询折扣并分页
     *
     * @param offset 偏移值
     * @param limit  查询长度
     * @return JSONObject
     */
    @Override
    public Page<DiscountApplication> findByPaging(DiscountApplication da, Integer offset, Integer limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "id";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<DiscountApplication> page = discountApplicationDao.findAll(createSpecification(da), pageReq);
        return page;
    }

    /**
     * 审批折扣申请
     */
    public JSONObject applicationDiscount(int id, int status) {
        DiscountApplication da = findById(id);
        if (da == null) {
            return WebUtil.resposeJSONObject(ReturnUtil.retParam(200), "", null, null);
        } else {
            da.setStatus(status);
            da.setCheckTime(new Timestamp(System.currentTimeMillis()));
            return WebUtil.resposeJSONObject(ReturnUtil.retParam(3), "", null, null);
        }
    }
}
