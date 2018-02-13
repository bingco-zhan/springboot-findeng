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

import com.findeng.hibernate.dao.CustomProductDao;
import com.findeng.hibernate.entity.CustomProduct;
import com.findeng.mvc.service.CustomProductService;

@Transactional
@Service
public class CustomProductServiceImpl implements CustomProductService {

    @Autowired
    private CustomProductDao customProductDao;

    /**
     * 通过userid字段获取经销商产品
     *
     * @param userid 经销商id
     * @param item   获取条数
     * @return List 商品列表
     */
    @Override
    public List<CustomProduct> findByUserId(int userid, int item) {
        List<CustomProduct> list = customProductDao.findByUserId(userid, item);
        return list;
    }

    /**
     * 查询经销商产品并分页
     *
     * @param customProduct 查询的产品实体
     * @param offset        页码
     * @param limit         单页条数
     * @param field         排序字段
     * @param sort          排序方式
     */
    @Override
    public Page<CustomProduct> findByPaging(CustomProduct customProduct, int offset, int limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "productId";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        return customProductDao.findAll(createSpecification(customProduct), pageReq);
    }

    /**
     * 创建产品分页查询规范
     *
     * @param customProduct 查询的实体类
     * @return Specification<CustomProduct>
     */
    public Specification<CustomProduct> createSpecification(final CustomProduct customProduct) {
        return new Specification<CustomProduct>() {

            @Override
            public Predicate toPredicate(Root<CustomProduct> root, CriteriaQuery<?> query, CriteriaBuilder cbr) {
                List<Predicate> array = new ArrayList<>();
                if (customProduct != null) {

                    if (customProduct.getUserId() != null && customProduct.getUserId() != 0) {
                        Expression<Integer> expression = root.get("userId").as(Integer.class);
                        Predicate equal = cbr.equal(expression, customProduct.getUserId());
                        array.add(equal);
                    }

                    if (customProduct.getProductStatus() != null && customProduct.getProductStatus() != 0) {
                        Expression<Integer> expression = root.get("productStatus").as(Integer.class);
                        Predicate equal = cbr.equal(expression, customProduct.getProductStatus());
                        array.add(equal);
                    }
                }
                return query.distinct(true).where(array.toArray(new Predicate[array.size()])).getRestriction();
            }
        };
    }

}
