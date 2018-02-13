package com.findeng.mvc.serviceimpl;

import java.io.File;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeng.hibernate.dao.ProductDao;
import com.findeng.hibernate.entity.Product;
import com.findeng.hibernate.entity.ProductSeries;
import com.findeng.hibernate.entity.User;
import com.findeng.mvc.service.ProductService;
import com.findeng.util.CommonUtil;
import com.findeng.util.ImageUtil;
import com.findeng.util.ReturnUtil;
import com.findeng.util.WebUtil;

/**
 * 产品信息Service层实现
 *
 * @author Alien
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Value("${systemFile.ProductImageSrc}")
    private String ProductImageSrc;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PropertyValueServiceImpl propertyValueServiceImpl;

    /**
     * 保存产品方法
     */
    public Product save(Product product) {
        return productDao.save(product);
    }

    /**
     * 删除产品方法
     */
    public void delete(int productId) {
        productDao.delete(productId);
    }

    /**
     * 根据产品id查询产品
     *
     * @return Product
     */
    public Product findById(int id) {
        return productDao.findOne(id);
    }

    /**
     * 添加产品
     *
     * @param user    添加产品的用户
     * @param product 添加的产品资料
     */
    @Transactional
    public JSONObject addProduct(User user, Product product) {
        product.setCreatTime(new Timestamp(System.currentTimeMillis()));//产品创建时间
        product.setProductBrand(user.getShortCompanyName());//上传产品的厂家简称
        product.setProductName(generateProductName(user, product));//设置产品名
        product.setProductAliasName(generateProductAliasName(product));//设置产品名
        product.setProductSales(0);//设置销量
        product.setProductStatus(Product.STATE_2);//设置审批状态为待审批
        if (product.getUserId() == null) {//如果没有传入拥有者ID使用登录者ID作为所有者
            product.setUserId(user.getUserId());
            product.setProductBrand(user.getShortCompanyName());
        }
        //计算批发价和零售价
        float oup = product.getOriginUnitPrice();//出厂价
        float up = (float) Math.ceil((oup / 0.85));//批发价
        if ((up % 2) > 0) up++;//如果批发价为单数取整数
        float rp = up * (float) 2.5;//零售价
        product.setUnitPrice(up);
        product.setRetailPrice(rp);

        product = save(product);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", new JSONObject(product), null);
    }

    /**
     * 生成产品名方法（格式是风格+厂家简拼+型号+类型）
     *
     * @param user    厂家用户实体类
     * @param product 产品实体对象
     */
    public String generateProductName(User user, Product product) {
        String code = product.getProductCode();//产品型号
        Integer style = Integer.parseInt(product.getProductStyle());//产品风格
        Integer type = Integer.parseInt(product.getProductType());//产品类型
        String abbreviation = user.getAbbreviation();//厂家简拼
        String ProductName =
                (style == null ? "" : propertyValueServiceImpl.findById(style).getPropertyValue()) +
                        (abbreviation == null ? "" : abbreviation) +
                        (code == null ? "" : code) +
                        (type == null ? "" : propertyValueServiceImpl.findById(type).getPropertyValue());
        return ProductName;
    }

    /**
     * 生成产品别名方法（格式是风格+型号+类型）
     *
     * @param product 产品实体对象
     */
    public String generateProductAliasName(Product product) {
        String code = product.getProductCode();//产品型号
        Integer style = Integer.parseInt(product.getProductStyle());//产品风格
        Integer type = Integer.parseInt(product.getProductType());//产品类型
        String ProductAliasName =
                (style == null ? "" : propertyValueServiceImpl.findById(style).getPropertyValue()) +
                        (code == null ? "" : code) +
                        (type == null ? "" : propertyValueServiceImpl.findById(type).getPropertyValue());
        return ProductAliasName;
    }

    /**
     * 查询产品并分页
     *
     * @param product 查询的产品实体
     * @param offset  页码
     * @param limit   单页条数
     * @param field   排序字段
     * @param sort    排序方式
     */
    @Override
    public Page<Product> findByPaging(Product product, int offset, int limit, String field, String sort) {
        //默认排序
        Direction sortThat = Direction.ASC;
        String fieldThat = "productId";
        //自定义排序
        if (sort != null && sort.equalsIgnoreCase("desc")) sortThat = Direction.DESC;
        if (field != null) fieldThat = field;
        PageRequest pageReq = new PageRequest(offset, limit, new Sort(sortThat, fieldThat));
        Page<Product> productList = productDao.findAll(createSpecification(product), pageReq);
        return productList;
    }

    /**
     * 创建产品分页查询规范
     *
     * @param product 查询的实体类
     * @return Specification<Product>
     */
    public Specification<Product> createSpecification(final Product product) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cbr) {
                List<Predicate> array = new ArrayList<>();
                //查询条件不为空
                if (product != null) {
                    if (product.getProductId() != null) {
                        Expression<Integer> expression = root.get("productId").as(Integer.class);
                        Predicate eq = cbr.equal(expression, product.getProductId());
                        array.add(eq);
                    }

                    if (product.getUserId() != null) {
                        Expression<Integer> expression = root.get("userId").as(Integer.class);
                        Predicate eq = cbr.equal(expression, product.getUserId());
                        array.add(eq);
                    }
                    if (product.getProductName() != null && !product.getProductName().isEmpty()) {
                        Expression<String> expression = root.get("productName").as(String.class);
                        Predicate like = cbr.like(expression, "%" + product.getProductName() + "%");
                        array.add(like);
                    }
                    if (product.getProductBrand() != null && !product.getProductBrand().isEmpty()) {
                        Expression<String> expression = root.get("productBrand").as(String.class);
                        Predicate like = cbr.like(expression, "%" + product.getProductBrand() + "%");
                        array.add(like);
                    }
                    if (product.getProductType() != null && !product.getProductType().isEmpty()) {
                        Expression<Integer> expression = root.get("productType").as(Integer.class);
                        String arr[] = product.getProductType().split(",");
                        ArrayList<Predicate> pdcs = new ArrayList<>();
                        for (String type : arr) {
                            Predicate equal = cbr.equal(expression, type);
                            pdcs.add(equal);
                        }
                        Predicate or = cbr.or(pdcs.toArray(new Predicate[pdcs.size()]));
                        array.add(or);
                    }
                    if (product.getProductStyle() != null && !product.getProductStyle().isEmpty()) {
                        Expression<String> expression = root.get("productStyle").as(String.class);
                        Predicate equal = cbr.equal(expression, product.getProductStyle());
                        array.add(equal);
                    }
                    if (product.getProductStatus() != null && product.getProductStatus() != 0) {
                        Expression<Integer> expression = root.get("productStatus").as(Integer.class);
                        Predicate equal = cbr.equal(expression, product.getProductStatus());
                        array.add(equal);
                    }

                    if (product.getProductSeries() != null && product.getProductSeries().getId() != null) {
                        Expression<Integer> expression = root.get("productSeries").get("id").as(Integer.class);
                        Predicate equal = cbr.equal(expression, product.getProductSeries().getId());
                        array.add(equal);
                    }
                    if (product.getProductKind() != null && product.getProductKind() != -1) {
                        Expression<Integer> expression = root.get("productKind").as(Integer.class);
                        Predicate equal = cbr.equal(expression, product.getProductKind());
                        array.add(equal);
                    }
                    if (product.getProductTag() != null && !product.getProductTag().isEmpty()) {
                        Expression<String> expression = root.get("productTag").as(String.class);
                        Predicate equal = cbr.equal(expression, product.getProductTag());
                        array.add(equal);
                    }
                }
                return query.where(array.toArray(new Predicate[array.size()])).getRestriction();
            }
        };
    }

    /**
     * 更新产品状态
     */
    @Override
    @Transactional
    public Map<String, Object> updateProducts(Integer[] ids, Integer status) {
        try {
            productDao.updateProducts(status, ids);
            return WebUtil.resposeAjax(true, "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.resposeAjax(false, "提交失败！");
        }
    }

    /**
     * 更新产品现货状态
     */
    @Override
    @Transactional
    public Map<String, Object> updataProductKind(Integer[] ids, Integer productKind) {
        try {
            productDao.updataProductKind(productKind, ids);
            return WebUtil.resposeAjax(true, "提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.resposeAjax(false, "提交失败！");
        }
    }

    /**
     * 删除产品,产品状态未审核，物理删除
     *
     * @param id 产品ID
     */
    public JSONObject deleteProduct(int id) {
        Product product = findById(id);
        if (product == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(203), "", null, null);
        if (product.getProductStatus() != 2) return WebUtil.resposeJSONObject(ReturnUtil.retParam(204), "", null, null);
        delete(product.getProductId());
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    /**
     * 修改产品库存
     */
    @Override
    public JSONObject modifyProductStock(int productId, int productStock) {
        Product product = productDao.findOne(productId);
        if (product == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(203), "", null, null);
        product.setProductStock(productStock);
        productDao.save(product);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    /**
     * 修改产品交货天数
     */
    @Override
    public JSONObject modifyDeliveryTime(int productId, int deliveryTime) {
        Product product = productDao.findOne(productId);
        if (product == null) WebUtil.resposeJSONObject(ReturnUtil.retParam(203), "", null, null);
        product.setDeliveryTime(deliveryTime);
        productDao.save(product);
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    /**
     * 查询热门商品 [分页]
     */
    @Override
    public Page<Product> findHotProducts(Integer offset, Integer limit) {
        Pageable pageRequest = new PageRequest(offset, limit, new Sort(Direction.DESC, "productId"));
        return productDao.findHotProducts(pageRequest);
    }

    /**
     * 修改产品
     */
    @Override
    public JSONObject modifyProduct(User user, Product product) {
        //检查是否有该产品
        Product productSource = findById(product.getProductId());
        if (productSource == null) return WebUtil.resposeJSONObject(ReturnUtil.retParam(203), "", null, null);

        String coverTemp[] = product.getCover().split(",");//轮播图
        String descriptionPicTemp[] = product.getDescriptionPic().split(",");//详情图
        String productPngPicTemp = product.getProductPngPic();//配灯图
        String productSpreadPicTemp = product.getProductSpreadPic();//每日推广图
        String threeCCertificationTemp = product.getThreeCCertification();//产品3C认证
        //设置轮播图
        List<String> cover = new ArrayList<>();
        for (int i = 0; i < coverTemp.length; i++) {
            if (coverTemp[i].indexOf("data:image") != -1) {//判断是否base64编码头,如果是将游标下一个编码字符串装换为文件名,然后删除当前游标下的base64头
                File file = ImageUtil.saveBase64(coverTemp[i + 1], ProductImageSrc, CommonUtil.getUUID(), "jpg");//将当前游标的下一个游标装换为图片文件
                cover.add(file.getName());
                i++;
            } else {
                cover.add(coverTemp[i]);
            }
        }
        product.setCover(CommonUtil.join(cover, ","));
        //设置详情图
        List<String> descriptionPic = new ArrayList<>();
        for (int i = 0; i < descriptionPicTemp.length; i++) {
            if (descriptionPicTemp[i].indexOf("data:image") != -1) {//判断是否base64编码头,如果是将游标下一个编码字符串装换为文件名,然后删除当前游标下的base64头
                File file = ImageUtil.saveBase64(descriptionPicTemp[i + 1], ProductImageSrc, CommonUtil.getUUID(), "jpg");//将当前游标的下一个游标装换为图片文件
                descriptionPic.add(file.getName());
                i++;
            } else {
                descriptionPic.add(descriptionPicTemp[i]);
            }
        }
        product.setDescriptionPic(CommonUtil.join(descriptionPic, ","));
        //配灯图
        if (productPngPicTemp.indexOf("data:image") != -1) {
            File file = ImageUtil.saveBase64(productPngPicTemp, ProductImageSrc, CommonUtil.getUUID(), "jpg");//将当前游标的下一个游标装换为图片文件
            product.setProductPngPic(file.getName());
        }
        //每日推广图
        if (productSpreadPicTemp.indexOf("data:image") != -1) {
            File file = ImageUtil.saveBase64(productSpreadPicTemp, ProductImageSrc, CommonUtil.getUUID(), "jpg");//将当前游标的下一个游标装换为图片文件
            product.setProductSpreadPic(file.getName());
        }
        //产品3C认证
        if (threeCCertificationTemp.indexOf("data:image") != -1) {
            File file = ImageUtil.saveBase64(threeCCertificationTemp, ProductImageSrc, CommonUtil.getUUID(), "jpg");//将当前游标的下一个游标装换为图片文件
            product.setThreeCCertification(file.getName());
        }
        try {
            product = (Product) CommonUtil.coverObject(product, productSource);
            //计算批发价和零售价
            float oup = product.getOriginUnitPrice();//出厂价
            float up = (float) Math.ceil((oup / 0.85));//批发价
            if ((up % 2) > 0) up++;//如果批发价为单数取整数
            float rp = up * (float) 2.5;//零售价
            product.setUnitPrice(up);
            product.setRetailPrice(rp);
            //生成产品别名
            product.setProductAliasName(generateProductAliasName(product));
            //生成产品名
            product.setProductName(generateProductName(user, product));
            productDao.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.resposeJSONObject(ReturnUtil.retParam(205), "", null, null);
        }
        return WebUtil.resposeJSONObject(ReturnUtil.retParam(1), "", null, null);
    }

    /**
     * 批量修改产品系列
     *
     * @param ids 产品ID
     * @param id  系列ID
     */
    @Transactional
    @Override
    public void updataSeries(Integer ids[], Integer id) {
        productDao.updataSeries(id, ids);
    }

    /**
     * 获取同系列的线上产品
     */
    @Override
    public List<Product> findSeriesProduct(ProductSeries productSeries) {
        return productDao.findByProductSeriesAndProductStatus(productSeries);
    }


    public int countBySeriesId(int seriesId) {
        return productDao.countByProductSeriesId(seriesId);
    }
}
