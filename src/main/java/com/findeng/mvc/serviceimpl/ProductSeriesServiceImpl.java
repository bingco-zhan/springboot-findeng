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

import com.findeng.hibernate.dao.ProductSeriesDao;
import com.findeng.hibernate.entity.ProductSeries;
import com.findeng.mvc.service.ProductSeriesService;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;

@Service
public class ProductSeriesServiceImpl implements ProductSeriesService {

    @Autowired
    private ProductSeriesDao productSeriesDao;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Override
    public Page<ProductSeries> findByPaging(ProductSeries productSeries, Integer offset, Integer limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "id";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<ProductSeries> productSeriesList = productSeriesDao.findAll(createSpecification(productSeries), pageReq);
        return productSeriesList;
    }

    /**
     * 创建分页查询规范
     *
     * @param productSeries 查询的实体类
     * @return Specification<ProductSeries>
     */
    public Specification<ProductSeries> createSpecification(final ProductSeries productSeries) {
        return new Specification<ProductSeries>() {
            @Override
            public Predicate toPredicate(Root<ProductSeries> root, CriteriaQuery<?> query, CriteriaBuilder cbr) {
                List<Predicate> arr = new ArrayList<>();
                if (productSeries != null) {

                    //系列ID查询
                    if (productSeries.getId() != null) {
                        Expression<Integer> expression = root.get("id").as(Integer.class);
                        Predicate equal = cbr.equal(expression, productSeries.getId());
                        arr.add(equal);
                    }

                    //系列拥有者ID查询
                    if (productSeries.getUserId() != null && productSeries.getUserId() != 0) {
                        Expression<Integer> expression = root.get("userId").as(Integer.class);
                        Predicate equal = cbr.equal(expression, productSeries.getUserId());
                        arr.add(equal);
                    }

                    //系列名查询
                    if (productSeries.getSeriesName() != null && !productSeries.getSeriesName().isEmpty()) {
                        Expression<String> expression = root.get("seriesName").as(String.class);
                        Predicate equal = cbr.like(expression, "%" + productSeries.getSeriesName() + "%");
                        arr.add(equal);
                    }
                }
                return query.where(arr.toArray(new Predicate[arr.size()])).distinct(true).getRestriction();
            }
        };
    }

    public List<ProductSeries> findSelectData(int userId) {
        return productSeriesDao.findByUserId(userId);
    }

    @Override
    public ProductSeries save(ProductSeries productSeries) {
        return productSeriesDao.save(productSeries);
    }

    @Override
    public JSONObject delete(int id) {
        int size = productServiceImpl.countBySeriesId(id);
        if (size > 0) {
            return WebUtil.resposeJSONObject(ReturnUtil.retParam(400), "", null, null);
        }
        productSeriesDao.delete(id);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    @Override
    public ProductSeries findById(int id) {
        return productSeriesDao.findOne(id);
    }

}
