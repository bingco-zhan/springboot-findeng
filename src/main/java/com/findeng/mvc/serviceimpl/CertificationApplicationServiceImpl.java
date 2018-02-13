package com.findeng.mvc.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.findeng.hibernate.dao.CertificationApplicationDao;
import com.findeng.hibernate.dao.UserDao;
import com.findeng.hibernate.entity.CertificationApplication;
import com.findeng.hibernate.entity.User;
import com.findeng.hibernate.entity.UserRole;
import com.findeng.mvc.service.CertificationApplicationService;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;

/**
 * 用户认证表service实现类
 *
 * @author Alien
 */
@Transactional
@Service
public class CertificationApplicationServiceImpl implements CertificationApplicationService {

    @Autowired
    private CertificationApplicationDao certificationApplicationDao;

    @Autowired
    private UserDao userDao;

    @Value("${systemFile.CertificationApplicationPicSrc}")
    private String certificationApplicationPicSrc;

    /**
     * 保存认证表对象
     *
     * @return
     */
    @Override
    public JSONObject save(CertificationApplication ce) {
        if (ce.getUserId() == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(150), "", null, null);
        User user = userDao.findOne(ce.getUserId());
        if (user == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(151), "", null, null);
        ce.setSubmitTime(new Timestamp(System.currentTimeMillis()));//设置提交时间
        ce.setCheckStatus(CertificationApplication.STATE_1);//设置审批状态为待审批
        certificationApplicationDao.save(ce);//保存认证信息表
        user.setCheckStatus(1);//设置用户认证状态为1-待审批
        user.setApplyId(ce.getApplyId());//设置用户关联的认证信息表id
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(2), "", null, null);
    }

    /**
     * 创建认证表分页查询规范
     *
     * @param user 查询的实体类
     * @return Specification<User>
     */
    public Specification<CertificationApplication> createSpecification(final CertificationApplication ce) {
        return new Specification<CertificationApplication>() {
            @Override
            public Predicate toPredicate(Root<CertificationApplication> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> arr = new ArrayList<>();
                //查询条件不为空
                if (ce != null) {

                    if (ce.getUserId() != null) {//匹配用户ID
                        Expression<Integer> eps = root.get("userId").as(Integer.class);
                        Predicate term = cb.equal(eps, ce.getUserId());
                        arr.add(term);
                    }

                    if (ce.getLegalPerson() != null) {//匹配真实姓名
                        Expression<String> eps = root.get("legalPerson").as(String.class);
                        Predicate term = cb.like(eps, "%" + ce.getLegalPerson() + "%");
                        arr.add(term);
                    }

                    if (ce.getCompanyName() != null) {//匹配公司名
                        System.out.println(ce.getCompanyName());
                        Expression<String> eps = root.get("companyName").as(String.class);
                        Predicate term = cb.like(eps, "%" + ce.getCompanyName() + "%");
                        arr.add(term);
                    }

                    if (ce.getRole() != null) {//匹配注册类型
                        Expression<Integer> eps = root.get("role").get("id").as(Integer.class);
                        Predicate term = cb.equal(eps, ce.getRole().getId());
                        arr.add(term);
                    }

                    if (ce.getCheckStatus() != null) {//匹配审批状态
                        Expression<Integer> eps = root.get("checkStatus").as(Integer.class);
                        Predicate term = cb.equal(eps, ce.getCheckStatus());
                        arr.add(term);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).getRestriction();
            }
        };
    }

    /**
     * 查询认证表并分页
     *
     * @param offset 偏移值
     * @param limit  查询长度
     * @return 用户实体list
     */
    @Override
    public Page<CertificationApplication> findByPaging(CertificationApplication ce, Integer offset, Integer limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "applyId";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<CertificationApplication> page = certificationApplicationDao.findAll(createSpecification(ce), pageReq);
        return page;
    }

    /**
     * 审批用户认证表
     */
    public JSONObject Application(int applyId, int checkStatus) {
        //查找认证表数据
        CertificationApplication ce = certificationApplicationDao.findOne(applyId);
        if (ce == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(152), "", null, null);
        if (ce.getCheckStatus() != 1) return WebUtil.resposeJSONObject(ReturnUtil.retParam(153), "", null, null);
        if (ce.getRole() == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(154), "", null, null);
        //查找被审批用户
        User user = userDao.findOne(ce.getUserId());
        if (user == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(155), "", null, null);
        //设置审批后数据
        ce.setCheckStatus(checkStatus);
        user.setApplyId(ce.getApplyId());//设置审批表ID
        user.setCheckStatus(checkStatus);//设置用户审批状态 2失败 3成功
        if (checkStatus == 2) {//如果审批不通过直接审批完成了
            userDao.save(user);
            return WebUtil.resposeJSONObject(ReturnUtil.retParam(3), "", null, null);
        }
        //设置user表数据
        UserRole role = new UserRole();
        role.setId(ce.getRole().getId());
        user.setRole(role);
        user.setCompanyName(ce.getCompanyName());
        user.setShortCompanyName(ce.getShortCompanyName());
        certificationApplicationDao.save(ce);
        userDao.save(user);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(3), "", null, null);
    }
}
