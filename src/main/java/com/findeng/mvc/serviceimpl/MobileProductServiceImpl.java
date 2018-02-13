package com.findeng.mvc.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.findeng.hibernate.dao.ProductDao;
import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.model.MobileProductModel;
import com.findeng.mvc.service.MobileProductService;

@Service
public class MobileProductServiceImpl implements MobileProductService {

    @Autowired
    ProductDao productDao;

    /**
     * 产品分页
     *
     * @param pmodel 商品属性装箱
     */
    public Page<Product> findByPaging(MobileProductModel pmodel) {
        PageRequest pageble = new PageRequest(pmodel.getOffset() - 1, pmodel.getLimit(), createSort(pmodel));
        return productDao.findAll(createSpecification(pmodel), pageble);
    }

    private Sort createSort(MobileProductModel pmodel) {
        if (pmodel.getOk() == null || pmodel.getOk().isEmpty()) {
            pmodel.setOk("productId");
        }
        Sort.Direction v = Sort.Direction.DESC;
        if (pmodel.getOv() != null && !pmodel.getOv().isEmpty()) {
            if (pmodel.getOv().equalsIgnoreCase("ASC")) {
                v = Sort.Direction.ASC;
            }
        }
        System.out.println(pmodel.getOk() + "," + pmodel.getOv());
        return new Sort(v, pmodel.getOk());
    }

    /**
     * 根据ID查询商品信息
     *
     * @param productId
     */
    @Override
    public Product findByProductId(Integer productId) {
        return productDao.findOne(productId);
    }

    public Specification<Product> createSpecification(final MobileProductModel pmodel) {

        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> array = new ArrayList<>();

                if (pmodel != null) {
                    // 标签 ProductTag
                    if (pmodel.getProductTag() != null && !pmodel.getProductTag().isEmpty()) {
                        Expression<String> exp = root.get("productTag").as(String.class);
                        array.add(cb.equal(exp, pmodel.getProductTag()));
                    }
                    if (pmodel.getLike() != null && !pmodel.getLike().isEmpty()) {
                        Expression<String> exp = root.get("productName").as(String.class);
                        array.add(cb.like(exp, "%" + pmodel.getLike() + "%"));
                    }
                    // 风格 productStyle
                    addIn(pmodel.getStyles(), "productStyle", array, root, cb);
                    // 类型 productType
                    addIn(pmodel.getTypes(), "productType", array, root, cb);
                    // 空间 productSpace
                    addLike(pmodel.getRooms(), "productSpace", array, root, cb);
                    // 材质 productMaterial
                    addLike(pmodel.getMaterials(), "productMaterial", array, root, cb);
                    // 形状 product_shape
                    addIn(pmodel.getShapes(), "productShape", array, root, cb);
                    // 层数 productPlies
                    addIn(pmodel.getPlies(), "productPlies", array, root, cb);
                    // 直径 productDiameter
                    addBetween(pmodel.getDiameters(), "productDiameter", array, root, cb);
                    // 长度 productLength
                    addBetween(pmodel.getLengths(), "productLength", array, root, cb);
                    // 高度 productWidth
                    addBetween(pmodel.getWidths(), "productWidth", array, root, cb);
                    // 价格 retailPrice
                    addBetween(pmodel.getPrices(), "retailPrice", array, root, cb);
                    // 光源类型 productType
                    addIn(pmodel.getLightTypes(), "lightType", array, root, cb);
                }

                Expression<Integer> exp = root.get("productStatus").as(Integer.class);
                array.add(cb.equal(exp, 5));

                return query.where(array.toArray(new Predicate[array.size()])).getRestriction();
            }
        };
    }

    private void addIn(List<Integer> value, String property, List<Predicate> array, Root<Product> root, CriteriaBuilder cb) {
        if (value != null && value.size() > 0) {
            Expression<Integer> exp = root.get(property).as(Integer.class);
            if (value.size() == 1) {
                array.add(cb.equal(exp, value.get(0)));
            } else {
                CriteriaBuilder.In<Integer> in = cb.in(exp);
                for (int x : value) {
                    in.value(x);
                }
                array.add(in);
            }
        }
    }

    private void addLike(List<String> value, String property, List<Predicate> array, Root<Product> root, CriteriaBuilder cb) {
        if (value != null && value.size() > 0) {
            Expression<String> exp = root.get(property).as(String.class);
            List<Predicate> likes = new ArrayList<>();
            for (String x : value) {
                likes.add(cb.like(exp, "%" + x + "%"));
            }
            array.add(cb.or(likes.toArray(new Predicate[likes.size()])));
        }
    }

    private void addBetween(List<String> value, String property, List<Predicate> array, Root<Product> root, CriteriaBuilder cb) {
        if (value != null && value.size() > 0) {
            Expression<Integer> exp = root.get("retailPrice").as(Integer.class);
            StringBuilder reg = new StringBuilder();
            for (String r : value) {
                reg.append(r).append(",");
            }
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(reg);
            List<Integer> arr = new ArrayList<>();
            while (m.find()) {
                arr.add(Integer.parseInt(m.group()));
            }
            Collections.sort(arr);
            if (arr.size() > 1) {
                array.add(cb.between(exp, arr.get(0), arr.get(arr.size() - 1)));
            } else {
                array.add(cb.ge(exp, arr.get(0)));
            }
        }
    }
}
