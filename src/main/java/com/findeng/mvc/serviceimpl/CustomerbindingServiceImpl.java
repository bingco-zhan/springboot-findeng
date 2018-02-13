package com.findeng.mvc.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.findeng.hibernate.dao.CustomerbindingDao;
import com.findeng.hibernate.entity.Customerbinding;
import com.findeng.hibernate.entity.User;
import com.findeng.mvc.service.CustomerbindingService;
import com.findeng.util.WebUtil;

@Transactional
@Service
public class CustomerbindingServiceImpl implements CustomerbindingService {

    @Autowired
    private CustomerbindingDao customerbindingDao;

    @Override
    public Map<String, Object> save(User apply, User unbundling) {
        try {
            Customerbinding customerbinding = new Customerbinding();
            customerbinding.setApply(apply);
            customerbinding.setUnbundling(unbundling);
            customerbinding.setCreateTime(new Timestamp(System.currentTimeMillis()));
            customerbinding.setStatus(Customerbinding.STATUS_0);
            System.out.println(new JSONObject(customerbinding));
            customerbindingDao.save(customerbinding);
            return WebUtil.resposeAjax(true, "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.resposeAjax(false, "提交失敗！");
        }
    }

    @Override
    public Page<Customerbinding> findCustomerBindingList(Customerbinding customerbinding, Integer offset,
                                                         Integer limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "createTime";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<Customerbinding> page = customerbindingDao.findAll(createSpecification(customerbinding), pageReq);
        return page;
    }

    /**
     * 创建分页查询规范
     *
     * @param customerbinding 查询的实体类
     * @return Specification<Customerbinding>
     */
    public Specification<Customerbinding> createSpecification(final Customerbinding customerbinding) {
        return new Specification<Customerbinding>() {
            @Override
            public Predicate toPredicate(Root<Customerbinding> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (customerbinding != null) {
                    if (customerbinding.getStatus() != null) {
                        Expression<Integer> eps = root.get("status").as(Integer.class);
                        Predicate equal = cb.equal(eps, customerbinding.getStatus());
                        arr.add(equal);
                    }
                    User apply = customerbinding.getApply();
                    if (apply != null) {
                        if (apply.getUserNickname() != null && !apply.getUserNickname().isEmpty()) {
                            Expression<String> eps = root.get("apply").get("userNickname").as(String.class);
                            Predicate like = cb.like(eps, "%" + apply.getUserNickname() + "%");
                            arr.add(like);
                        }
                    }
                    User unbundling = customerbinding.getUnbundling();
                    if (unbundling != null) {
                        if (unbundling.getUserNickname() != null && !unbundling.getUserNickname().isEmpty()) {
                            Expression<String> eps = root.get("unbundling").get("userNickname").as(String.class);
                            Predicate like = cb.like(eps, "%" + unbundling.getUserNickname() + "%");
                            arr.add(like);
                        }
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }

    /**
     * 审核用户绑定
     *
     * @param id      表ID
     * @param keyword 状态码
     * @return
     */
    @Override
    public Map<String, Object> update(Integer id, Integer status) {
        try {
            Customerbinding customerbinding = customerbindingDao.findById(id);
            if (customerbinding == null) return WebUtil.resposeAjax(false, "数据不存在!");
            if (customerbinding.getStatus() == Customerbinding.STATUS_2) {
                customerbinding.getUnbundling().setUpperUserId(customerbinding.getApply().getUserId());
            }
            customerbinding.setEndTime(new Timestamp(System.currentTimeMillis()));
            customerbinding.setStatus(status);
            return WebUtil.resposeAjax(true, "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.resposeAjax(false, "提交成功...");
        }
    }

}
